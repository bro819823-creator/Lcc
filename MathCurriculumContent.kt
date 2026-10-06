package com.example.data.repository

import com.example.data.model.DiagramItem
import com.example.data.model.McqItem
import com.example.data.model.QuestionItem
import com.example.data.model.TopicConcept

object MathCurriculumContent {

    val TOPICS = listOf(
        TopicConcept(
            id = "math_top_quad",
            chapterId = "math_ch4",
            title = "Quadratic Formula & Nature of Roots",
            conceptsHinglish = "Standard form: ax² + bx + c = 0 where a ≠ 0. Discriminant D = b² - 4ac. Agar D > 0 hai toh 2 real and distinct roots hote hain. Agar D = 0 hai toh 2 equal real roots hote hain (-b/2a). Agar D < 0 hai toh koi real root nahi hota (imaginary roots).",
            conceptsHindi = "मानक रूप: ax² + bx + c = 0 (a ≠ 0)। विविक्तकर D = b² - 4ac। यदि D > 0 है तो दो भिन्न वास्तविक मूल होते हैं। यदि D = 0 है तो दो बराबर वास्तविक मूल होते हैं। यदि D < 0 है तो कोई वास्तविक मूल नहीं होता।",
            conceptsEnglish = "Standard form ax² + bx + c = 0. Discriminant D = b² - 4ac defines nature: D > 0 (two distinct real roots), D = 0 (two equal real roots), D < 0 (no real roots).",
            simpleAnalogy = "Socho Discriminant D ek 'gatekeeper' hai: agar D positive hai toh do raste khulte hain (+ aur -), agar D zero hai toh dono raste ek hi jagah milte hain, aur agar negative square root ke andar aa jaye toh real world me rasta band!",
            formulaOrKeyPoint = "x = [-b ± √(b² - 4ac)] / (2a) | D = b² - 4ac"
        ),
        TopicConcept(
            id = "math_top_ap",
            chapterId = "math_ch5",
            title = "nth Term and Sum of AP",
            conceptsHinglish = "AP ek aisi series hoti hai jisme har agla term pichle term me common difference 'd' jod kar aata hai. nth term ka formula: an = a + (n - 1)d. n terms ke sum ka formula: Sn = n/2 [2a + (n - 1)d] ya Sn = n/2 [a + l], jahan l last term hai.",
            conceptsHindi = "समान्तर श्रेढ़ी (AP) में लगातार पदों का अंतर 'd' समान रहता है। nवाँ पद an = a + (n - 1)d। प्रथम n पदों का योग Sn = n/2 [2a + (n - 1)d]।",
            conceptsEnglish = "An AP is a sequence where difference between consecutive terms is constant d. nth term: an = a + (n - 1)d. Sum of n terms: Sn = n/2 [2a + (n - 1)d].",
            simpleAnalogy = "Jaise seedhi ke steps har baar barabar unchai (d) badhte hain. Pehla step 'a' hai, toh 10ve step tak pahunchne ke liye 9 bar 'd' jodna padega!",
            formulaOrKeyPoint = "an = a + (n - 1)d | Sn = (n/2)[2a + (n - 1)d] = (n/2)[a + l]"
        ),
        TopicConcept(
            id = "math_top_trig",
            chapterId = "math_ch8",
            title = "Trigonometric Ratios & Identities",
            conceptsHinglish = "Right angled triangle me: sin θ = Perpendicular/Hypotenuse, cos θ = Base/Hypotenuse, tan θ = Perpendicular/Base. Yaad rakhne ka trick: 'Pandit Badri Prasad / Har Har Bole'. Core Identity: sin²θ + cos²θ = 1, 1 + tan²θ = sec²θ, 1 + cot²θ = cosec²θ.",
            conceptsHindi = "समकोण त्रिभुज में: sin θ = लंब/कर्ण, cos θ = आधार/कर्ण, tan θ = लंब/आधार। त्रिकोणमितीय सर्वसमिका: sin²θ + cos²θ = 1।",
            conceptsEnglish = "In right triangle: sin θ = opp/hyp, cos θ = adj/hyp, tan θ = opp/adj. Pythagorean identity: sin²θ + cos²θ = 1.",
            simpleAnalogy = "Right triangle me Hypotenuse sabse lambi dhalan hai. Agar angle θ floor par hai, toh samne wali deewar Perpendicular aur neeche ka farsh Base hai!",
            formulaOrKeyPoint = "sin²θ + cos²θ = 1 | tan θ = sin θ / cos θ"
        ),
        TopicConcept(
            id = "math_top_coord",
            chapterId = "math_ch7",
            title = "Distance & Section Formula",
            conceptsHinglish = "2 points A(x1, y1) aur B(x2, y2) ke beech ki distance: d = √[(x2 - x1)² + (y2 - y1)²]. Section formula: agar point P line AB ko m1:m2 ratio me divide kare toh x = (m1·x2 + m2·x1)/(m1 + m2), y = (m1·y2 + m2·y1)/(m1 + m2).",
            conceptsHindi = "बिंदुओं (x1, y1) और (x2, y2) के बीच की दूरी: d = √[(x2 - x1)² + (y2 - y1)²]। विभाजन सूत्र द्वारा बिंदु के निर्देशांक।",
            conceptsEnglish = "Distance formula d = √[(x2 - x1)² + (y2 - y1)²]. Section formula divides line segment in m1:m2 ratio.",
            simpleAnalogy = "Distance formula asal me Pythagoras Theorem hi hai: horizontal difference base banta hai aur vertical difference height!",
            formulaOrKeyPoint = "d = √[(x2 - x1)² + (y2 - y1)²]"
        )
    )

    val QUESTIONS = listOf(
        QuestionItem(
            id = "math_q1",
            chapterId = "math_ch4",
            subjectId = "math",
            type = "SA",
            questionHinglish = "Find the roots of quadratic equation 2x² - 7x + 3 = 0 using quadratic formula.",
            questionHindi = "द्विघात सूत्र का प्रयोग करके समीकरण 2x² - 7x + 3 = 0 के मूल ज्ञात कीजिए।",
            questionEnglish = "Find the roots of quadratic equation 2x² - 7x + 3 = 0 using the quadratic formula.",
            solutionHinglish = "Step 1: Identify Concept - Yeh standard quadratic equation ax² + bx + c = 0 hai.\nStep 2: Coefficients note karo - Yahan a = 2, b = -7, c = 3.\nStep 3: Formula likho - x = [-b ± √(b² - 4ac)] / (2a)\nStep 4: Discriminant D nikalo - D = b² - 4ac = (-7)² - 4(2)(3) = 49 - 24 = 25.\nSince D = 25 > 0, do distinct real roots milenge.\nStep 5: Values put karo -\nx = [-(-7) ± √25] / (2 × 2) = (7 ± 5) / 4\nStep 6: Dono cases solve karo -\nCase 1 (Plus sign): x = (7 + 5) / 4 = 12 / 4 = 3\nCase 2 (Minus sign): x = (7 - 5) / 4 = 2 / 4 = 1/2\nFinal Answer: The roots are x = 3 and x = 1/2.",
            solutionHindi = "चरण 1: ax² + bx + c = 0 से तुलना करने पर: a = 2, b = -7, c = 3।\nचरण 2: विविक्तकर D = b² - 4ac = (-7)² - 4(2)(3) = 49 - 24 = 25 > 0 (वास्तविक व भिन्न मूल)।\nचरण 3: सूत्र x = [-b ± √D] / (2a) = [7 ± √25] / (2 × 2) = (7 ± 5) / 4।\nधनात्मक चिह्न लेने पर: x = 12/4 = 3।\nऋणात्मक चिह्न लेने पर: x = 2/4 = 1/2।\nउत्तर: दिए गए समीकरण के मूल 3 और 1/2 हैं।",
            solutionEnglish = "Comparing with ax² + bx + c = 0: a = 2, b = -7, c = 3.\nDiscriminant D = b² - 4ac = (-7)² - 4(2)(3) = 49 - 24 = 25 > 0.\nUsing formula x = [-b ± √D] / (2a):\nx = [7 ± 5] / 4\nTaking (+): x = 12/4 = 3\nTaking (-): x = 2/4 = 1/2\nRoots are x = 3 and x = 1/2.",
            formulaUsed = "x = [-b ± √(b² - 4ac)] / (2a)",
            marks = 3,
            examTip = "MP Board me hamesha D ki value pehle calculate karke mention karein ki D > 0 hai, isse step-marking me full marks milte hain."
        ),
        QuestionItem(
            id = "math_q2",
            chapterId = "math_ch5",
            subjectId = "math",
            type = "SA",
            questionHinglish = "Find the 10th term of the AP: 2, 7, 12, ...",
            questionHindi = "समान्तर श्रेढ़ी 2, 7, 12, ... का 10वाँ पद ज्ञात कीजिए।",
            questionEnglish = "Find the 10th term of the AP: 2, 7, 12, ...",
            solutionHinglish = "Step 1: Identify Given Values -\nPehla term (a) = 2\nCommon difference (d) = a2 - a1 = 7 - 2 = 5\nNumber of term (n) = 10\nStep 2: Formula likho - an = a + (n - 1)d\nStep 3: Values substitute karo -\na10 = 2 + (10 - 1) × 5\nStep 4: Solve step-by-step -\na10 = 2 + 9 × 5\na10 = 2 + 45 = 47\nFinal Answer: 10th term of the AP is 47.",
            solutionHindi = "दिया है: प्रथम पद (a) = 2, सार्व अंतर (d) = 7 - 2 = 5, पदों की संख्या (n) = 10।\nसूत्र: an = a + (n - 1)d\na10 = 2 + (10 - 1) × 5 = 2 + 45 = 47।\nअतः श्रेढ़ी का 10वाँ पद 47 है।",
            solutionEnglish = "Given: First term a = 2, common difference d = 7 - 2 = 5, n = 10.\nFormula: an = a + (n - 1)d\na10 = 2 + (10 - 1)(5) = 2 + 45 = 47.\nHence, the 10th term is 47.",
            formulaUsed = "an = a + (n - 1)d",
            marks = 2,
            examTip = "d nikalne ke liye hamesha a2 - a1 karein, kabhi a1 - a2 mat karna."
        ),
        QuestionItem(
            id = "math_q3",
            chapterId = "math_ch1",
            subjectId = "math",
            type = "LA",
            questionHinglish = "Prove that √5 is an irrational number.",
            questionHindi = "सिद्ध कीजिए कि √5 एक अपरिमेय संख्या है।",
            questionEnglish = "Prove that √5 is an irrational number.",
            solutionHinglish = "Step 1: Method of Contradiction use karenge. Maan lete hain ki √5 ek rational number hai.\nToh √5 = a/b likh sakte hain, jahan a aur b co-prime integers hain (hcf = 1) aur b ≠ 0.\nStep 2: Cross-multiply aur square dono taraf:\n√5 b = a => 5 b² = a²  --- (Equation 1)\nIska matlab 5 divides a² ko, toh Fundamental Theorem of Arithmetic se 5 divides a ko bhi divide karega.\nStep 3: Isliye hum a = 5c likh sakte hain (kisi integer c ke liye).\nStep 4: a ki value Eq 1 me rakho:\n5 b² = (5c)² = 25 c² => b² = 5 c²\nIska matlab 5 divides b² ko, toh 5 divides b ko bhi divide karega.\nStep 5: Conclusion - Humne dekha ki 5 a aur b dono ka common factor hai, lekin humne mana tha ki a aur b co-prime hain! Yeh contradiction hamari galat assumption se aayi hai.\nFinal: Isliye √5 ek irrational number hai. (Proved)",
            solutionHindi = "उपपत्ति: मान लेते हैं कि √5 एक परिमेय संख्या है। अतः √5 = a/b, जहाँ a और b सह-अभाज्य (co-prime) पूर्णांक हैं तथा b ≠ 0।\nदोनों पक्षों का वर्ग करने पर: 5b² = a² ... (1)\nचूँकि 5, a² को विभाजित करता है, अतः प्रमेय अनुसार 5, a को भी विभाजित करेगा।\nमाना a = 5c (जहाँ c एक पूर्णांक है)।\nसमीकरण (1) में मान रखने पर: 5b² = 25c² => b² = 5c²।\nअतः 5, b² को विभाजित करता है, तो 5, b को भी विभाजित करेगा।\nइस प्रकार 5, a और b दोनों का एक उभयनिष्ठ गुणनखंड है, जो हमारी इस मान्यता का विरोध करता है कि a और b सह-अभाज्य हैं।\nअतः यह विरोधाभास हमारी गलत कल्पना के कारण हुआ है।\nअतः सिद्ध हुआ कि √5 एक अपरिमेय संख्या है।",
            solutionEnglish = "Let us assume √5 is rational, so √5 = a/b where a, b are co-prime and b ≠ 0.\nSquaring both sides: 5b² = a² => 5 divides a² => 5 divides a.\nLet a = 5c. Then 5b² = 25c² => b² = 5c² => 5 divides b² => 5 divides b.\nThus 5 is a common factor of both a and b, contradicting that a and b are co-prime.\nTherefore, √5 is irrational.",
            formulaUsed = "Contradiction Method & Fundamental Theorem of Arithmetic",
            marks = 4,
            examTip = "MP Board board exam me yeh question har saal 4 marks me aata hai (√2, √3 ya √5 ke form me)."
        )
    )

    val MCQS = listOf(
        McqItem(
            id = "math_mcq1",
            chapterId = "math_ch4",
            subjectId = "math",
            questionHinglish = "Agar quadratic equation ax² + bx + c = 0 ke roots equal hain, toh discriminant D ki value kya hogi?",
            questionHindi = "यदि द्विघात समीकरण ax² + bx + c = 0 के मूल समान हों, तो विविक्तकर D का मान होगा:",
            questionEnglish = "If the roots of the quadratic equation ax² + bx + c = 0 are equal, then the value of discriminant D is:",
            options = listOf("D > 0", "D = 0", "D < 0", "D ≤ 0"),
            correctOptionIndex = 1,
            explanationHinglish = "Jab D = b² - 4ac = 0 hota hai, toh formula x = (-b ± 0)/(2a) ban jata hai, jisse dono roots equal (-b/2a) aate hain.",
            explanationHindi = "जब विविक्तकर D = 0 होता है, तब समीकरण के दोनों मूल वास्तविक और बराबर (-b/2a) होते हैं।",
            explanationEnglish = "For equal real roots, discriminant D = b² - 4ac must be equal to 0."
        ),
        McqItem(
            id = "math_mcq2",
            chapterId = "math_ch8",
            subjectId = "math",
            questionHinglish = "sin² 30° + cos² 30° ki value kya hogi?",
            questionHindi = "sin² 30° + cos² 30° का मान क्या होगा?",
            questionEnglish = "What is the value of sin² 30° + cos² 30°?",
            options = listOf("0", "1/2", "1", "2"),
            correctOptionIndex = 2,
            explanationHinglish = "Universal trigonometric identity ke mutabiq sin²θ + cos²θ hamesha 1 hota hai kisi bhi angle θ ke liye! (sin 30° = 1/2 => 1/4, cos 30° = √3/2 => 3/4, 1/4 + 3/4 = 1).",
            explanationHindi = "सर्वसमिका sin²θ + cos²θ = 1 होती है। अतः sin² 30° + cos² 30° = 1।",
            explanationEnglish = "By trigonometric identity, sin²θ + cos²θ = 1 for any acute angle θ."
        ),
        McqItem(
            id = "math_mcq3",
            chapterId = "math_ch7",
            subjectId = "math",
            questionHinglish = "Origin (0,0) se point P(3, 4) ki distance kya hogi?",
            questionHindi = "मूल बिंदु (0,0) से बिंदु P(3, 4) की दूरी होगी:",
            questionEnglish = "The distance of point P(3, 4) from the origin (0, 0) is:",
            options = listOf("3 units", "4 units", "5 units", "7 units"),
            correctOptionIndex = 2,
            explanationHinglish = "Origin se distance d = √(x² + y²) = √(3² + 4²) = √(9 + 16) = √25 = 5 units.",
            explanationHindi = "मूल बिंदु से दूरी = √(x² + y²) = √(3² + 4²) = √(9 + 16) = √25 = 5 मात्रक।",
            explanationEnglish = "Distance from origin = √(x² + y²) = √(9 + 16) = 5 units."
        )
    )

    val DIAGRAMS = listOf(
        DiagramItem(
            id = "diag_math_trig",
            chapterId = "math_ch8",
            subjectId = "math",
            title = "Right Triangle & Trigonometric Ratios",
            titleHindi = "समकोण त्रिभुज एवं त्रिकोणमितीय अनुपात",
            type = "TRIGONOMETRY_TRIANGLE",
            descriptionHinglish = "Right angled triangle ABC with right angle at B. For angle θ at C: AB is Perpendicular (Opposite), BC is Base (Adjacent), and AC is Hypotenuse (H).",
            descriptionHindi = "समकोण त्रिभुज ABC में B पर समकोण है। कोण θ के लिए: AB लंब, BC आधार और AC कर्ण है।",
            descriptionEnglish = "Right-angled triangle detailing Hypotenuse, Perpendicular, and Base relative to reference angle θ.",
            labels = listOf("Hypotenuse (AC)", "Perpendicular (AB)", "Base (BC)", "Angle θ", "Right Angle (90°)")
        ),
        DiagramItem(
            id = "diag_math_circle",
            chapterId = "math_ch9",
            subjectId = "math",
            title = "Tangents from External Point to Circle",
            titleHindi = "बाह्य बिंदु से वृत्त पर स्पर्श रेखाएँ (PA = PB)",
            type = "CIRCLE_TANGENTS",
            descriptionHinglish = "Circle with center O. From external point P, two tangents PA and PB touch the circle at A and B. Radii OA ⊥ PA and OB ⊥ PB. Theorem proves PA = PB.",
            descriptionHindi = "केंद्र O वाला वृत्त। बाह्य बिंदु P से खींची गई स्पर्श रेखाएँ PA और PB। स्पर्श बिंदु पर त्रिज्या लंबवत होती है (OA ⊥ PA) तथा PA = PB।",
            descriptionEnglish = "Tangents PA and PB drawn from external point P to circle with center O, illustrating equal tangent lengths and radius perpendicularity.",
            labels = listOf("Center O", "External Point P", "Point of Contact A", "Point of Contact B", "Tangent PA", "Tangent PB", "Radius r")
        ),
        DiagramItem(
            id = "diag_math_coord",
            chapterId = "math_ch7",
            subjectId = "math",
            title = "Cartesian Coordinate System & Quadrants",
            titleHindi = "निर्देशांक ज्यामिति के चार चतुर्थांश",
            type = "COORDINATE_SYSTEM",
            descriptionHinglish = "X-axis and Y-axis intersecting at Origin (0,0). Quadrant I (+,+), Quadrant II (-,+), Quadrant III (-,-), Quadrant IV (+,-).",
            descriptionHindi = "मूल बिंदु (0,0) पर परस्पर लंबवत X और Y अक्ष। चार चतुर्थांश और उनके चिह्न (+,+), (-,+), (-,-), (+,-)।",
            descriptionEnglish = "Four quadrants in Cartesian plane with respective sign conventions and distance representation.",
            labels = listOf("Origin (0,0)", "X-Axis", "Y-Axis", "Quad I (+,+)", "Quad II (-,+)", "Quad III (-,-)", "Quad IV (+,-)")
        )
    )
}
