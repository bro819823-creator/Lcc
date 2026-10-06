package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.ai.LocalAiInferenceEngine
import com.example.data.local.StudyMateDatabase
import com.example.data.model.LanguageMode
import com.example.data.repository.CurriculumRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("StudyMate 10", appName)
  }

  @Test
  fun `verify curriculum repository loads subjects and chapters`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val db = StudyMateDatabase.getInstance(context)
    val repo = CurriculumRepository(db.curriculumDao())

    val subjects = repo.getAllSubjects()
    assertTrue(subjects.isNotEmpty())
    assertEquals(6, subjects.size)

    val mathSubject = subjects.find { it.id == "math" }
    assertNotNull(mathSubject)
    assertEquals("Mathematics", mathSubject?.name)
  }

  @Test
  fun `verify offline ai inference engine answers quadratic equation doubt`() = runBlocking {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val db = StudyMateDatabase.getInstance(context)
    val repo = CurriculumRepository(db.curriculumDao())
    val aiEngine = LocalAiInferenceEngine(repo)

    val response = aiEngine.processQuery(
      rawQuery = "quadratic equation formula kya hota hai",
      currentLanguageMode = LanguageMode.HINGLISH
    )

    assertNotNull(response)
    assertTrue(response.answerText.contains("Quadratic") || response.answerText.contains("formula") || response.answerText.contains("ax²"))
  }
}
