package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        ChapterEntity::class,
        StudyProgressEntity::class,
        ExamAttemptEntity::class,
        CurriculumConfigEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class StudyMateDatabase : RoomDatabase() {

    abstract fun curriculumDao(): CurriculumDao

    companion object {
        @Volatile
        private var INSTANCE: StudyMateDatabase? = null

        fun getInstance(context: Context): StudyMateDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudyMateDatabase::class.java,
                    "studymate10_database"
                ).fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
