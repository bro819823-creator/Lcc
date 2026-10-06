package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CurriculumDao {

    @Query("SELECT * FROM chapters ORDER BY orderIndex ASC")
    fun getAllChapters(): Flow<List<ChapterEntity>>

    @Query("SELECT * FROM chapters WHERE subjectId = :subjectId ORDER BY orderIndex ASC")
    fun getChaptersBySubject(subjectId: String): Flow<List<ChapterEntity>>

    @Query("SELECT * FROM chapters WHERE subjectId = :subjectId AND isIncludedInMpBoard = 1 ORDER BY orderIndex ASC")
    fun getMpBoardChaptersBySubject(subjectId: String): Flow<List<ChapterEntity>>

    @Query("SELECT * FROM chapters WHERE id = :chapterId LIMIT 1")
    fun getChapterById(chapterId: String): Flow<ChapterEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChapters(chapters: List<ChapterEntity>)

    @Query("UPDATE chapters SET isIncludedInMpBoard = :isIncluded WHERE id = :chapterId")
    suspend fun updateChapterInclusion(chapterId: String, isIncluded: Boolean)

    @Query("SELECT * FROM study_progress")
    fun getAllProgress(): Flow<List<StudyProgressEntity>>

    @Query("SELECT * FROM study_progress WHERE chapterId = :chapterId LIMIT 1")
    fun getProgressForChapter(chapterId: String): Flow<StudyProgressEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: StudyProgressEntity)

    @Query("UPDATE study_progress SET isCompleted = :completed WHERE chapterId = :chapterId")
    suspend fun markChapterCompleted(chapterId: String, completed: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExamAttempt(attempt: ExamAttemptEntity): Long

    @Query("SELECT * FROM exam_attempts ORDER BY timestamp DESC")
    fun getAllExamAttempts(): Flow<List<ExamAttemptEntity>>

    @Query("SELECT * FROM curriculum_config WHERE `key` = 'main_config' LIMIT 1")
    fun getConfig(): Flow<CurriculumConfigEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveConfig(config: CurriculumConfigEntity)
}
