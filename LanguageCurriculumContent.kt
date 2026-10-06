package com.example.data.repository

import com.example.data.model.McqItem
import com.example.data.model.QuestionItem
import com.example.data.model.TopicConcept

object LanguageCurriculumContent {

    val TOPICS = listOf(
        // ENGLISH
        TopicConcept(
            id = "eng_top_lencho",
            chapterId = "eng_ch1",
            title = "A Letter to God: Character of Lencho & Central Theme",
            conceptsHinglish = "Lencho ek seedha-saadha, mehnati farmer tha jo corn ugate tha. Olo (hailstorm) se jab poori fasal tabah ho gayi, toh uska vishwas tha ki Bhagwan kisi ko bhookha marne nahi dete. Usne 100 pesos maangne ke liye letter bheja. Postmaster ne compassion se 70 pesos collect karke bheje. Lekin jab Lencho ne gina, toh usne socha ki post office employees ne 30 pesos chura liye aur unhe 'a bunch of crooks' bola. Irony: Jin logon ne madad ki, unhi par shak kiya gaya!",
            conceptsHindi = "लेन्चो एक परिश्रमी किसान है जिसका ईश्वर में अटूट विश्वास है। फसल नष्ट होने पर वह 100 पेसोस मांगता है। पोस्टमास्टर दयालुता से 70 पेसोस भेजता है, किंतु लेन्चो डाक कर्मचारियों को ही 'ठगों का गिरोह' (bunch of crooks) समझ बैठता है।",
            conceptsEnglish = "Lencho represents innocent, unwavering faith in God. The postmaster exemplifies selfless benevolence. The irony lies in Lencho suspecting his real benefactors as thieves.",
            simpleAnalogy = "Ek chhota bachha jo sach me maanta hai ki ped par paise ug sakte hain agar bhagwan chahein; uska vishwas itna nirmal hai ki reality ki samajh use nahi hai!",
            formulaOrKeyPoint = "Theme: Unquestioning Faith & Dramatic Irony | Author: G.L. Fuentes"
        ),

        // HINDI
        TopicConcept(
            id = "hin_top_ras",
            chapterId = "hin_ch4",
            title = "काव्य में रस की परिभाषा एवं स्थायी भाव",
            conceptsHinglish = "काव्य को पढ़ने, सुनने या देखने से जो अलौकिक आनंद प्राप्त होता है, उसे रस कहते हैं। रस के 4 अंग होते हैं: 1. स्थायी भाव (हृदय में हमेशा विद्यमान), 2. विभाव (कारण - आलंबन व उद्दीपन), 3. अनुभाव (शारीरिक चेष्टाएं), 4. संचारी भाव (पानी के बुलबुलों जैसे क्षणिक भाव - संख्या 33)। प्रमुख रस व स्थायी भाव: शृंगार (रति), हास्य (हास), करुण (शोक), वीर (उत्साह), रौद्र (क्रोध), भयानक (भय), बीभत्स (जुगुप्सा), अद्भुत (विस्मय), शांत (निर्वेद/शम), वात्सल्य (वत्सलता)।",
            conceptsHindi = "रस की परिभाषा: 'काव्यस्यात्मा ध्वनिः' या 'वाक्यं रसात्मकं काव्यम्'। स्थायी भाव 10 हैं: शृंगार (रति), वीर (उत्साह), करुण (शोक), हास्य (हास), रौद्र (क्रोध), भयानक (भय), बीभत्स (घृणा), अद्भुत (आश्चर्य), शांत (निर्वेद), वात्सल्य (स्नेह)।",
            conceptsEnglish = "Ras is the aesthetic essence and emotional experience evoked by poetry. Core components: Sthayi Bhav, Vibhav, Anubhav, and Sanchari Bhav.",
            simpleAnalogy = "Jaise swadisht bhojan me 6 ras hote hain jo jibh ko anand dete hain, waise hi kavita me man ke alag-alag bhav (prem, utsah, hasi) ko jagane wale tatva 'Ras' hain!",
            formulaOrKeyPoint = "रस के 4 अंग | 10 स्थायी भाव | 33 संचारी भाव"
        ),

        // SANSKRIT
        TopicConcept(
            id = "san_top_sandhi",
            chapterId = "san_ch3",
            title = "संस्कृत सन्धि एवं प्रमुख नियम",
            conceptsHinglish = "दो वर्णों के अत्यंत निकट आने पर जो परिवर्तन होता है, उसे सन्धि कहते हैं। 1. व्यंजन सन्धि: (क) जश्त्व सन्धि: वर्ग के प्रथम वर्ण (क्, च्, ट्, त्, प्) के बाद कोई स्वर या तीसरा-चौथा वर्ण आये तो वह अपने वर्ग का तीसरा वर्ण बन जाता है (उदा: दिक् + अम्बरः = दिगम्बरः, वाक् + ईशः = वागीशः, सत् + आनन्दः = सदानन्दः)। 2. विसर्ग सन्धि: (क) उत्व सन्धि: अ + : + अ/तीसरा-चौथा वर्ण = 'ओ' (उदा: कः + अपि = कोऽपि, रामः + अवदत् = रामोऽवदत्)।",
            conceptsHindi = "सन्धि के मुख्य भेद: स्वर, व्यंजन और विसर्ग। जश्त्व सन्धि: प्रथम वर्ण का तृतीय वर्ण में परिवर्तन (वाक् + ईशः = वागीशः)। विसर्ग उत्व सन्धि: कः + अपि = कोऽपि।",
            conceptsEnglish = "Sandhi represents euphonic combination of sounds in Sanskrit. Key types: Vyanjana Sandhi (Jashtva rule: k/c/t/t/p becomes g/j/d/d/b) and Visarga Sandhi (Ko'pi, Ramo'vadat).",
            simpleAnalogy = "Jaise do alag-alag taar ko jodte waqt unka jodh ek naya aakar le leta hai, waise hi bolte waqt do shabdon ke aakhri aur pehle akshar milkar aasan dhwani banate hain!",
            formulaOrKeyPoint = "वाक् + ईशः = वागीशः | कः + अपि = कोऽपि | नमः + ते = नमस्ते"
        )
    )

    val QUESTIONS = listOf(
        QuestionItem(
            id = "eng_q1",
            chapterId = "eng_ch1",
            subjectId = "english",
            type = "SA",
            questionHinglish = "Why did Lencho write a letter to God? How much money did he receive?",
            questionHindi = "लेन्चो ने ईश्वर को पत्र क्यों लिखा? उसे कितने पैसे प्राप्त हुए?",
            questionEnglish = "Why did Lencho write a letter to God and how much money did he actually receive?",
            solutionHinglish = "Answer:\n1. Reason for writing letter: Ek bhayankar hailstorm (tufani olo) ne Lencho ki paki hui corn crop ko poori tarah destroy kar diya tha. Uski family ke paas us saal khane ke liye kuch nahi bacha tha. Lencho ka God me deep unshakable faith tha ki God sab dekhte hain aur kisi ko bhookha marne nahi denge. Isliye usne apne khet ko dobara bone aur family ko chalane ke liye 100 pesos maangne ke liye God ko letter likha.\n\n2. Money received: Postmaster ne apne employees aur friends se paise collect kiye, lekin woh sirf 70 pesos hi ikattha kar paye. Isliye Lencho ko 100 ke bajay sirf 70 pesos mile.",
            solutionHindi = "उत्तर: ओलावृष्टि से लेन्चो की मक्के की पूरी फसल नष्ट हो गई थी और परिवार के सामने भुखमरी का संकट था। ईश्वर में अटूट विश्वास के कारण उसने अगली फसल बोने व जीवनयापन के लिए 100 पेसोस मांगते हुए पत्र लिखा। पोस्टमास्टर की मदद से उसे केवल 70 पेसोस प्राप्त हुए।",
            solutionEnglish = "A devastating hailstorm destroyed Lencho's entire ripe corn crop, leaving his family starving. Having immense faith in God, he wrote asking for 100 pesos to re-sow his fields. The postmaster managed to collect and send him only 70 pesos.",
            formulaUsed = "Faith in God + Generosity of Postmaster",
            marks = 3,
            examTip = "Important for revision: MP Board exam me Lencho ke 100 pesos demand aur 70 pesos received ka exact number likhna zaroori hota hai."
        ),
        QuestionItem(
            id = "hin_q1",
            chapterId = "hin_ch4",
            subjectId = "hindi",
            type = "SA",
            questionHinglish = "वीर रस की परिभाषा लिखकर एक उदाहरण दीजिए।",
            questionHindi = "वीर रस की परिभाषा लिखकर एक उदाहरण दीजिए।",
            questionEnglish = "Define Veer Ras and give one poetic example.",
            solutionHinglish = "परिभाषा:\nजब किसी काव्य में युद्ध, कठिन कार्य अथवा देश और धर्म की रक्षा हेतु हृदय में स्थित 'उत्साह' नामक स्थायी भाव, विभाव, अनुभाव और संचारी भाव से पुष्ट होता है, तब 'वीर रस' की निष्पत्ति होती है।\n- स्थायी भाव: उत्साह\n- आलंबन विभाव: शत्रु या अत्याचार\n- उद्दीपन: युद्ध के नगाड़े, रणभेरी\n\nउदाहरण:\n'बुंदेले हरबोलों के मुँह हमने सुनी कहानी थी।\nखूब लड़ी मर्दानी वह तो झाँसी वाली रानी थी।।'",
            solutionHindi = "वीर रस: हृदय में 'उत्साह' स्थायी भाव के विभाव, अनुभाव और संचारी भाव के संयोग से वीर रस उत्पन्न होता है।\nस्थायी भाव: उत्साह।\nउदाहरण:\n'बुंदेले हरबोलों के मुँह हमने सुनी कहानी थी।\nखूब लड़ी मर्दानी वह तो झाँसी वाली रानी थी।।'",
            solutionEnglish = "Veer Ras is generated when the enduring emotion of Enthusiasm/Valour (Utsaah) is aroused by confronting enemies or adversity.\nExample: The heroic poem celebrating Rani Lakshmibai of Jhansi.",
            formulaUsed = "स्थायी भाव = उत्साह",
            marks = 3,
            examTip = "Important for revision: MP Board me ras ki paribhasha me uska Sthayi Bhav (उत्साह) aur ek do-line ka chhand-mukt udaharan likhna full 3 marks deta hai."
        ),
        QuestionItem(
            id = "san_q1",
            chapterId = "san_ch1",
            subjectId = "sanskrit",
            type = "SA",
            questionHinglish = "कविः किमर्थं प्रकृतेः शरणम् इच्छति? (हिंदी व हिंग्लिश में समझाइए)",
            questionHindi = "कविः किमर्थं प्रकृतेः शरणम् इच्छति? (कवि प्रकृति की शरण में क्यों जाना चाहता है?)",
            questionEnglish = "Why does the poet desire the refuge of nature in 'Shuchiparyavaranam'?",
            solutionHinglish = "संस्कृत उत्तर: महानगर-मध्ये वायुमण्डलं भृशं दूषितम् अस्ति। अत्र जीवनं दुर्बहं जातम्, अतः कविः शुद्धपर्यावरणाय प्रकृतेः शरणम् इच्छति।\n\nसरल व्याख्या (Hinglish):\nमहानगरों (shehron) me hazaron gaadiyon se kaala dhuwan nikalta hai jisse hawa behad pradushit ho gayi hai. Shehron ki bhagdaur aur pradushan me jeena durbhar (mushkil) ho gaya hai. Isliye kavi apne man aur shareer ki shanti ke liye swachh aur shuddh prakriti ki sharan me jana chahte hain.",
            solutionHindi = "संस्कृत उत्तर: महानगरेषु प्रदूषण-कारणात् जीवितं दुर्बहं संजातम्, अतः कविः प्रकृतेः शरणम् इच्छति।\nहिंदी अनुवाद: महानगरों में प्रदूषण के कारण जीवन अत्यंत कठिन हो गया है, अतः कवि शुद्ध वातावरण और शांति हेतु प्रकृति की शरण में जाना चाहता है।",
            solutionEnglish = "In large cities, the air, water, and environment are heavily polluted, making peaceful life impossible. Hence the poet seeks the pure, tranquil refuge of pristine nature.",
            formulaUsed = "पर्यावरण प्रदूषण -> प्रकृतेः शरणम्",
            marks = 2,
            examTip = "Important for revision: Sanskrit me 'जीवितं दुर्बहं संजातम्' shabd-samuh ka prayog karne se teacher prabhavit hote hain."
        )
    )

    val MCQS = listOf(
        McqItem(
            id = "eng_mcq1",
            chapterId = "eng_ch1",
            subjectId = "english",
            questionHinglish = "Lencho ne post office ke employees ko kya kaha tha?",
            questionHindi = "लेन्चो ने डाक कर्मचारियों के लिए किस शब्द का प्रयोग किया था?",
            questionEnglish = "What phrase did Lencho use to describe the post office employees?",
            options = listOf("Kind helpers", "A bunch of crooks", "God's messengers", "Honest citizens"),
            correctOptionIndex = 1,
            explanationHinglish = "Lencho ko laga ki Bhagwan ne 100 pesos hi bheje the, lekin post office ke logon ne 30 pesos chura liye, isliye usne unhe 'a bunch of crooks' bola.",
            explanationHindi = "लेन्चो ने सोचा कि डाक कर्मचारियों ने उसके 30 पेसोस चुरा लिए हैं, इसलिए उसने उन्हें 'a bunch of crooks' (ठगों का गिरोह) कहा।",
            explanationEnglish = "Lencho ironically suspected the post office employees of stealing 30 pesos, calling them 'a bunch of crooks'."
        ),
        McqItem(
            id = "hin_mcq1",
            chapterId = "hin_ch4",
            subjectId = "hindi",
            questionHinglish = "'शृंगार रस' का स्थायी भाव क्या होता है?",
            questionHindi = "'शृंगार रस' का स्थायी भाव क्या होता है?",
            questionEnglish = "What is the primary emotion (Sthayi Bhav) of 'Shringar Ras'?",
            options = listOf("उत्साह (Utsaah)", "शोक (Shok)", "रति या प्रेम (Rati/Prem)", "क्रोध (Krodh)"),
            correctOptionIndex = 2,
            explanationHinglish = "शृंगार रस का स्थायी भाव 'रति' (प्रेम) होता है। इसे रसों का राजा (रसराज) भी कहा जाता है।",
            explanationHindi = "शृंगार रस का स्थायी भाव 'रति' (प्रेम) है। शृंगार रस के दो भेद होते हैं: संयोग और वियोग।",
            explanationEnglish = "The permanent emotion of Shringar Ras is 'Rati' (Love). It is renowned as Ras-Raj."
        ),
        McqItem(
            id = "san_mcq1",
            chapterId = "san_ch3",
            subjectId = "sanskrit",
            questionHinglish = "'वागीशः' का उचित सन्धि-विच्छेद क्या होगा?",
            questionHindi = "'वागीशः' का उचित सन्धि-विच्छेद क्या होगा?",
            questionEnglish = "What is the correct Sandhi division of 'Vageeshah'?",
            options = listOf("वाग + ईशः", "वाक् + ईशः", "वागी + शः", "वा + गीशः"),
            correctOptionIndex = 1,
            explanationHinglish = "व्यंजन सन्धि (जश्त्व नियम) के अनुसार प्रथम वर्ण 'क्' स्वर 'ई' से मिलने पर अपने वर्ग के तीसरे वर्ण 'ग्' में बदल जाता है: वाक् + ईशः = वागीशः।",
            explanationHindi = "जश्त्व सन्धि के नियम से प्रथम वर्ण 'क्' तृतीय वर्ण 'ग्' में परिवर्तित होता है: वाक् + ईशः = वागीशः।",
            explanationEnglish = "According to Sanskrit Jashtva rule, k converts to g when followed by a vowel: Vaak + Eeshah = Vageeshah."
        )
    )
}
