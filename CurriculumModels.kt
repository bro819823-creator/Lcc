package com.example.data.model

enum class LanguageMode(val displayName: String, val flag: String) {
    HINGLISH("Hinglish", "🔥"),
    HINDI("हिंदी", "🇮🇳"),
    ENGLISH("English", "🇬🇧")
}

data class Subject(
    val id: String,
    val name: String,
    val hindiName: String,
    val iconEmoji: String,
    val colorHex: Long,
    val orderIndex: Int,
    val description: String,
    val mpBoardTag: String = "MP Board Syllabus 2024-26"
)

data class Chapter(
    val id: String,
    val subjectId: String,
    val chapterNumber: Int,
    val titleEnglish: String,
    val titleHindi: String,
    val subCategory: String, // e.g. "Algebra", "Physics", "History", "First Flight", "Kshitij"
    val isIncludedInMpBoard: Boolean,
    val orderIndex: Int,
    val summaryHinglish: String,
    val summaryHindi: String,
    val summaryEnglish: String,
    val ncertReference: String
)

data class TopicConcept(
    val id: String,
    val chapterId: String,
    val title: String,
    val conceptsHinglish: String,
    val conceptsHindi: String,
    val conceptsEnglish: String,
    val simpleAnalogy: String, // For "Aur Simple Karo"
    val formulaOrKeyPoint: String
)

data class QuestionItem(
    val id: String,
    val chapterId: String,
    val subjectId: String,
    val type: String, // "VSA", "SA", "LA", "PRACTICE"
    val questionHinglish: String,
    val questionHindi: String,
    val questionEnglish: String,
    val solutionHinglish: String,
    val solutionHindi: String,
    val solutionEnglish: String,
    val formulaUsed: String,
    val marks: Int,
    val examTip: String
)

data class McqItem(
    val id: String,
    val chapterId: String,
    val subjectId: String,
    val questionHinglish: String,
    val questionHindi: String,
    val questionEnglish: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanationHinglish: String,
    val explanationHindi: String,
    val explanationEnglish: String
)

data class DiagramItem(
    val id: String,
    val chapterId: String,
    val subjectId: String,
    val title: String,
    val titleHindi: String,
    val type: String, // e.g. "CONCAVE_MIRROR", "ELECTRIC_CIRCUIT", "HUMAN_EYE", "MAGNETIC_SOLENOID", "STOMATA", "TRIGONOMETRY_TRIANGLE", "CIRCLE_TANGENTS", "COORDINATE_SYSTEM"
    val descriptionHinglish: String,
    val descriptionHindi: String,
    val descriptionEnglish: String,
    val labels: List<String>
)

data class SearchResult(
    val id: String,
    val title: String,
    val subtitle: String,
    val type: String, // "Chapter", "Formula", "Question", "Diagram", "Topic"
    val subjectId: String,
    val chapterId: String,
    val contentSnippet: String
)

data class ExamQuestionResult(
    val question: McqItem,
    val selectedIndex: Int,
    val isCorrect: Boolean
)

data class ExamSummary(
    val subjectId: String,
    val totalQuestions: Int,
    val correctAnswers: Int,
    val scorePercentage: Int,
    val grade: String,
    val weakTopics: List<String>,
    val recommendations: List<String>
)

data class SubjectProgress(
    val subjectId: String,
    val totalChapters: Int,
    val completedChapters: Int,
    val mcqQuestionsAttempted: Int,
    val mcqQuestionsCorrect: Int,
    val percentage: Int
)
