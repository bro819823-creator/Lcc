package com.example.data.repository

import com.example.data.model.McqItem
import com.example.data.model.QuestionItem
import com.example.data.model.TopicConcept

object SstCurriculumContent {

    val TOPICS = listOf(
        TopicConcept(
            id = "sst_top_jallianwala",
            chapterId = "sst_ch2",
            title = "Jallianwala Bagh Massacre & Non-Cooperation Movement",
            conceptsHinglish = "Date: 13 April 1919 (Baisakhi Day) in Amritsar. Crowd gathered to protest against Rowlatt Act and arrest of leaders Dr. Saifuddin Kitchlew & Satyapal. General Dyer closed exit gates and ordered troops to fire without warning, killing hundreds. Causes & Effects: Rabindranath Tagore renounced Knighthood. Gandhi launched Non-Cooperation Khilafat Movement in 1920 to boycott foreign goods, schools, and courts.",
            conceptsHindi = "13 अप्रैल 1919 (बैसाखी): अमृतसर के जलियांवाला बाग में रॉलेट एक्ट के विरोध में एकत्र निहत्थी भीड़ पर जनरल डायर ने अंधाधुंध गोलियां चलवाईं। परिणाम: रवींद्रनाथ टैगोर ने 'नाइटहुड' की उपाधि लौटाई और गांधीजी ने 1920 में असहयोग आंदोलन शुरू किया।",
            conceptsEnglish = "On 13 April 1919, General Dyer ordered troops to fire on peaceful gathering at Jallianwala Bagh protesting Rowlatt Act. This led to widespread outrage and Gandhi launching Non-Cooperation Movement.",
            simpleAnalogy = "Angrezo ne ek aisa kanoon (Rowlatt Act) banaya jisme bina kisi vakil ya daleel ke kisi ko bhi jail me daal sakte the; is atyachar ne poore desh ko azaadi ke liye ekjut kar diya!",
            formulaOrKeyPoint = "13 April 1919: Jallianwala Bagh | 1920-22: Non-Cooperation | Chauri Chaura: 1922"
        ),
        TopicConcept(
            id = "sst_top_soil",
            chapterId = "sst_ch3",
            title = "Soil Types in India: Alluvial vs Black Soil",
            conceptsHinglish = "Alluvial Soil (जलोढ़ मिट्टी): Rivers (Indus, Ganga, Brahmaputra) dwara laye gaye silt se banti hai. Extremely fertile, potash aur lime se bharpoor, wheat aur paddy ke liye best. Black Soil (काली मिट्टी / रेगर): Lava flows se banti hai, clayey nature, moisture retain karti hai. Cotton crop ke liye sabse best, MP ke Malwa plateau aur Maharashtra me milti hai.",
            conceptsHindi = "जलोढ़ मृदा: नदियों द्वारा निक्षेपित, अत्यंत उपजाऊ, पोटाश व चूना युक्त (गेहूं-चावल हेतु सर्वोत्तम)। काली (रेगुर) मृदा: बेसाल्ट लावा से निर्मित, नमी धारण क्षमता अधिक, कपास की खेती हेतु प्रसिद्ध (मध्य प्रदेश व महाराष्ट्र)।",
            conceptsEnglish = "Alluvial soil is deposited by river systems and is highly fertile for wheat/rice. Black soil (Regur) is derived from Deccan lava, retains moisture, and is ideal for cotton cultivation.",
            simpleAnalogy = "Jalodh mitti nadiyon ka uphaar hai, aur Kaali mitti jwalamukhi ke thande hue lava ka uphaar hai jo kapde banane wale kapas ko poshan deta hai!",
            formulaOrKeyPoint = "Black Soil = Regur Soil = Ideal for Cotton (Malwa, MP)"
        ),
        TopicConcept(
            id = "sst_top_fed",
            chapterId = "sst_ch4",
            title = "Federalism and Decentralization in India",
            conceptsHinglish = "Federalism me power Central aur State governments ke beech divide hoti hai. 3 Lists: 1. Union List (Defence, Foreign affairs, Banking - only Centre makes laws). 2. State List (Police, Trade, Agriculture - State makes laws). 3. Concurrent List (Education, Forest, Marriage - both can make laws). 1992 ka 73rd Amendment Panchayati Raj ko constitutional status deta hai.",
            conceptsHindi = "भारतीय संघवाद की तीन सूचियां: 1. संघ सूची (रक्षा, विदेश, बैंकिंग)। 2. राज्य सूची (पुलिस, व्यापार, कृषि)। 3. समवर्ती सूची (शिक्षा, वन, विवाह)। 1992 का 73वाँ संशोधन त्रिस्तरीय पंचायती राज व्यवस्था लागू करता है।",
            conceptsEnglish = "Distribution of legislative powers: Union List, State List, and Concurrent List. The 1992 constitutional amendment empowered local self-government (Panchayati Raj).",
            simpleAnalogy = "Jaise ghar me bade faisle parents karte hain (Union), daily kitchen-room ka kaam local members karte hain (State), aur bacho ki padhai dono milkar decide karte hain (Concurrent)!",
            formulaOrKeyPoint = "Union List (Centre) | State List (State) | Concurrent List (Both) | Residuary (Centre)"
        ),
        TopicConcept(
            id = "sst_top_sectors",
            chapterId = "sst_ch5",
            title = "Three Sectors of Indian Economy & Disguised Unemployment",
            conceptsHinglish = "Primary Sector: Natural resources use hote hain (Agriculture, Dairy, Fishing). Secondary: Natural products ko manufacturing se nayi cheez me badalte hain (Factories, Textiles). Tertiary: Services provide karte hain (Transport, Banking, IT, Doctor). Disguised Unemployment (छिपी हुई बेरोजगारी): Khet me 5 log kaafi hain par 8 log lage hue hain, un 3 ko hata bhi do toh production kam nahi hoga!",
            conceptsHindi = "प्राथमिक क्षेत्र (कृषि, पशुपालन), द्वितीयक क्षेत्र (विनिर्माण व उद्योग), तृतीयक क्षेत्र (सेवाएं: बैंकिंग, परिवहन, संचार)। प्रच्छन्न बेरोजगारी: जब आवश्यकता से अधिक लोग किसी कार्य में लगे हों और उनके हटने से उत्पादन पर प्रभाव न पड़े।",
            conceptsEnglish = "Economic classification: Primary (nature-based), Secondary (manufacturing), Tertiary (service provision). Disguised unemployment occurs when more workers are engaged in an activity than necessary.",
            simpleAnalogy = "Kapas ugaana = Primary, Kapas se shirt banana = Secondary, Aur us shirt ko dukan par bechna ya courier karna = Tertiary Service!",
            formulaOrKeyPoint = "GDP Contribution: Tertiary is highest | Employment: Primary is highest"
        )
    )

    val QUESTIONS = listOf(
        QuestionItem(
            id = "sst_q1",
            chapterId = "sst_ch2",
            subjectId = "sst",
            type = "SA",
            questionHinglish = "What were the main reasons why Mahatma Gandhi called off the Non-Cooperation Movement in 1922?",
            questionHindi = "महात्मा गांधी ने 1922 में असहयोग आंदोलन को वापस क्यों लिया? मुख्य कारण लिखिए।",
            questionEnglish = "Why did Mahatma Gandhi decide to withdraw the Non-Cooperation Movement in February 1922?",
            solutionHinglish = "Main Reason: The Chauri Chaura Incident (5 February 1922)\n1. Place: Gorakhpur district, Uttar Pradesh.\n2. Event: Ek peaceful demonstration par police ne lathicharge kiya, jiske gusse me aakar bheed ne Chauri Chaura police station ko aag laga di, jisme 22 policemen zinda jal gaye.\n3. Gandhi's Principle: Mahatma Gandhi ahimsa (non-violence) ke pakke samarthak the. Unhone mehsoos kiya ki log abhi poori tarah non-violent satyagraha ke liye trained nahi hain aur andolan violent mod le raha hai.\n4. Decision: Desh ko hinsa ki aag se bachane ke liye Gandhiji ne 12 February 1922 ko Bardoli me andolan turant wapas lene (call off) ka ailan kiya.",
            solutionHindi = "उत्तर: चौरी-चौरा की हिंसक घटना (फरवरी 1922)।\n1. 5 फरवरी 1922 को गोरखपुर (उ.प्र.) के चौरी-चौरा में शांतिपूर्ण जुलूस पर पुलिस द्वारा गोली चलाने के बाद उत्तेजित भीड़ ने थाने में आग लगा दी, जिसमें 22 पुलिसकर्मी मारे गए।\n2. गांधीजी का मानना था कि सत्याग्रह पूरी तरह अहिंसक होना चाहिए। हिंसा देखकर उन्होंने अनुभव किया कि जनता अभी व्यापक आंदोलन के लिए तैयार नहीं है।\n3. अतः उन्होंने 12 फरवरी 1922 को असहयोग आंदोलन वापस लेने का ऐतिहासिक निर्णय लिया।",
            solutionEnglish = "The primary reason was the violent Chauri Chaura incident in Gorakhpur (Feb 1922), where an angry mob set fire to a police station, killing 22 policemen. Committed to non-violence, Gandhi felt satyagrahis needed proper discipline before mass agitation.",
            formulaUsed = "Chauri Chaura Violence (1922) -> Violation of Ahimsa",
            marks = 3,
            examTip = "Important for revision: Chauri Chaura incident ka year (1922), jagah (Gorakhpur), aur Ahimsa ka siddhant zaroor likhein."
        ),
        QuestionItem(
            id = "sst_q2",
            chapterId = "sst_ch3",
            subjectId = "sst",
            type = "SA",
            questionHinglish = "Differentiate between Alluvial Soil and Black Soil with respect to formation and crops grown.",
            questionHindi = "जलोढ़ मृदा और काली मृदा में निर्माण एवं फसलों के आधार पर अंतर स्पष्ट कीजिए।",
            questionEnglish = "Differentiate between Alluvial Soil and Black Soil regarding their origin and suitable crops.",
            solutionHinglish = "Point 1: Formation (Nirman)\n- Alluvial Soil: Yeh nadiyon (Ganga, Indus, Brahmaputra) dwara laye gaye silt/alluvium ke jamaav se banti hai.\n- Black Soil: Yeh volcanic rocks aur Deccan plateau ke lava ke tootne-phootne se banti hai.\n\nPoint 2: Color and Texture\n- Alluvial: Light grey to yellowish, sandy-loam texture.\n- Black: Deep black color, high clay content, develops deep cracks in summer.\n\nPoint 3: Key Nutrients\n- Alluvial: Potash aur Phosphoric acid me rich hoti hai.\n- Black: Calcium carbonate, magnesium, aur potash me rich hoti hai.\n\nPoint 4: Major Crops Grown\n- Alluvial: Wheat, Rice, Sugarcane, Pulses.\n- Black: Cotton (कपास), Soybean, Tobacco.",
            solutionHindi = "अंतर:\n1. निर्माण: जलोढ़ मृदा हिमालयी नदियों के निक्षेपों से बनती है; जबकि काली मृदा ज्वालामुखी के बेसाल्ट लावा से निर्मित होती है।\n2. क्षेत्र: जलोढ़ मृदा उत्तरी मैदानों में पाई जाती है; काली मृदा मालवा (मध्य प्रदेश) व महाराष्ट्र में पाई जाती है।\n3. प्रमुख फसलें: जलोढ़ में गेहूं, धान, गन्ना; काली मृदा में कपास (Cotton) व सोयाबीन।",
            solutionEnglish = "Alluvial soil is deposited by river systems in northern plains, rich in potash, ideal for wheat/rice. Black soil is formed from volcanic Deccan lava, retains high moisture, and is ideal for cotton and soybean.",
            formulaUsed = "Comparative Analysis Matrix",
            marks = 4,
            examTip = "Important for revision: MP Board me differences hamesha tabular form me 4 distinct points me likhein."
        ),
        QuestionItem(
            id = "sst_q3",
            chapterId = "sst_ch5",
            subjectId = "sst",
            type = "LA",
            questionHinglish = "Explain Disguised Unemployment with an example. What is MGNREGA 2005?",
            questionHindi = "प्रच्छन्न (छिपी हुई) बेरोजगारी को उदाहरण सहित समझाइए। मनरेगा 2005 क्या है?",
            questionEnglish = "Explain Disguised Unemployment with an example and state the objectives of MGNREGA 2005.",
            solutionHinglish = "Part 1: Disguised Unemployment (प्रच्छन्न बेरोजगारी)\nYeh ek aisi sthiti hai jahan log visible roop se kaam karte dikhte hain, par unki marginal productivity zero hoti hai. Agar inme se kuch logon ko kaam se hata bhi diya jaye, toh bhi total production par koi farak nahi padega.\nExample: Ek 2-hectare khet par ek parivar ke 8 sadasya kaam kar rahe hain, jabki us khet par sirf 4 logon ki zaroorat hai. Baaki ke 4 log 'disguisedly unemployed' hain.\n\nPart 2: MGNREGA 2005 (Mahatma Gandhi National Rural Employment Guarantee Act)\n1. Right to Work: Grameen kshetron ke har parivar ko saal me kam se kam 100 din ke guaranteed unskilled rozgar ka adhikar deta hai.\n2. Unemployment Allowance: Agar sarkar 15 din ke andar kaam nahi de pati hai, toh rozgar bhatta (unemployment allowance) dena padta hai.\n3. Women Reservation: Kam se kam 1/3 jobs mahilaon ke liye reserved hain.",
            solutionHindi = "1. प्रच्छन्न बेरोजगारी: जब किसी कार्य में आवश्यकता से अधिक श्रमिक लगे हों। उदाहरण: 1 एकड़ खेत में 3 लोगों का काम है, परंतु पूरा परिवार (6 सदस्य) लगा है। 3 अतिरिक्त लोगों की उत्पादकता शून्य है।\n2. मनरेगा 2005: ग्रामीण परिवारों को प्रतिवर्ष 100 दिनों के अकुशल रोजगार की कानूनी गारंटी देता है। 15 दिन में काम न मिलने पर बेरोजगारी भत्ता देय होता है।",
            solutionEnglish = "Disguised unemployment is when more people are employed in a job than actually required. MGNREGA 2005 provides legal guarantee of 100 days wage employment per rural household.",
            formulaUsed = "Disguised Unemployment + MGNREGA 100-Day Provision",
            marks = 5,
            examTip = "Important for revision: MGNREGA ke 100 din aur 1/3 women reservation provisions zaroor point out karein."
        )
    )

    val MCQS = listOf(
        McqItem(
            id = "sst_mcq1",
            chapterId = "sst_ch2",
            subjectId = "sst",
            questionHinglish = "Jallianwala Bagh Hatyakand kis din aur kis shahar me hua tha?",
            questionHindi = "जलियांवाला बाग हत्याकांड किस तिथि को और कहाँ हुआ था?",
            questionEnglish = "On which date and in which city did the Jallianwala Bagh massacre take place?",
            options = listOf("13 April 1919, Amritsar", "15 August 1919, Lahore", "13 April 1920, Delhi", "26 January 1919, Meerut"),
            correctOptionIndex = 0,
            explanationHinglish = "13 April 1919 ko Baisakhi ke din Amritsar ke Jallianwala Bagh me General Dyer ne nireehe logon par goliya chalwai thi.",
            explanationHindi = "13 अप्रैल 1919 को बैसाखी के दिन अमृतसर के जलियांवाला बाग में यह नृशंस हत्याकांड हुआ था।",
            explanationEnglish = "The tragic massacre occurred on 13 April 1919 in Amritsar, Punjab under General Dyer's command."
        ),
        McqItem(
            id = "sst_mcq2",
            chapterId = "sst_ch3",
            subjectId = "sst",
            questionHinglish = "Kapas (Cotton) ki kheti ke liye sabse upyukt mitti kaun si maani jaati hai?",
            questionHindi = "कपास की खेती के लिए सर्वाधिक उपयुक्त मृदा कौन सी मानी जाती है?",
            questionEnglish = "Which soil is considered most suitable for growing cotton?",
            options = listOf("लाल मृदा (Red Soil)", "काली या रेगुर मृदा (Black Soil)", "लैटेराइट मृदा (Laterite Soil)", "मरुस्थलीय मृदा (Desert Soil)"),
            correctOptionIndex = 1,
            explanationHinglish = "Kaali mitti (Black soil) ko Regur mitti ya Black Cotton Soil bhi kaha jata hai kyunki yeh cotton ke liye sabse behtareen hoti hai.",
            explanationHindi = "काली मृदा (रेगुर मृदा) में जल धारण क्षमता अधिक होती है और यह कपास उत्पादन हेतु सर्वोत्तम होती है।",
            explanationEnglish = "Black soil, also known as Regur soil, is ideal for cotton cultivation due to high clay content and moisture retention."
        ),
        McqItem(
            id = "sst_mcq3",
            chapterId = "sst_ch5",
            subjectId = "sst",
            questionHinglish = "MGNREGA yojana ke antargat sarkar kitne dinon ke rozgar ki guarantee deti hai?",
            questionHindi = "मनरेगा योजना के अंतर्गत सरकार एक वर्ष में कितने दिनों के रोजगार की कानूनी गारंटी देती है?",
            questionEnglish = "Under the MGNREGA scheme, how many days of employment is guaranteed in a year?",
            options = listOf("50 din", "100 din", "150 din", "200 din"),
            correctOptionIndex = 1,
            explanationHinglish = "MGNREGA 2005 ke tehat har rural household ko ek financial year me kam se kam 100 days ka guaranteed work milta hai.",
            explanationHindi = "मनरेगा 2005 के अनुसार प्रत्येक ग्रामीण परिवार को प्रतिवर्ष कम से कम 100 दिनों के अकुशल कार्य की गारंटी दी जाती है।",
            explanationEnglish = "MGNREGA guarantees at least 100 days of wage employment per financial year to every rural household."
        )
    )
}
