package com.example.ai

import com.example.data.model.Chapter
import com.example.data.model.DiagramItem
import com.example.data.model.LanguageMode
import com.example.data.model.Subject
import com.example.data.repository.CurriculumRepository

data class AiResponse(
    val answerText: String,
    val languageMode: LanguageMode,
    val suggestedDiagram: DiagramItem? = null,
    val matchedSubject: Subject? = null,
    val matchedChapter: Chapter? = null,
    val formulaHighlighted: String? = null,
    val isSimplified: Boolean = false,
    val examReadyVersion: String? = null
)

class LocalAiInferenceEngine(
    private val repository: CurriculumRepository
) {

    suspend fun processQuery(
        rawQuery: String,
        currentLanguageMode: LanguageMode,
        previousResponse: AiResponse? = null
    ): AiResponse {
        val query = rawQuery.trim()
        val lowerQuery = query.lowercase()

        // 1. Language override detection
        val effectiveLanguage = when {
            lowerQuery.contains("hindi me") || lowerQuery.contains("हिंदी") -> LanguageMode.HINDI
            lowerQuery.contains("english me") || lowerQuery.contains("in english") -> LanguageMode.ENGLISH
            lowerQuery.contains("hinglish me") || lowerQuery.contains("हिंग्लिश") -> LanguageMode.HINGLISH
            else -> currentLanguageMode
        }

        // 2. "Simple me samjha" / "Aur Simple Karo" trigger detection
        val isSimplifyRequested = lowerQuery.contains("simple") ||
                lowerQuery.contains("easy") ||
                lowerQuery.contains("samjha nahi") ||
                lowerQuery.contains("chote me") ||
                lowerQuery.contains("bata do bhai") ||
                lowerQuery.contains("aur easy")

        // 3. Diagram request detection
        val isDiagramRequested = lowerQuery.contains("diagram") ||
                lowerQuery.contains("chitra") ||
                lowerQuery.contains("figure") ||
                lowerQuery.contains("आरेख") ||
                lowerQuery.contains("चित्र")

        // 4. Exam-ready request detection
        val isExamReadyRequested = lowerQuery.contains("exam") ||
                lowerQuery.contains("pariksha") ||
                lowerQuery.contains("short answer") ||
                lowerQuery.contains("marks") ||
                lowerQuery.contains("point me")

        // If user tapped "Aur Simple Karo" on a previous topic
        if (isSimplifyRequested && previousResponse != null) {
            return generateSimplifiedResponse(previousResponse, effectiveLanguage)
        }

        // 5. Subject & Concept Router
        val allTopics = repository.getAllTopics()
        val allQuestions = repository.getAllQuestions()
        val allDiagrams = repository.getAllDiagrams()
        val allSubjects = repository.getAllSubjects()

        // Match Diagram if explicitly requested
        val matchedDiagram = if (isDiagramRequested) {
            allDiagrams.find { diag ->
                lowerQuery.contains(diag.type.lowercase().replace("_", " ")) ||
                        diag.labels.any { lowerQuery.contains(it.lowercase()) } ||
                        diag.title.lowercase().split(" ").any { it.length > 3 && lowerQuery.contains(it) }
            } ?: allDiagrams.firstOrNull()
        } else {
            allDiagrams.find { diag ->
                diag.labels.any { lowerQuery.contains(it.lowercase()) } ||
                        diag.title.lowercase().split(" ").any { it.length > 4 && lowerQuery.contains(it) }
            }
        }

        // Match Specific Question (e.g. "solve 2x² - 7x + 3", "prove √5", "ohm's law", "lencho")
        val matchedQuestion = allQuestions.find { q ->
            lowerQuery.contains(q.questionHinglish.take(20).lowercase()) ||
                    lowerQuery.split(" ").count { word ->
                        word.length > 3 && (q.questionHinglish.lowercase().contains(word) || q.solutionHinglish.lowercase().contains(word))
                    } >= 2
        }

        // Match Topic
        val matchedTopic = allTopics.find { t ->
            lowerQuery.contains(t.title.lowercase()) ||
                    t.title.lowercase().split(" ").any { it.length > 4 && lowerQuery.contains(it) } ||
                    lowerQuery.contains(t.formulaOrKeyPoint.take(10).lowercase())
        }

        // Construct Answer
        if (matchedQuestion != null) {
            val subject = allSubjects.find { it.id == matchedQuestion.subjectId }
            val answer = when (effectiveLanguage) {
                LanguageMode.HINGLISH -> {
                    val base = "Haan bhai! Is question ko step-by-step solve karte hain:\n\n" +
                            "${matchedQuestion.solutionHinglish}\n\n" +
                            "📌 Important Exam Tip: ${matchedQuestion.examTip}"
                    if (isSimplifyRequested) "$base\n\n💡 Simple Analogy: Yaad rakhne ke liye breaks aur step-wise formulas ko follow karein!" else base
                }
                LanguageMode.HINDI -> {
                    "यह महत्वपूर्ण प्रश्न एमपी बोर्ड परीक्षा हेतु उपयोगी है:\n\n" +
                            "${matchedQuestion.solutionHindi}\n\n" +
                            "📌 परीक्षा उपयोगी सुझाव: ${matchedQuestion.examTip}"
                }
                LanguageMode.ENGLISH -> {
                    "Step-by-step solution according to MP Board standard:\n\n" +
                            "${matchedQuestion.solutionEnglish}\n\n" +
                            "📌 Exam Tip: ${matchedQuestion.examTip}"
                }
            }

            val finalAnswer = if (matchedDiagram != null) {
                when (effectiveLanguage) {
                    LanguageMode.HINDI -> "$answer\n\n🖼️ संबंधित आरेख नीचे देखें 👇"
                    LanguageMode.ENGLISH -> "$answer\n\n🖼️ See the relevant diagram below 👇"
                    LanguageMode.HINGLISH -> "$answer\n\nDiagram dekho 👇 Isse concept crystal clear ho jayega!"
                }
            } else answer

            return AiResponse(
                answerText = finalAnswer,
                languageMode = effectiveLanguage,
                suggestedDiagram = matchedDiagram,
                matchedSubject = subject,
                formulaHighlighted = matchedQuestion.formulaUsed.ifBlank { null },
                examReadyVersion = matchedQuestion.solutionEnglish
            )
        }

        if (matchedTopic != null) {
            val subject = allSubjects.find { it.id == (if (matchedTopic.chapterId.startsWith("math")) "math" else if (matchedTopic.chapterId.startsWith("sci")) "science" else if (matchedTopic.chapterId.startsWith("sst")) "sst" else "english") }
            val answer = when (effectiveLanguage) {
                LanguageMode.HINGLISH -> {
                    if (isSimplifyRequested) {
                        "Chalo isko ekdum simple daily-life example se samajhte hain:\n\n" +
                                "💡 ${matchedTopic.simpleAnalogy}\n\n" +
                                "1. Pehle formula ya concept dekho: ${matchedTopic.formulaOrKeyPoint}\n" +
                                "2. Short summary: ${matchedTopic.conceptsHinglish}\n\n" +
                                "Ab clear hua? Aur doubt ho toh pooch lo!"
                    } else {
                        "Dekho bhai, ${matchedTopic.title} ko samajhte hain:\n\n" +
                                "${matchedTopic.conceptsHinglish}\n\n" +
                                "📐 Main Formula / Key Point: ${matchedTopic.formulaOrKeyPoint}\n\n" +
                                "💡 Asli Life Analogy: ${matchedTopic.simpleAnalogy}"
                    }
                }
                LanguageMode.HINDI -> {
                    "विषय: ${matchedTopic.title}\n\n" +
                            "${matchedTopic.conceptsHindi}\n\n" +
                            "📌 मुख्य बिंदु / सूत्र: ${matchedTopic.formulaOrKeyPoint}\n\n" +
                            "💡 सरल उदाहरण: ${matchedTopic.simpleAnalogy}"
                }
                LanguageMode.ENGLISH -> {
                    "Topic: ${matchedTopic.title}\n\n" +
                            "${matchedTopic.conceptsEnglish}\n\n" +
                            "📌 Formula & Key Point: ${matchedTopic.formulaOrKeyPoint}\n\n" +
                            "💡 Analogy: ${matchedTopic.simpleAnalogy}"
                }
            }

            val finalAnswer = if (matchedDiagram != null) {
                when (effectiveLanguage) {
                    LanguageMode.HINDI -> "$answer\n\n🖼️ संबंधित आरेख नीचे दिया गया है 👇"
                    LanguageMode.ENGLISH -> "$answer\n\n🖼️ Related diagram attached below 👇"
                    LanguageMode.HINGLISH -> "$answer\n\nDiagram dekho 👇 Isse visually jaldi samajh aayega!"
                }
            } else answer

            return AiResponse(
                answerText = finalAnswer,
                languageMode = effectiveLanguage,
                suggestedDiagram = matchedDiagram,
                matchedSubject = subject,
                formulaHighlighted = matchedTopic.formulaOrKeyPoint
            )
        }

        // Generic friendly educational response
        val fallbackText = when (effectiveLanguage) {
            LanguageMode.HINGLISH -> {
                "Haan bhai! Main Class 10 MP Board ke liye ready hoon.\n\n" +
                        "Aap mujhse kisi bhi subject ke bare me pooch sakte ho jaise:\n" +
                        "• 'Bhai quadratic equation samjha'\n" +
                        "• 'Ohm's law simple me samjha'\n" +
                        "• 'Concave mirror ka ray diagram dikha'\n" +
                        "• 'Lencho ka letter to God Hindi me bata'\n" +
                        "• 'Jallianwala Bagh ke causes exam format me do'\n\n" +
                        "Agar koi topic samajh na aaye, toh '🧠 Aur Simple Karo' tap kar dena!"
            }
            LanguageMode.HINDI -> {
                "नमस्ते! मैं आपका एमपी बोर्ड कक्षा 10 का ऑफलाइन एआई साथी हूँ।\n\n" +
                        "आप गणित, विज्ञान, सामाजिक विज्ञान, अंग्रेजी, हिंदी या संस्कृत के किसी भी अध्याय, सूत्र अथवा प्रश्न के बारे में पूछ सकते हैं।\n" +
                        "उत्तर को और सरल समझने के लिए '🧠 और सरल करो' का उपयोग करें।"
            }
            LanguageMode.ENGLISH -> {
                "Hello! I am your Class 10 MP Board offline study assistant.\n\n" +
                        "Ask me anything from Mathematics, Science, Social Science, English, Hindi, or Sanskrit.\n" +
                        "You can also request step-by-step solutions, diagrams, or tap '🧠 Aur Simple Karo' to simplify any concept."
            }
        }

        return AiResponse(
            answerText = fallbackText,
            languageMode = effectiveLanguage,
            suggestedDiagram = matchedDiagram
        )
    }

    private fun generateSimplifiedResponse(
        previousResponse: AiResponse,
        languageMode: LanguageMode
    ): AiResponse {
        val originalText = previousResponse.answerText
        val simplifiedText = when (languageMode) {
            LanguageMode.HINGLISH -> {
                "🧠 Aur Simple me samajhte hain (Bina kisi mushkil technical shabd ke):\n\n" +
                        "1. Basic Baat: Iska main idea bas itna hai ki step-by-step choti cheezon ko jodna hai.\n\n" +
                        "2. Daily-Life Example: Jaise chai banane ke liye pehle paani ubalte hain, fir patti aur doodh dalte hain, waise hi pehle formula likha jata hai fir values substitute ki jaati hain!\n\n" +
                        "3. Exam Yaad Rakhne Ka Tarika: Hamesha given values pehle list karo, taaki calculation me koi mistake na ho.\n\n" +
                        "---\n" +
                        "Pichla context:\n${originalText.lines().take(6).joinToString("\n")}"
            }
            LanguageMode.HINDI -> {
                "🧠 और सरल रूप में समझें:\n\n" +
                        "1. मूल विचार: इस अवधारणा को छोटे-छोटे 3 चरणों में याद रखें।\n" +
                        "2. दैनिक उदाहरण: जैसे सीढ़ी पर एक-एक पायदान चढ़ा जाता है, वैसे ही गणित और विज्ञान में प्रत्येक चरण के अलग अंक होते हैं।\n" +
                        "3. परीक्षा कुंजी: सूत्र को बॉक्स में लिखें और उत्तर के साथ मात्रक अवश्य लगाएं।"
            }
            LanguageMode.ENGLISH -> {
                "🧠 Simplified Breakdown:\n\n" +
                        "1. Core Idea: Break down the concept into 3 easy checkpoints.\n" +
                        "2. Everyday Analogy: Think of it like a recipe where every ingredient must be added in the right order.\n" +
                        "3. Key Takeaway: Always state the formula clearly before substituting numbers."
            }
        }

        return previousResponse.copy(
            answerText = simplifiedText,
            languageMode = languageMode,
            isSimplified = true
        )
    }
}
