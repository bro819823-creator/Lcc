package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai.AiResponse
import com.example.ai.LocalAiInferenceEngine
import com.example.ai.LocalModelManager
import com.example.ai.LocalModelStatus
import com.example.data.local.ExamAttemptEntity
import com.example.data.local.StudyMateDatabase
import com.example.data.local.StudyProgressEntity
import com.example.data.model.Chapter
import com.example.data.model.DiagramItem
import com.example.data.model.ExamQuestionResult
import com.example.data.model.ExamSummary
import com.example.data.model.LanguageMode
import com.example.data.model.McqItem
import com.example.data.model.QuestionItem
import com.example.data.model.SearchResult
import com.example.data.model.Subject
import com.example.data.model.SubjectProgress
import com.example.data.model.TopicConcept
import com.example.data.repository.CurriculumRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ChatMessage(
    val id: String = System.currentTimeMillis().toString(),
    val sender: String, // "user" or "ai"
    val text: String,
    val diagram: DiagramItem? = null,
    val formula: String? = null,
    val isSimplified: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)

data class ActiveExamState(
    val subjectId: String,
    val questions: List<McqItem>,
    val currentIndex: Int = 0,
    val userAnswers: Map<Int, Int> = emptyMap(), // questionIndex -> selectedOption
    val isCompleted: Boolean = false,
    val remainingSeconds: Int = 600, // 10 minutes
    val summary: ExamSummary? = null
)

class StudyMateViewModel(application: Application) : AndroidViewModel(application) {

    private val db = StudyMateDatabase.getInstance(application)
    val repository = CurriculumRepository(db.curriculumDao())
    val aiEngine = LocalAiInferenceEngine(repository)

    // Language State
    private val _languageMode = MutableStateFlow(LanguageMode.HINGLISH)
    val languageMode: StateFlow<LanguageMode> = _languageMode.asStateFlow()

    // Model Status
    private val _modelStatus = MutableStateFlow(LocalModelManager.getDeviceModelStatus(application))
    val modelStatus: StateFlow<LocalModelStatus> = _modelStatus.asStateFlow()

    // Chapters from Room
    val allChapters: StateFlow<List<Chapter>> = repository.getAllChapters()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Progress from Room
    val allProgress: StateFlow<List<StudyProgressEntity>> = repository.getAllProgress()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Exam Attempts from Room
    val examAttempts: StateFlow<List<ExamAttemptEntity>> = repository.getAllExamAttempts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Chat / AI Doubts
    private val _chatMessages = MutableStateFlow<List<ChatMessage>>(
        listOf(
            ChatMessage(
                sender = "ai",
                text = "Namaste! Main hoon aapka StudyMate 10 AI. MP Board Class 10 ke kisi bhi subject (Maths, Science, SST, English, Hindi, Sanskrit) ka koi bhi doubt poocho!\n\nAgar koi topic mushkil lage, toh '🧠 Aur Simple Karo' tap karna."
            )
        )
    )
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages.asStateFlow()

    private val _isAiThinking = MutableStateFlow(false)
    val isAiThinking: StateFlow<Boolean> = _isAiThinking.asStateFlow()

    private var lastAiResponse: AiResponse? = null

    // Search
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<SearchResult>>(emptyList())
    val searchResults: StateFlow<List<SearchResult>> = _searchResults.asStateFlow()

    // Active Exam
    private val _activeExam = MutableStateFlow<ActiveExamState?>(null)
    val activeExam: StateFlow<ActiveExamState?> = _activeExam.asStateFlow()

    fun setLanguage(mode: LanguageMode) {
        _languageMode.value = mode
    }

    fun toggleMpBoardChapter(chapterId: String, isIncluded: Boolean) {
        viewModelScope.launch {
            repository.setChapterInclusion(chapterId, isIncluded)
        }
    }

    fun toggleChapterCompleted(chapterId: String, currentStatus: Boolean) {
        viewModelScope.launch {
            repository.markChapterCompleted(chapterId, !currentStatus)
        }
    }

    fun askAi(query: String) {
        if (query.isBlank()) return
        val userMsg = ChatMessage(sender = "user", text = query)
        _chatMessages.value = _chatMessages.value + userMsg
        _isAiThinking.value = true

        viewModelScope.launch {
            val response = aiEngine.processQuery(
                rawQuery = query,
                currentLanguageMode = _languageMode.value,
                previousResponse = lastAiResponse
            )
            lastAiResponse = response

            val aiMsg = ChatMessage(
                sender = "ai",
                text = response.answerText,
                diagram = response.suggestedDiagram,
                formula = response.formulaHighlighted,
                isSimplified = response.isSimplified
            )
            _chatMessages.value = _chatMessages.value + aiMsg
            _isAiThinking.value = false
        }
    }

    fun simplifyLastAiResponse() {
        if (lastAiResponse == null) {
            askAi("Isko ekdum simple me samjha")
            return
        }
        _isAiThinking.value = true
        viewModelScope.launch {
            val response = aiEngine.processQuery(
                rawQuery = "aur simple karo",
                currentLanguageMode = _languageMode.value,
                previousResponse = lastAiResponse
            )
            lastAiResponse = response

            val aiMsg = ChatMessage(
                sender = "ai",
                text = response.answerText,
                diagram = response.suggestedDiagram,
                formula = response.formulaHighlighted,
                isSimplified = true
            )
            _chatMessages.value = _chatMessages.value + aiMsg
            _isAiThinking.value = false
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            _searchResults.value = emptyList()
        } else {
            _searchResults.value = repository.performOfflineSearch(query)
        }
    }

    // Exam Mode Handlers
    fun startExam(subjectId: String, chapterId: String? = null, questionCount: Int = 10) {
        val pool = if (chapterId != null && chapterId != "ALL") {
            repository.getMcqsForChapter(chapterId)
        } else {
            repository.getMcqsForSubject(subjectId)
        }
        val questions = pool.shuffled().take(questionCount)
        if (questions.isEmpty()) return

        _activeExam.value = ActiveExamState(
            subjectId = subjectId,
            questions = questions,
            currentIndex = 0,
            userAnswers = emptyMap(),
            isCompleted = false,
            remainingSeconds = questions.size * 60
        )
    }

    fun selectExamAnswer(questionIndex: Int, optionIndex: Int) {
        val current = _activeExam.value ?: return
        val updatedAnswers = current.userAnswers.toMutableMap()
        updatedAnswers[questionIndex] = optionIndex
        _activeExam.value = current.copy(userAnswers = updatedAnswers)
    }

    fun nextExamQuestion() {
        val current = _activeExam.value ?: return
        if (current.currentIndex < current.questions.size - 1) {
            _activeExam.value = current.copy(currentIndex = current.currentIndex + 1)
        }
    }

    fun previousExamQuestion() {
        val current = _activeExam.value ?: return
        if (current.currentIndex > 0) {
            _activeExam.value = current.copy(currentIndex = current.currentIndex - 1)
        }
    }

    fun submitExam() {
        val current = _activeExam.value ?: return
        var correctCount = 0
        val weakTopicsList = mutableListOf<String>()

        current.questions.forEachIndexed { idx, q ->
            val userSelected = current.userAnswers[idx]
            if (userSelected != null && userSelected == q.correctOptionIndex) {
                correctCount++
            } else {
                weakTopicsList.add(q.questionHinglish.take(30) + "...")
            }
        }

        val percentage = if (current.questions.isNotEmpty()) (correctCount * 100) / current.questions.size else 0
        val grade = when {
            percentage >= 90 -> "A+ (Excellent • MP Board Topper Level)"
            percentage >= 75 -> "A (Very Good • Strong Concept Clarity)"
            percentage >= 50 -> "B (Good • Revision Needed in Weak Areas)"
            else -> "Needs Revision (Practice Recommended)"
        }

        val recommendations = mutableListOf<String>()
        if (percentage < 70) {
            recommendations.add("Notes & Formulas section se daily 20 minutes revision karein")
            recommendations.add("Important Questions ke step-by-step solutions ko practice karein")
        } else {
            recommendations.add("Great speed! Keep practicing diagrams and full-length answer writing")
        }

        val summary = ExamSummary(
            subjectId = current.subjectId,
            totalQuestions = current.questions.size,
            correctAnswers = correctCount,
            scorePercentage = percentage,
            grade = grade,
            weakTopics = weakTopicsList.distinct().take(4),
            recommendations = recommendations
        )

        _activeExam.value = current.copy(isCompleted = true, summary = summary)

        // Save into Room
        viewModelScope.launch {
            repository.saveExamAttempt(
                ExamAttemptEntity(
                    subjectId = current.subjectId,
                    chapterId = "EXAM",
                    totalQuestions = current.questions.size,
                    correctAnswers = correctCount,
                    percentage = percentage,
                    weakTopicsSummary = weakTopicsList.take(3).joinToString(", ")
                )
            )
            // Update MCQ stats
            repository.recordMcqAttempt(current.subjectId, current.questions.size, correctCount)
        }
    }

    fun resetExam() {
        _activeExam.value = null
    }

    fun recordImmediateMcq(chapterId: String, isCorrect: Boolean) {
        viewModelScope.launch {
            repository.recordMcqAttempt(chapterId, 1, if (isCorrect) 1 else 0)
        }
    }

    fun refreshModelStatus() {
        _modelStatus.value = LocalModelManager.getDeviceModelStatus(getApplication())
    }
}
