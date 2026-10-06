package com.example.data.repository

import com.example.data.model.DiagramItem
import com.example.data.model.McqItem
import com.example.data.model.QuestionItem
import com.example.data.model.TopicConcept

object ScienceCurriculumContent {

    val TOPICS = listOf(
        TopicConcept(
            id = "sci_top_ohm",
            chapterId = "sci_ch9",
            title = "Ohm's Law and Resistance",
            conceptsHinglish = "Kisi conductor me flow hone wali current (I) uske ends ke beech ke potential difference (V) ke directly proportional hoti hai, agar temperature constant rahe: V ∝ I ya V = IR. R is resistance (measured in Ohms Ω). Resistance depend karta hai: length par (R ∝ l), cross-section area par (R ∝ 1/A), aur nature of material par.",
            conceptsHindi = "नियत ताप पर किसी चालक तार के सिरों के बीच का विभवांतर (V) उसमें प्रवाहित धारा (I) के समानुपाती होता है: V = IR। R चालक का प्रतिरोध है जिसका मात्रक ओम (Ω) है। प्रतिरोध लंबाई के समानुपाती तथा अनुप्रस्थ काट के क्षेत्रफल के व्युत्क्रमानुपाती होता है।",
            conceptsEnglish = "At constant temperature, potential difference V across a conductor is proportional to current I: V = IR. Resistance R depends on length (R ∝ l), area (R ∝ 1/A), and material resistivity.",
            simpleAnalogy = "Socho paani ka pipe: Potential difference (V) paani ki tanki ka pressure hai, Current (I) behne wala paani hai, aur Resistance (R) pipe ke andar ki gandagi ya pipe ka patla hona hai jo paani ko rokta hai!",
            formulaOrKeyPoint = "V = IR | R = ρ (l / A) | Unit of R: Ohm (Ω)"
        ),
        TopicConcept(
            id = "sci_top_photo",
            chapterId = "sci_ch5",
            title = "Photosynthesis & Respiration",
            conceptsHinglish = "Green plants sunlight aur chlorophyll ki presence me CO₂ aur H₂O ko glucose me convert karte hain: 6CO₂ + 12H₂O + Sunlight -> C₆H₁₂O₆ + 6O₂ + 6H₂O. Respiration me glucose break down hota hai: Aerobic (mitochondria me 36-38 ATP) aur Anaerobic (yeast me ethanol + CO₂ aur muscle me lactic acid causing cramps).",
            conceptsHindi = "प्रकाश संश्लेषण में पौधे कार्बन डाइऑक्साइड व जल से सूर्य प्रकाश व क्लोरोफिल की सहायता से ग्लूकोज बनाते हैं: 6CO₂ + 12H₂O -> C₆H₁₂O₆ + 6O₂ + 6H₂O। वायवीय श्वसन माइटोकॉन्ड्रिया में तथा अवायवीय श्वसन कोशिका द्रव्य में होता है।",
            conceptsEnglish = "Plants synthesize glucose via photosynthesis using chlorophyll, sunlight, CO₂ and H₂O. Respiration releases energy: Aerobic in mitochondria produces ATP, Anaerobic produces ethanol or lactic acid.",
            simpleAnalogy = "Photosynthesis solar energy ko food packet (glucose) me pack karta hai, aur Respiration us packet ko kholkar body ke cells ko bijli (ATP energy) deta hai!",
            formulaOrKeyPoint = "6CO₂ + 12H₂O + Light -> C₆H₁₂O₆ + 6O₂ + 6H₂O | ATP is Energy Currency"
        ),
        TopicConcept(
            id = "sci_top_ray",
            chapterId = "sci_ch7",
            title = "Concave Mirror Image Formation & Mirror Formula",
            conceptsHinglish = "Concave mirror real and inverted image banata hai jab object C ya F ke piche ho. Jab object Focus (F) aur Pole (P) ke beech ho, tabhi virtual, erect aur enlarged image banti hai (jaise shaving mirror ya dentist mirror). Mirror formula: 1/f = 1/v + 1/u. Magnification m = -v/u = h'/h.",
            conceptsHindi = "अवतल दर्पण अधिकांश स्थितियों में वास्तविक व उल्टा प्रतिबिंब बनाता है। जब वस्तु ध्रुव (P) और फोकस (F) के मध्य हो, तब आभासी, सीधा व बड़ा प्रतिबिंब दर्पण के पीछे बनता है। दर्पण सूत्र: 1/f = 1/v + 1/u।",
            conceptsEnglish = "Concave mirrors form real/inverted images, except when the object is placed between F and P, where it forms a virtual, magnified, erect image. Formula: 1/f = 1/v + 1/u.",
            simpleAnalogy = "Chammach (spoon) ka andar wala hissa concave mirror hota hai; dur se dekhoge toh ulta dikhoge, par ekdum paas laoge toh sidha aur bada dikhoge!",
            formulaOrKeyPoint = "1/f = 1/v + 1/u | m = -v/u = h'/h"
        ),
        TopicConcept(
            id = "sci_top_eye",
            chapterId = "sci_ch8",
            title = "Defects of Vision: Myopia & Hypermetropia",
            conceptsHinglish = "Myopia (Nikkat Drishti Dosh): Paas ki cheezein saaf dikhti hain par dur ki dhundhli. Image retina se pehle ban jati hai. Correction: Concave lens (ap sari lens). Hypermetropia (Door Drishti Dosh): Dur ki saaf dikhti hai par paas ki dhundhli. Image retina ke piche banti hai. Correction: Convex lens (abhisari lens).",
            conceptsHindi = "निकट दृष्टि दोष (मायोपिया): पास की वस्तुएं स्पष्ट दिखती हैं पर दूर की नहीं। प्रतिबिंब रेटिना के आगे बनता है। निवारण: अवतल लेंस। दूर दृष्टि दोष (हाइपरमेट्रोपिया): दूर की स्पष्ट पर पास की नहीं। निवारण: उत्तल लेंस।",
            conceptsEnglish = "Myopia (near-sightedness): Image forms in front of retina, corrected using concave lens. Hypermetropia (far-sightedness): Image forms behind retina, corrected using convex lens.",
            simpleAnalogy = "Myopia me lens zaroorat se zyada beam ko bend kar deta hai, isliye concave lens pehle beam ko thoda phailata hai taaki woh theek retina par focus ho sake!",
            formulaOrKeyPoint = "Myopia -> Concave Lens | Hypermetropia -> Convex Lens"
        )
    )

    val QUESTIONS = listOf(
        QuestionItem(
            id = "sci_q1",
            chapterId = "sci_ch9",
            subjectId = "science",
            type = "SA",
            questionHinglish = "State Ohm's Law and calculate the resistance of an electric lamp that draws 0.5 A current from a 220 V line.",
            questionHindi = "ओम का नियम लिखिए। एक विद्युत लैंप 220 V की लाइन से 0.5 A की धारा लेता है, उसका प्रतिरोध ज्ञात कीजिए।",
            questionEnglish = "State Ohm's Law and calculate the resistance of an electric lamp that draws 0.5 A current from a 220 V line.",
            solutionHinglish = "Part 1: Statement -\nOhm's Law: 'At constant temperature, the current (I) flowing through a conductor is directly proportional to the potential difference (V) across its ends.'\nFormula: V = IR\n\nPart 2: Numerical Calculation -\nGiven: Potential difference V = 220 V, Current I = 0.5 A\nTo find: Resistance R\nFormula: R = V / I\nSubstitute values: R = 220 / 0.5 = 2200 / 5 = 440 Ω\nFinal Answer: The resistance of the lamp is 440 Ω.",
            solutionHindi = "भाग 1: नियम - नियत ताप पर चालक के सिरों का विभवांतर उसमें प्रवाहित धारा के अनुक्रमानुपाती होता है (V = IR)।\nभाग 2: आंकिक हल -\nदिया है: विभवांतर V = 220 V, धारा I = 0.5 A।\nसूत्र: R = V / I\nR = 220 / 0.5 = 440 Ω।\nउत्तर: विद्युत लैंप का प्रतिरोध 440 ओम है।",
            solutionEnglish = "Ohm's Law: V = IR at constant temperature.\nGiven: V = 220 V, I = 0.5 A.\nFormula: R = V / I\nR = 220 / 0.5 = 440 Ω.\nAnswer: Resistance is 440 Ω.",
            formulaUsed = "V = IR => R = V / I",
            marks = 3,
            examTip = "MP Board me rule ka statement aur unit (Ω) likhne ke alag se marks hote hain."
        ),
        QuestionItem(
            id = "sci_q2",
            chapterId = "sci_ch1",
            subjectId = "science",
            type = "SA",
            questionHinglish = "Why is respiration considered an exothermic reaction? Write the balanced chemical equation.",
            questionHindi = "श्वसन को ऊष्माक्षेपी अभिक्रिया क्यों कहते हैं? संतुलित रासायनिक समीकरण लिखिए।",
            questionEnglish = "Why is respiration considered an exothermic reaction? Write the balanced chemical equation.",
            solutionHinglish = "Explanation:\nKhane se milne wale carbohydrates digest hokar glucose banate hain. Respiration ke dauran hamare cells me yeh glucose oxygen ke saath combine hokar slow combustion karta hai aur carbon dioxide, water ke saath-saath heavy amount me ENERGY release karta hai. Kyunki is process me heat/energy release hoti hai, isliye respiration ko EXOTHERMIC (ऊष्माक्षेपी) reaction kehte hain.\n\nBalanced Equation:\nC₆H₁₂O₆ (aq) + 6O₂ (g) -> 6CO₂ (g) + 6H₂O (l) + Energy (ATP)",
            solutionHindi = "उत्तर: भोजन से प्राप्त ग्लूकोज हमारी कोशिकाओं में ऑक्सीजन के साथ मिलकर टूटता है और प्रचुर मात्रा में ऊर्जा (ATP के रूप में) मुक्त करता है। चूँकि इस प्रक्रिया में ऊर्जा उत्सर्जित होती है, अतः श्वसन एक ऊष्माक्षेपी अभिक्रिया है।\nसंतुलित समीकरण: C₆H₁₂O₆ + 6O₂ -> 6CO₂ + 6H₂O + ऊर्जा।",
            solutionEnglish = "Respiration is exothermic because glucose reacts with oxygen in cells to break down into carbon dioxide and water, releasing biological energy in the form of ATP.\nEquation: C₆H₁₂O₆ + 6O₂ -> 6CO₂ + 6H₂O + Energy.",
            formulaUsed = "C₆H₁₂O₆ + 6O₂ -> 6CO₂ + 6H₂O + Energy",
            marks = 2,
            examTip = "Balanced equation likhna mat bhoolna, dono taraf atoms count 6 Carbon, 12 Hydrogen, 18 Oxygen hona chahiye."
        ),
        QuestionItem(
            id = "sci_q3",
            chapterId = "sci_ch5",
            subjectId = "science",
            type = "LA",
            questionHinglish = "Explain the structure and functioning of a Nephron (excretory unit of kidney).",
            questionHindi = "वृक्काणु (नेफ्रॉन) की रचना एवं कार्यविधि का सचित्र वर्णन कीजिए।",
            questionEnglish = "Explain the structure and functioning of a Nephron (filtration unit of human kidney).",
            solutionHinglish = "1. Structure of Nephron:\nNephron kidney ki basic filtration unit hai. Isme ek cup-shaped structure hota hai jise Bowman's Capsule kehte hain, jisme blood capillaries ka guchha hota hai jise Glomerulus kehte hain. Bowman capsule se ek coiled tubular structure judta hai jo Henle's Loop aur collecting duct tak jata hai.\n\n2. Functioning Steps:\n(a) Glomerular Filtration: High pressure se blood Glomerulus me aata hai. Glucose, amino acids, salts aur excess water Bowman's capsule me filter hokar aate hain (cells & proteins filter nahi hote).\n(b) Selective Reabsorption: Tubular part me body ke useful substances (glucose, salts aur required water) wapas blood capillaries me absorb ho jate hain.\n(c) Tubular Secretion: Excess urea, uric acid collecting duct me urine ke form me collect hokar ureter ke raste urinary bladder me store hota hai.",
            solutionHindi = "1. नेफ्रॉन की संरचना: नेफ्रॉन वृक्क की क्रियात्मक इकाई है। इसमें बोमन सम्पुट (Bowman's capsule), ग्लोमेरुलस (केशिका गुच्छ), हेनले का लूप तथा संग्रहक वाहिनी होती है।\n2. कार्यविधि:\n(क) निस्यंदन (Filtration): रुधिर से यूरिया, यूरिक अम्ल, ग्लूकोज व लवण छनकर आते हैं।\n(ख) चयनात्मक पुनरावशोषण (Reabsorption): आवश्यक ग्लूकोज, अमीनो अम्ल व जल पुनः रुधिर में अवशोषित हो जाते हैं।\n(ग) मूत्र निर्माण: बचा हुआ अपशिष्ट यूरिया युक्त द्रव मूत्र के रूप में मूत्राशय में पहुँचता है।",
            solutionEnglish = "Structure: Glomerulus, Bowman's capsule, Henle's loop, and collecting duct.\nFunctioning: Ultrafiltration in glomerulus under high blood pressure, selective reabsorption of vital nutrients (glucose, water) in tubules, and secretion of concentrated urea as urine.",
            formulaUsed = "Excretion = Ultrafiltration + Selective Reabsorption",
            marks = 5,
            examTip = "MP Board me is question ke saath nephron ka labeled diagram banakar Bowman's capsule aur Glomerulus show karna zaroori hai."
        )
    )

    val MCQS = listOf(
        McqItem(
            id = "sci_mcq1",
            chapterId = "sci_ch9",
            subjectId = "science",
            questionHinglish = "Electric current ki SI unit kya hoti hai?",
            questionHindi = "विद्युत धारा का SI मात्रक क्या है?",
            questionEnglish = "What is the SI unit of electric current?",
            options = listOf("Volt", "Ohm", "Ampere", "Joule"),
            correctOptionIndex = 2,
            explanationHinglish = "Electric current ki SI unit Ampere (A) hoti hai (André-Marie Ampère ke naam par). 1 Ampere = 1 Coulomb / 1 Second.",
            explanationHindi = "विद्युत धारा का SI मात्रक 'एम्पीयर' (Ampere) है। 1 A = 1 कूलॉम / 1 सेकण्ड।",
            explanationEnglish = "The SI unit of electric current is the Ampere (A), defined as one coulomb of charge per second."
        ),
        McqItem(
            id = "sci_mcq2",
            chapterId = "sci_ch8",
            subjectId = "science",
            questionHinglish = "Myopia (निकट दृष्टि दोष) ko door karne ke liye kis lens ka prayog kiya jata hai?",
            questionHindi = "निकट दृष्टि दोष के निवारण हेतु किस लेंस का उपयोग किया जाता है?",
            questionEnglish = "Which lens is used to correct myopia (near-sightedness)?",
            options = listOf("उत्तल लेंस (Convex lens)", "अवतल लेंस (Concave lens)", "द्विफोकसी लेंस (Bifocal lens)", "बेलनाकार लेंस (Cylindrical lens)"),
            correctOptionIndex = 1,
            explanationHinglish = "Myopia me rays retina se pehle mil jati hain, concave lens rays ko diverge (ap-sarit) karke theek retina par focus karta hai.",
            explanationHindi = "मायोपिया में प्रतिबिंब रेटिना के आगे बन जाता है, अतः अपसारी प्रकृति वाले 'अवतल लेंस' का उपयोग किया जाता है।",
            explanationEnglish = "A concave (diverging) lens is used to correct myopia by focusing the incoming light precisely onto the retina."
        ),
        McqItem(
            id = "sci_mcq3",
            chapterId = "sci_ch2",
            subjectId = "science",
            questionHinglish = "Plaster of Paris (POP) ka chemical formula kya hota hai?",
            questionHindi = "प्लास्टर ऑफ पेरिस का रासायनिक सूत्र क्या है?",
            questionEnglish = "What is the chemical formula of Plaster of Paris (POP)?",
            options = listOf("CaSO₄ · 2H₂O", "CaSO₄ · ½H₂O", "Na₂CO₃ · 10H₂O", "CaOCl₂"),
            correctOptionIndex = 1,
            explanationHinglish = "Plaster of Paris Calcium Sulphate Hemihydrate hota hai: CaSO₄ · ½H₂O. Jabki CaSO₄ · 2H₂O Gypsum ka formula hai.",
            explanationHindi = "प्लास्टर ऑफ पेरिस का रासायनिक नाम कैल्शियम सल्फेट अर्ध-हाइड्रेट (हेमीहाइड्रेट) है जिसका सूत्र CaSO₄ · ½H₂O है।",
            explanationEnglish = "Plaster of Paris is calcium sulphate hemihydrate, formula: CaSO₄ · ½H₂O."
        )
    )

    val DIAGRAMS = listOf(
        DiagramItem(
            id = "diag_sci_circuit",
            chapterId = "sci_ch9",
            subjectId = "science",
            title = "Ohm's Law Electric Circuit Diagram",
            titleHindi = "ओम के नियम का विद्युत परिपथ आरेख",
            type = "ELECTRIC_CIRCUIT_OHM",
            descriptionHinglish = "Circuit consisting of a Battery (power source), Plug Key (switch), Ammeter in series (measures current I), Resistor R, Voltmeter in parallel across R (measures V), and Rheostat (variable resistance).",
            descriptionHindi = "ओम के नियम का सत्यापन परिपथ: श्रेणीक्रम में अमीटर, समांतर क्रम में वोल्टमीटर, प्रतिरोध तार, धारा नियंत्रक एवं बैटरी।",
            descriptionEnglish = "Schematic diagram of an electric circuit to verify Ohm's law with series Ammeter, parallel Voltmeter across resistor, and Rheostat.",
            labels = listOf("Battery (+/-)", "Key (K)", "Ammeter (A in series)", "Resistor (R)", "Voltmeter (V in parallel)", "Rheostat (Rh)")
        ),
        DiagramItem(
            id = "diag_sci_eye",
            chapterId = "sci_ch8",
            subjectId = "science",
            title = "Human Eye Anatomical Diagram",
            titleHindi = "मानव नेत्र की संरचना",
            type = "HUMAN_EYE",
            descriptionHinglish = "Cross-section of the human eye showing Cornea, Pupil, Iris, Crystalline Convex Lens, Ciliary Muscles, Retina (light-sensitive screen), and Optic Nerve transmitting signals to the brain.",
            descriptionHindi = "मानव नेत्र के प्रमुख भाग: स्वच्छ मंडल (कॉर्निया), परितारिका (आयरिस), पुतली, अभिनेत्र लेंस, पक्ष्माभी पेशियां, दृष्टिपटल (रेटिना) एवं दृक तंत्रिका।",
            descriptionEnglish = "Anatomical schematic of human eye displaying Cornea, Pupil, Iris, Crystalline Lens, Ciliary Muscles, Retina, and Optic Nerve.",
            labels = listOf("Cornea", "Iris & Pupil", "Crystalline Lens", "Ciliary Muscles", "Retina", "Optic Nerve")
        ),
        DiagramItem(
            id = "diag_sci_ray",
            chapterId = "sci_ch7",
            subjectId = "science",
            title = "Concave Mirror Ray Diagram (Object between C and F)",
            titleHindi = "अवतल दर्पण किरण आरेख (वस्तु C और F के बीच)",
            type = "RAY_CONCAVE_MIRROR",
            descriptionHinglish = "Concave mirror showing Principal Axis, Center of Curvature C, Principal Focus F, and Pole P. When object AB is between C and F, rays reflect to form a real, inverted and enlarged image A'B' beyond C.",
            descriptionHindi = "अवतल दर्पण में जब वस्तु वक्रता केंद्र (C) और फोकस (F) के बीच हो, तो प्रतिबिंब C से परे वास्तविक, उल्टा और बड़ा बनता है।",
            descriptionEnglish = "Ray diagram for concave mirror with object placed between C and F, producing a real, inverted, magnified image beyond C.",
            labels = listOf("Pole (P)", "Focus (F)", "Center of Curvature (C)", "Object (AB)", "Image (A'B')", "Principal Axis")
        ),
        DiagramItem(
            id = "diag_sci_solenoid",
            chapterId = "sci_ch10",
            subjectId = "science",
            title = "Magnetic Field Lines of a Solenoid",
            titleHindi = "परिनालिका में विद्युत धारा से उत्पन्न चुंबकीय क्षेत्र रेखाएँ",
            type = "MAGNETIC_SOLENOID",
            descriptionHinglish = "Helical coil carrying current behaves like a bar magnet. Inside the solenoid, field lines are parallel straight lines indicating a uniform magnetic field. Outside lines loop from North to South pole.",
            descriptionHindi = "धारावाही परिनालिका के चारों ओर चुंबकीय क्षेत्र रेखाएँ छड़ चुंबक के समान होती हैं। परिनालिका के अंदर क्षेत्र रेखाएँ समानांतर होती हैं (एकसमान चुंबकीय क्षेत्र)।",
            descriptionEnglish = "Magnetic field lines around and inside a current-carrying solenoid, illustrating uniform internal field and dipole behavior.",
            labels = listOf("Current Coil", "North Pole (N)", "South Pole (S)", "Uniform Magnetic Field Inside", "Battery Source")
        ),
        DiagramItem(
            id = "diag_sci_stomata",
            chapterId = "sci_ch5",
            subjectId = "science",
            title = "Open and Closed Stomata (Guard Cells)",
            titleHindi = "रंध्र (स्टोमेटा) का खुलना और बंद होना",
            type = "STOMATA_CELL",
            descriptionHinglish = "Stomata on leaf epidermis. When guard cells take in water, they swell and curve outwards, opening the pore. When they lose water, they shrink and become flaccid, closing the pore.",
            descriptionHindi = "पत्ती की बाह्य त्वचा पर रंध्र। द्वार कोशिकाएं (Guard cells) जल अवशोषित कर फूल जाती हैं जिससे रंध्र छिद्र खुल जाता है। जल निकलने पर छिद्र बंद हो जाता है।",
            descriptionEnglish = "Stomatal apparatus showing guard cells turgid (open pore) and flaccid (closed pore), chloroplasts, and epidermal cells.",
            labels = listOf("Guard Cells (द्वार कोशिकाएं)", "Stomatal Pore (रंध्र छिद्र)", "Chloroplasts (हरित लवक)", "Epidermal Cells")
        )
    )
}
