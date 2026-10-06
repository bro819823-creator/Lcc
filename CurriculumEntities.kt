package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapters")
data class ChapterEntity(
    @PrimaryKey val id: String,
    val subjectId: String,
    val chapterNumber: Int,
    val titleEnglish: String,
    val titleHindi: String,
    val subCategory: String,
    val isIncludedInMpBoard: Boolean,
    val orderIndex: Int,
    val summaryHinglish: String,
    val summaryHindi: String,
    val summaryEnglish: String,
    val ncertReference: String
)

@Entity(tableName = "study_progress")
data class StudyProgressEntity(
    @PrimaryKey val chapterId: String,
    val isCompleted: Boolean = false,
    val mcqsAttempted: Int = 0,
    val mcqsCorrect: Int = 0,
    val notesReadCount: Int = 0,
    val lastStudiedTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "exam_attempts")
data class ExamAttemptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val subjectId: String,
    val chapterId: String, // "ALL" or specific chapter
    val totalQuestions: Int,
    val correctAnswers: Int,
    val percentage: Int,
    val weakTopicsSummary: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "curriculum_config")
data class CurriculumConfigEntity(
    @PrimaryKey val key: String,
    val board: String = "MP Board",
    val className: String = "10",
    val academicSession: String = "2024-2026",
    val syllabusVersion: String = "v2.1",
    val lastUpdated: Long = System.currentTimeMillis()
)
