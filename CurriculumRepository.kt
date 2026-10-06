package com.example.data.repository

import com.example.data.local.ChapterEntity
import com.example.data.local.CurriculumDao
import com.example.data.local.CurriculumConfigEntity
import com.example.data.local.ExamAttemptEntity
import com.example.data.local.StudyProgressEntity
import com.example.data.model.Chapter
import com.example.data.model.DiagramItem
import com.example.data.model.ExamSummary
import com.example.data.model.McqItem
import com.example.data.model.QuestionItem
import com.example.data.model.SearchResult
import com.example.data.model.Subject
import com.example.data.model.SubjectProgress
import com.example.data.model.TopicConcept
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CurriculumRepository(
    private val dao: CurriculumDao,
    private val externalScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) {

    init {
        externalScope.launch {
            seedInitialDataIfNeeded()
        }
    }

    private suspend fun seedInitialDataIfNeeded() {
        val currentChapters = dao.getAllChapters().first()
        if (currentChapters.isEmpty()) {
            dao.insertChapters(InitialCurriculumData.getDefaultChapters())
            dao.saveConfig(
                CurriculumConfigEntity(
                    key = "main_config",
                    board = "MP Board (Madhya Pradesh Board)",
                    className = "10",
                    academicSession = "2024-2026",
                    syllabusVersion = "MPBSE-NCERT-v2.1"
                )
            )
        }
    }

    fun getAllSubjects(): List<Subject> = InitialCurriculumData.SUBJECTS

    fun getSubjectById(subjectId: String): Subject? {
        return InitialCurriculumData.SUBJECTS.find { it.id == subjectId }
    }

    fun getMpBoardChapters(subjectId: String): Flow<List<Chapter>> {
        return dao.getMpBoardChaptersBySubject(subjectId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    fun getAllChaptersForSubject(subjectId: String): Flow<List<Chapter>> {
        return dao.getChaptersBySubject(subjectId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    fun getAllChapters(): Flow<List<Chapter>> {
        return dao.getAllChapters().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    fun getChapterById(chapterId: String): Flow<Chapter?> {
        return dao.getChapterById(chapterId).map { it?.toDomain() }
    }

    suspend fun setChapterInclusion(chapterId: String, isIncluded: Boolean) {
        dao.updateChapterInclusion(chapterId, isIncluded)
    }

    // TOPICS
    fun getTopicsForChapter(chapterId: String): List<TopicConcept> {
        val allTopics = MathCurriculumContent.TOPICS +
                ScienceCurriculumContent.TOPICS +
                SstCurriculumContent.TOPICS +
                LanguageCurriculumContent.TOPICS
        return allTopics.filter { it.chapterId == chapterId }
    }

    fun getAllTopics(): List<TopicConcept> {
        return MathCurriculumContent.TOPICS +
                ScienceCurriculumContent.TOPICS +
                SstCurriculumContent.TOPICS +
                LanguageCurriculumContent.TOPICS
    }

    // QUESTIONS
    fun getQuestionsForChapter(chapterId: String): List<QuestionItem> {
        val allQuestions = MathCurriculumContent.QUESTIONS +
                ScienceCurriculumContent.QUESTIONS +
                SstCurriculumContent.QUESTIONS +
                LanguageCurriculumContent.QUESTIONS
        return allQuestions.filter { it.chapterId == chapterId }
    }

    fun getQuestionsForSubject(subjectId: String): List<QuestionItem> {
        val allQuestions = MathCurriculumContent.QUESTIONS +
                ScienceCurriculumContent.QUESTIONS +
                SstCurriculumContent.QUESTIONS +
                LanguageCurriculumContent.QUESTIONS
        return allQuestions.filter { it.subjectId == subjectId }
    }

    fun getAllQuestions(): List<QuestionItem> {
        return MathCurriculumContent.QUESTIONS +
                ScienceCurriculumContent.QUESTIONS +
                SstCurriculumContent.QUESTIONS +
                LanguageCurriculumContent.QUESTIONS
    }

    // MCQS
    fun getMcqsForChapter(chapterId: String): List<McqItem> {
        val allMcqs = MathCurriculumContent.MCQS +
                ScienceCurriculumContent.MCQS +
                SstCurriculumContent.MCQS +
                LanguageCurriculumContent.MCQS
        return allMcqs.filter { it.chapterId == chapterId }
    }

    fun getMcqsForSubject(subjectId: String): List<McqItem> {
        val allMcqs = MathCurriculumContent.MCQS +
                ScienceCurriculumContent.MCQS +
                SstCurriculumContent.MCQS +
                LanguageCurriculumContent.MCQS
        return allMcqs.filter { it.subjectId == subjectId }
    }

    fun getAllMcqs(): List<McqItem> {
        return MathCurriculumContent.MCQS +
                ScienceCurriculumContent.MCQS +
                SstCurriculumContent.MCQS +
                LanguageCurriculumContent.MCQS
    }

    // DIAGRAMS
    fun getDiagramsForChapter(chapterId: String): List<DiagramItem> {
        val allDiagrams = MathCurriculumContent.DIAGRAMS + ScienceCurriculumContent.DIAGRAMS
        return allDiagrams.filter { it.chapterId == chapterId }
    }

    fun getDiagramsForSubject(subjectId: String): List<DiagramItem> {
        val allDiagrams = MathCurriculumContent.DIAGRAMS + ScienceCurriculumContent.DIAGRAMS
        return allDiagrams.filter { it.subjectId == subjectId }
    }

    fun getAllDiagrams(): List<DiagramItem> {
        return MathCurriculumContent.DIAGRAMS + ScienceCurriculumContent.DIAGRAMS
    }

    fun getDiagramById(diagramId: String): DiagramItem? {
        return getAllDiagrams().find { it.id == diagramId }
    }

    // SEARCH
    fun performOfflineSearch(query: String): List<SearchResult> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        val results = mutableListOf<SearchResult>()

        // 1. Search in Chapters
        InitialCurriculumData.getDefaultChapters().forEach { ch ->
            if (ch.titleEnglish.lowercase().contains(q) ||
                ch.titleHindi.contains(q) ||
                ch.summaryHinglish.lowercase().contains(q) ||
                ch.subCategory.lowercase().contains(q)
            ) {
                results.add(
                    SearchResult(
                        id = ch.id,
                        title = "${ch.titleEnglish} (${ch.titleHindi})",
                        subtitle = "Chapter ${ch.chapterNumber} • ${ch.subCategory}",
                        type = "Chapter",
                        subjectId = ch.subjectId,
                        chapterId = ch.id,
                        contentSnippet = ch.summaryHinglish
                    )
                )
            }
        }

        // 2. Search in Topics & Formulas
        getAllTopics().forEach { top ->
            if (top.title.lowercase().contains(q) ||
                top.conceptsHinglish.lowercase().contains(q) ||
                top.formulaOrKeyPoint.lowercase().contains(q) ||
                top.simpleAnalogy.lowercase().contains(q)
            ) {
                val ch = InitialCurriculumData.getDefaultChapters().find { it.id == top.chapterId }
                results.add(
                    SearchResult(
                        id = top.id,
                        title = top.title,
                        subtitle = "Formula & Concept • ${ch?.titleEnglish ?: ""}",
                        type = if (top.formulaOrKeyPoint.contains("=")) "Formula" else "Topic",
                        subjectId = ch?.subjectId ?: "math",
                        chapterId = top.chapterId,
                        contentSnippet = top.formulaOrKeyPoint.ifBlank { top.conceptsHinglish }
                    )
                )
            }
        }

        // 3. Search in Questions
        getAllQuestions().forEach { ques ->
            if (ques.questionHinglish.lowercase().contains(q) ||
                ques.questionHindi.contains(q) ||
                ques.solutionHinglish.lowercase().contains(q) ||
                ques.formulaUsed.lowercase().contains(q)
            ) {
                results.add(
                    SearchResult(
                        id = ques.id,
                        title = ques.questionHinglish,
                        subtitle = "${ques.type} Question • ${ques.marks} Marks",
                        type = "Question",
                        subjectId = ques.subjectId,
                        chapterId = ques.chapterId,
                        contentSnippet = ques.solutionHinglish
                    )
                )
            }
        }

        // 4. Search in Diagrams
        getAllDiagrams().forEach { diag ->
            if (diag.title.lowercase().contains(q) ||
                diag.titleHindi.contains(q) ||
                diag.descriptionHinglish.lowercase().contains(q) ||
                diag.labels.any { it.lowercase().contains(q) }
            ) {
                results.add(
                    SearchResult(
                        id = diag.id,
                        title = "🖼️ ${diag.title}",
                        subtitle = "Diagram • ${diag.titleHindi}",
                        type = "Diagram",
                        subjectId = diag.subjectId,
                        chapterId = diag.chapterId,
                        contentSnippet = diag.descriptionHinglish
                    )
                )
            }
        }

        return results.take(25)
    }

    // PROGRESS
    fun getAllProgress(): Flow<List<StudyProgressEntity>> = dao.getAllProgress()

    fun getProgressForChapter(chapterId: String): Flow<StudyProgressEntity?> =
        dao.getProgressForChapter(chapterId)

    suspend fun markChapterCompleted(chapterId: String, completed: Boolean) {
        val existing = dao.getProgressForChapter(chapterId).first()
        if (existing != null) {
            dao.saveProgress(existing.copy(isCompleted = completed, lastStudiedTimestamp = System.currentTimeMillis()))
        } else {
            dao.saveProgress(
                StudyProgressEntity(
                    chapterId = chapterId,
                    isCompleted = completed,
                    lastStudiedTimestamp = System.currentTimeMillis()
                )
            )
        }
    }

    suspend fun recordMcqAttempt(chapterId: String, attempted: Int, correct: Int) {
        val existing = dao.getProgressForChapter(chapterId).first()
        if (existing != null) {
            dao.saveProgress(
                existing.copy(
                    mcqsAttempted = existing.mcqsAttempted + attempted,
                    mcqsCorrect = existing.mcqsCorrect + correct,
                    lastStudiedTimestamp = System.currentTimeMillis()
                )
            )
        } else {
            dao.saveProgress(
                StudyProgressEntity(
                    chapterId = chapterId,
                    mcqsAttempted = attempted,
                    mcqsCorrect = correct,
                    lastStudiedTimestamp = System.currentTimeMillis()
                )
            )
        }
    }

    suspend fun saveExamAttempt(attempt: ExamAttemptEntity): Long {
        return dao.insertExamAttempt(attempt)
    }

    fun getAllExamAttempts(): Flow<List<ExamAttemptEntity>> = dao.getAllExamAttempts()

    fun getConfig(): Flow<CurriculumConfigEntity?> = dao.getConfig()

    private fun ChapterEntity.toDomain() = Chapter(
        id = id,
        subjectId = subjectId,
        chapterNumber = chapterNumber,
        titleEnglish = titleEnglish,
        titleHindi = titleHindi,
        subCategory = subCategory,
        isIncludedInMpBoard = isIncludedInMpBoard,
        orderIndex = orderIndex,
        summaryHinglish = summaryHinglish,
        summaryHindi = summaryHindi,
        summaryEnglish = summaryEnglish,
        ncertReference = ncertReference
    )
}
