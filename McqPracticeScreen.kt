package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.LanguageMode
import com.example.ui.StudyMateViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun McqPracticeScreen(
    viewModel: StudyMateViewModel,
    onBack: () -> Unit
) {
    val languageMode by viewModel.languageMode.collectAsState()
    val subjects = viewModel.repository.getAllSubjects()
    var selectedSubjectId by remember { mutableStateOf<String?>("ALL") }

    val allMcqs = viewModel.repository.getAllMcqs()
    val filteredMcqs = if (selectedSubjectId == "ALL" || selectedSubjectId == null) {
        allMcqs
    } else {
        allMcqs.filter { it.subjectId == selectedSubjectId }
    }

    val selectedAnswers = remember { mutableStateMapOf<String, Int>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "MCQ Practice Hub",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Instant Feedback & Explanations",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("back_button")) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Subject Filter Chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    FilterChip(
                        selected = selectedSubjectId == "ALL",
                        onClick = { selectedSubjectId = "ALL" },
                        label = { Text("All Subjects (${allMcqs.size})") }
                    )
                }
                items(subjects) { subj ->
                    val count = allMcqs.count { it.subjectId == subj.id }
                    FilterChip(
                        selected = selectedSubjectId == subj.id,
                        onClick = { selectedSubjectId = subj.id },
                        label = { Text("${subj.iconEmoji} ${subj.name} ($count)") }
                    )
                }
            }

            // MCQs List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(filteredMcqs) { mcq ->
                    val userSelected = selectedAnswers[mcq.id]
                    val isAnswered = userSelected != null

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = when (languageMode) {
                                    LanguageMode.HINDI -> mcq.questionHindi
                                    LanguageMode.ENGLISH -> mcq.questionEnglish
                                    LanguageMode.HINGLISH -> mcq.questionHinglish
                                },
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 22.sp
                            )
                            Spacer(modifier = Modifier.height(12.dp))

                            mcq.options.forEachIndexed { optIndex, optionText ->
                                val isThisSelected = userSelected == optIndex
                                val isCorrectOption = optIndex == mcq.correctOptionIndex

                                val bgColor = when {
                                    !isAnswered -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                                    isThisSelected && isCorrectOption -> Color(0xFF10B981).copy(alpha = 0.2f)
                                    isThisSelected && !isCorrectOption -> Color(0xFFEF4444).copy(alpha = 0.2f)
                                    isCorrectOption -> Color(0xFF10B981).copy(alpha = 0.15f)
                                    else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                                }

                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                        .clickable(enabled = !isAnswered) {
                                            selectedAnswers[mcq.id] = optIndex
                                            viewModel.recordImmediateMcq(mcq.chapterId, optIndex == mcq.correctOptionIndex)
                                        },
                                    shape = RoundedCornerShape(10.dp),
                                    color = bgColor
                                ) {
                                    Row(
                                        modifier = Modifier.padding(10.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = isThisSelected,
                                            onClick = null
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = optionText,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = if (isThisSelected) FontWeight.Bold else FontWeight.Normal
                                        )
                                    }
                                }
                            }

                            if (isAnswered) {
                                Spacer(modifier = Modifier.height(12.dp))
                                Surface(
                                    color = Color(0xFF0F172A),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Text(
                                            text = if (userSelected == mcq.correctOptionIndex) "✅ Sahi Jawab! (+1 Mark)" else "❌ Galat Jawab (Sahi: Option ${mcq.correctOptionIndex + 1})",
                                            fontWeight = FontWeight.Bold,
                                            color = if (userSelected == mcq.correctOptionIndex) Color(0xFF34D399) else Color(0xFFF87171),
                                            fontSize = 13.sp
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = when (languageMode) {
                                                LanguageMode.HINDI -> mcq.explanationHindi
                                                LanguageMode.ENGLISH -> mcq.explanationEnglish
                                                LanguageMode.HINGLISH -> mcq.explanationHinglish
                                            },
                                            color = Color(0xFFE2E8F0),
                                            fontSize = 12.sp,
                                            lineHeight = 18.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
