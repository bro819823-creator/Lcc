package com.example.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.screens.AiDoubtSolverScreen
import com.example.ui.screens.ChapterDetailScreen
import com.example.ui.screens.CurriculumConfigScreen
import com.example.ui.screens.ExamModeScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ImportantQuestionsScreen
import com.example.ui.screens.McqPracticeScreen
import com.example.ui.screens.NotesAndFormulasScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.SubjectsScreen

object Destinations {
    const val HOME = "home"
    const val AI_CHAT = "ai_chat?prompt={prompt}"
    const val SUBJECTS = "subjects"
    const val CHAPTER_DETAIL = "chapter/{chapterId}"
    const val EXAM_MODE = "exam_mode"
    const val MCQ_PRACTICE = "mcq_practice"
    const val IMPORTANT_QUESTIONS = "important_questions"
    const val NOTES_FORMULAS = "notes_formulas"
    const val PROGRESS = "progress"
    const val CURRICULUM_CONFIG = "curriculum_config"

    fun aiChatWithPrompt(prompt: String): String {
        return "ai_chat?prompt=${java.net.URLEncoder.encode(prompt, "UTF-8")}"
    }

    fun chapterDetail(chapterId: String): String {
        return "chapter/$chapterId"
    }
}

@Composable
fun StudyMateNavHost(
    viewModel: StudyMateViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HOME,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Destinations.HOME) {
            HomeScreen(
                viewModel = viewModel,
                onNavigateToAiChat = { navController.navigate("ai_chat") },
                onNavigateToSubjects = { navController.navigate(Destinations.SUBJECTS) },
                onNavigateToChapter = { chId -> navController.navigate(Destinations.chapterDetail(chId)) },
                onNavigateToExamMode = { navController.navigate(Destinations.EXAM_MODE) },
                onNavigateToMcqPractice = { navController.navigate(Destinations.MCQ_PRACTICE) },
                onNavigateToImportantQuestions = { navController.navigate(Destinations.IMPORTANT_QUESTIONS) },
                onNavigateToNotes = { navController.navigate(Destinations.NOTES_FORMULAS) },
                onNavigateToProgress = { navController.navigate(Destinations.PROGRESS) },
                onNavigateToCurriculumConfig = { navController.navigate(Destinations.CURRICULUM_CONFIG) },
                onAskAiWithPrompt = { prompt ->
                    navController.navigate(Destinations.aiChatWithPrompt(prompt))
                }
            )
        }

        composable(
            route = Destinations.AI_CHAT,
            arguments = listOf(navArgument("prompt") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })
        ) { backStackEntry ->
            val prompt = backStackEntry.arguments?.getString("prompt")
            AiDoubtSolverScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                initialPrompt = prompt
            )
        }

        composable(Destinations.SUBJECTS) {
            SubjectsScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onNavigateToChapter = { chId -> navController.navigate(Destinations.chapterDetail(chId)) }
            )
        }

        composable(
            route = Destinations.CHAPTER_DETAIL,
            arguments = listOf(navArgument("chapterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chapterId = backStackEntry.arguments?.getString("chapterId") ?: ""
            ChapterDetailScreen(
                chapterId = chapterId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onAskAiAboutTopic = { query ->
                    navController.navigate(Destinations.aiChatWithPrompt(query))
                }
            )
        }

        composable(Destinations.EXAM_MODE) {
            ExamModeScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destinations.MCQ_PRACTICE) {
            McqPracticeScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destinations.IMPORTANT_QUESTIONS) {
            ImportantQuestionsScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onAskAi = { prompt -> navController.navigate(Destinations.aiChatWithPrompt(prompt)) }
            )
        }

        composable(Destinations.NOTES_FORMULAS) {
            NotesAndFormulasScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onAskAi = { prompt -> navController.navigate(Destinations.aiChatWithPrompt(prompt)) }
            )
        }

        composable(Destinations.PROGRESS) {
            ProgressScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destinations.CURRICULUM_CONFIG) {
            CurriculumConfigScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
