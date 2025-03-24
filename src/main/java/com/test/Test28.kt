package com.test

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.nio.ByteBuffer

fun main() {
    val readers = listOf(
        StringCharReader,
        StringBuilderCharReader,
        CharArrayCharReader,
        ForInputStreamReader
    )

    readers.forEach { it.dimension(Text.text) }
}

interface MainReader {

    val description: String

    fun read(text: String)

    fun dimension(text: String) {
        val start = System.currentTimeMillis()
        this.read(text)
        val finish = System.currentTimeMillis()

        println("Ридер: \"${this.javaClass.simpleName}\", Метод: ${this.description}, время работы: ${finish - start}")
    }
}



object StringCharReader: MainReader {
    override val description: String
        get() = "Читаем по символам и пишем в строку"

    override fun read(text: String) {
        var resultText = ""

        var cursor = 0

        while (cursor < text.length){
            resultText += text[cursor]
            cursor++
        }
    }
}

object StringBuilderCharReader: MainReader {
    override val description: String
        get() = "Читаем по символам и пишем в билдер"
    override fun read(text: String) {
        val sb = StringBuilder()

        var cursor = 0

        while (cursor < text.length){
            sb.append(text[cursor])
            cursor++
        }

        var resultText = sb.toString()
//        println("\n\n ${resultText.substring(0, 100)}")
    }
}

object CharArrayCharReader: MainReader {
    override val description: String
        get() = "Читаем из массива символов и пишем в массив"
    override fun read(text: String) {
        val temp = text.toCharArray()
        val resultTemp = CharArray(temp.size)
        var cursor = 0

        while (cursor < text.length){
            resultTemp[cursor] = temp[cursor]


            cursor++
        }

        val resultText = resultTemp.concatToString()
//        println("\n\n ${resultText.substring(0, 100)}")
    }
}

object ForInputStreamReader: MainReader {
    override val description: String
        get() = "Читаем inputStream и пишем в массив"
    override fun read(text: String) {

        val listOfLines = mutableListOf<String>()
        val inputStream: InputStream = text.byteInputStream()
        inputStream.bufferedReader().useLines{
                lines -> lines.forEach {
                    listOfLines.add(it)
                }
        }
        inputStream.close()

        val resultText = listOfLines.joinToString("\n")
//        println("\n\n ${resultText.substring(0, 100)}")
    }
}

object ByteBufferByteReader: MainReader {
    override val description: String
        get() = "Читаем по байтам и пишем в буффер"
    override fun read(text: String) {
        val inputStream: InputStream = text.byteInputStream()



        val sb = StringBuilder()

//        val buffer = ByteBuffer(text.length)

        var cursor = 0

        while (cursor < text.length){
            sb.append(text[cursor])
            cursor++
        }

        var resultText = sb.toString()
//        println("\n\n ${resultText.substring(0, 100)}")
    }
}

object Text {
    val text = "РОЛЬ ДЕТСКОЙ ПСИХИАТРИИ В ПОДГОТОВКЕ ПСИХОЛОГОВ\n" +
            "И ДРУГИХ СПЕЦИАЛИСТОВ, РАБОТАЮЩИХ С ДЕТЬМИ\n" +
            "Следует развеять достаточно распространенное заблуждение о том, что психолог, как и другие специалисты-непсихиатры, не должен заниматься психическими больными, так как он с ними не встречается, а если это и происходит, то ему\n" +
            "необходимо сразу направить больного к психиатру, не принимая участия в его\n" +
            "судьбе. В действительности это большая ошибка. Существует множество измененных личностей, которые или никогда не лечатся, или делают это редко. Они находятся в обществе психически здоровых людей. Значительное их число — среди\n" +
            "подростков с девиантным поведением, отклонениями в развитии, нарушениями\n" +
            "органов чувств. Они часто нуждаются лишь в коррекционных педагогических\n" +
            "мерах. Кроме того, даже требующие лечения психически больные могут долгое\n" +
            "время (до выраженного проявления заболевания) находиться в обществе, прежде\n" +
            "чем им будет поставлен диагноз. Обе эти группы психических расстройств требуют подхода, который возможен лишь при понимании границ между психическим\n" +
            "здоровьем и болезнью. Изучение этих границ — задача пограничной психиатрии.\n" +
            "Последняя — «область несравненно более тонкая, область более сложная, требующая гораздо большего опыта, навыков и знания, чем психиатрия большая,\n" +
            "где речь идет о душевнобольных в узком смысле слова» (Ганнушкин П. Б., 1924).\n" +
            "Одно из приложений психиатрических знаний — выявление разнообразной психопатологической симптоматики, нередко наблюдающейся у лиц с отклонениями\n" +
            "в развитии, речевой патологией, нарушениями органов чувств.\n" +
            "В то время, как некоторые психологи не считают психиатрию обязательной\n" +
            "для основательного обучения, многие люди без всякого психологического образования (администраторы, юристы, педагоги, воспитатели и обыватели) полагают,\n" +
            "что компетентны в этой отрасли медицинских знаний. Они пытаются делать свои\n" +
            "заключения, которые нередко приносят вред тому, кого они касаются.\n" +
            "Детская психиатрия, объединяя медицинские знания, дает профессионалу, работающему в области специальной психологии и педагогики, необходимые предпосылки для формирования его мировоззрения. Она снабжает поучительными\n" +
            "и полезными для профессионалов знаниями. Главной целью преподавания этой\n" +
            "клинической дисциплины является развитие мышления, способного оценить психические явления и его отклонения. Нет соматической медицины с одной стороны\n" +
            "и психиатрии — с другой; медицина, так же как и объект ее изучения — больной человек, едина. Лишь практическая жизнь и психиатрическая клиника разделяют две\n" +
            "стороны одного и того же дела. При этом психиатрическая клиника имеет свои особенности, которые не встречаются в других отраслях клинической медицины. Психиатрическое мышление является по необходимости и очень углубленным, и очень\n" +
            "широким. Оно не может игнорировать общего состояния организма. Наука, всесторонне изучающая ребенка, исследуя в неотрывной связи его биологическую\n" +
            "сущность и душевную организацию, приводит неоспоримые доводы в пользу необходимости всестороннего изучения клиента (больного).\n" +
            "Каждый нервно-психический больной — в то же время и соматический больной. По мнению Д. Д. Плетнева (1989), нет соматических болезней без психических из них вытекающих отклонений, как нет психических заболеваний, изолированных от соматических симптомов. В этой связи обследованию психики\n" +
            "обязательно должно предшествовать изучение соматического состояния любого\n" +
            "консультируемого ребенка, даже не имеющего статуса больного. \n" +
            "Защищая самостоятельность, психиатрия в начале своего формирования в качестве самостоятельной науки стремилась уйти подальше от соматической медицины. В настоящее время все хорошо понимают, что от связи психиатрии с общей\n" +
            "медициной выигрывают обе науки, лучше понимается больной, а потому и эффективнее оказывается ему помощь. Примером плодотворности такого взаимодействия могут служить используемые в теории и практике концепции: психопатологии развития, внутренней картины болезни, соматизации нервно-психических\n" +
            "нарушений и психосоматических расстройств.\n" +
            "Психика каждого больного ребенка не остается безучастной при любом соматическом заболевании. С одной стороны, она зависит от органов и систем, пораженных при болезни, от инфекционных, токсических и других воздействий.\n" +
            "С другой — возникает реакция личности, направленная на само заболевание, соответственно страданиям и боли, в то же время она соответствует личностным\n" +
            "особенностям больного. Более точно и всестороннее под названием внутренней\n" +
            "картины болезни (ВКБ) описал психическое состояние соматического больного\n" +
            "Р. А. Лурия (1935). Он считал, что ВКБ — это «все то, что испытывает и переживает больной, вся масса его ощущений, не только местных болезненных, но его\n" +
            "общее самочувствие, самонаблюдение, его представления о своей болезни, о ее\n" +
            "причинах, все то, что связано для больного с приходом его к врачу, — весь тот\n" +
            "огромный внутренний мир больного, который состоит из весьма сложных сочетаний восприятия и ощущения, эмоций, аффектов, конфликтов, психологических\n" +
            "переживаний и травм». Вся эта комплексная реакция должна учитываться психологом и всеми, кто работает с детьми, во время их даже кратковременных болезней, не боясь ни недооценить психическое состояние, ни переоценить его. При\n" +
            "этом оценка психического состояния больного будет тем правильнее, чем точнее\n" +
            "будет определен тип личности заболевшего, от которого в значительной степени\n" +
            "зависит успешность борьбы с заболеванием.\n" +
            "Феномен «соматизации», т. е. появление таких симптомов нарушения телесных функций, как головные боли, бессонница, исчезновение аппетита, боли в животе, вялость, слабость и т. д., часто наблюдается при нервно-психических расстройствах. Он является эквивалентом психопатологических проявлений и может\n" +
            "служить убедительной иллюстрацией существующей тесной связи между телом\n" +
            "и психикой, которая обнаруживается в процессе заболевания.\n" +
            "Широко распространены «болезни адаптации», или психосоматические расстройства (соматоформные): гипертоническая болезнь, язва желудка, бронхиальная астма, психическая анорексия и другие болезни. Их распространенность у детей превышает 40 %. Они являются нарушениями деятельности различных органов и систем тела, происхождение которых в большей или меньшей степени связано со стрессами (накоплением отрицательных эмоций в связи с переживанием\n" +
            "житейских трудностей). Эти болезни являются еще одним убедительным доказательством существующей у людей взаимосвязи соматического и психического.\n" +
            "Сказанное можно обобщить следующим образом: без осознания профессионалом факта целостности душевного и телесного невозможно успешно распознавать\n" +
            "нервно-психические расстройства, помогать больным и консультировать здоровых детей.\n" +
            "Общая психопатология, являющаяся частью психиатрии, изучающей симптомы душевных болезней и их сочетания (синдромы), представляет материалы,\n" +
            "необходимые для понимания больного, для диагностики заболеваний.\n" +
            "Изучение распространенности психических заболеваний обнаруживает все\n" +
            "увеличивающееся число психических больных среди взрослых и детей. Первичная инвалидность вследствие психических заболеваний в 1990 г. была 2,51 че-\n" +
            "ловека на 100 тыс. населения, в 1996 г. — 3,88, т. е. выросла на 54,6 %. Каждый\n" +
            "год в отдельных регионах России число суицидов увеличивается на 10 %. По\n" +
            "сравнению с 1960-ми годами в настоящее время риск родить умственно отсталого\n" +
            "ребенка увеличился в 1,5—2 раза. Выявление причинных факторов, приводящих\n" +
            "к возникновению нервно-психических расстройств, констатирует существование\n" +
            "широкого круга вредностей: от материнской депривации до региональных и глобальных экологических катастроф. Все это должно привести психолога и педагога\n" +
            "к выводу о необходимости проведения в детско-подростковой популяции, являющейся контингентом повышенного риска, всеохватывающей психопрофилактики.\n" +
            "Вместо декларативных призывов к профилактической работе необходимо использовать методики выявления контингентов детей повышенного риска. В частности, придется изучить эпидемиологические методы. Более того, следует знать, что\n" +
            "никакая превентивная деятельность невозможна без организации соответствующей работы среди педиатров, педагогов, воспитателей, служащих открытых и закрытых детских учреждений, администраторов, без привлечения добровольных\n" +
            "помощников из местной общественности, верующих, родителей больных, представителей фондов и других организаций, готовых помогать страждущим. Психологам и другим специалистам, работающим с детьми, необходимо освоить методические приемы для работы с членами семей, где воспитываются дети, чтобы\n" +
            "помочь в создании благоприятного психологического климата, столь необходимого для адекватного воспитания и сохранения здоровья детей. Следует организовать совместную деятельность с педиатрами, педагогами, обучить анализу отношений в семье и методике помощи ее членам, что расширит круг специалистов,\n" +
            "помогающих семье укреплять душевное благополучие и правильно воспитывать\n" +
            "детей. Консультирование соматически больных детей позволит улучшить вторичную профилактику, распознать неразвернутые формы или начальные проявления\n" +
            "соматогенных нервно-психических расстройств. Кроме того, следует направить\n" +
            "внимание на психологические проблемы, возникающие у хронически больных,\n" +
            "особенно у физически неполноценных инвалидов-детей и подростков, а также\n" +
            "у умирающих больных. Большую роль психолог может сыграть в реабилитации\n" +
            "детей, перенесших соматические болезни. Значительных успехов в сохранении\n" +
            "и укреплении психического здоровья детей можно добиться организацией психопрофилактики непосредственно в детских садах и школах, привлекая для этой\n" +
            "цели воспитателей и учителей. Педагогам следует знать о возрастных психологических особенностях детей, о различных психических состояниях и типичных\n" +
            "проявлениях некоторых отклонений. Дети, и особенно подростки, тоже смогут\n" +
            "участвовать в укреплении своего здоровья, для этого их придется ознакомить\n" +
            "с элементами психологии и некоторыми проявлениями нервно-психических расстройств. Через педагогов возможно также привлечение к психопрофилактической работе всех тех, кто работает с детьми в часы досуга (инструкторов кружков,\n" +
            "тренеров спортивных секций, хореографов и т. д.), а также родителей и других\n" +
            "членов семьи. Психологам необходимы знания по психологии семьи, без чего невозможно анализировать процессы, происходящие в семье и оказывающие решающее влияние на формирование личности ребенка, укрепляющие или разрушающие ее защитные силы. Знания социальной динамики позволят правильно понять\n" +
            "воздействие на семью положительных и отрицательных факторов, а также управлять ими. Для психологов и других специалистов, работающих с детьми, это имеет особое значение, так как примерно 80 % психогенных расстройств (неврозов,\n" +
            "нарушений поведения), возникающих в детском возрасте, обусловлены неблагоприятной семейной ситуацией. Психопрофилактика должна быть приоритетной\n" +
            "по сравнению с любыми другими видами деятельности: консультированием, кор-\n" +
            "рекционно-педагогическими мерами воздействия на больных или аномальных\n" +
            "детей и подростков и др. Сохранение психического здоровья детей и предупреждение нервно-психических расстройств целесообразнее, доступнее и эффективнее,\n" +
            "чем коррекция и лечение уже возникших нарушений и заболеваний. Осознание\n" +
            "этого должно привести к тому, чтобы все специалисты, работающие с детьми, разрабатывали меры первичной, вторичной и третичной профилактики. При этом\n" +
            "первичная профилактика была бы направлена на недопущение развития заболеваний. Вторичная — на предупреждение осложнений, а третичная — на создание\n" +
            "препятствий появлению новых расстройств у хронически больных или инвалидов\n" +
            "со стойкими отклонениями в развитии психики.\n" +
            "Знания по психопатологии развития необходимы для определения границ\n" +
            "компетентности непсихиатров в отношении курируемых детей и очертаний этого\n" +
            "контингента. Полученные сведения позволят уточнить особенности психического\n" +
            "состояния детей, а также учесть возрастную специфику патопсихологии, без которой невозможен эволюционный подход к диагностике созревающей личности, понимание динамики заболевания и лечение в соответствии с возрастом больного.\n" +
            "Психиатрическая подготовка дает будущим специалистам возможность правильно определить, имеются ли у детей отклонения, чтобы направить их, при необходимости, в то или иное детское учреждение с учетом наличия или отсутствия\n" +
            "психопатологических симптомов.\n" +
            "Психологу для совместной работы с врачами (педиатром, психиатром, неврологом) необходимо также разбираться в терминологии и симптоматике нервнопсихических расстройств. Не ориентируясь в ней, невозможно правильно составить психологическое заключение в случае подозрения на наличие психического\n" +
            "заболевания. Консультируя родителей, педагогов и других специалистов, работающих с детьми, имеющими отклонения в развитии, психологи должны использовать сведения из области возрастной психиатрии. Эти сведения могут иметь большое значение для успешной абилитации (социальной адаптации) и реабилитации\n" +
            "больных детей и подростков.\n" +
            "Знакомство с отдельными симптомами, их сочетаниями в форме синдромов\n" +
            "и наиболее часто встречающимися заболеваниями позволит правильно ориентироваться в психопатологии. Откроется путь для более точной диагностики различных вариантов нарушений поведения и патологического развития личности.\n" +
            "Появится возможность разобраться во всех оттенках переживаний невротических\n" +
            "больных и научиться отграничивать их от психотических расстройств. Исчезнет\n" +
            "опасность не распознать у детей появление эпилептических состояний и даже\n" +
            "нетипичных проявлений эпилептической болезни. Соматические заболевания\n" +
            "больных детей не будут рассматриваться в отрыве от их душевного состояния, от\n" +
            "которого эти болезни в той или иной степени зависят.\n" +
            "Особенное значение освоенные знания по психопатологии имеют для анализа\n" +
            "психических аномалий при речевой патологии, некоторых поведенческих нарушений, парциальных форм психического недоразвития и задержек психического\n" +
            "развития. Они позволят без больших ошибок диагностировать структуру психических расстройств, имеющихся при различных степенях умственной отсталости,\n" +
            "задержках психического развития и парциальных нарушениях психики. Этот\n" +
            "анализ облегчит составление рекомендаций по коррекционной педагогике и абилитации детей с отклонениями в развитии.\n" +
            "Изучая психиатрию, учащийся получает очень важные знания по клиническим и другим методикам изучения психически больного ребенка, а также его\n" +
            "семьи. Возникает понимание необходимости этих исследований для диагностики\n" +
            "и оценки динамики психических нарушений под влиянием терапии. Осваивает-\n" +
            "ся специфика сбора субъективного анамнеза жизни и болезни, полученного от\n" +
            "больного ребенка. Из объективного анамнеза, собранного не от самого больного,\n" +
            "а от его окружающих (по возможности незаинтересованных свидетелей болезни),\n" +
            "прежде всего от родителей и родственников, может быть получен материал, который, возможно, станет решающим для установления диагноза. Анамнез тоже\n" +
            "является источником сведений о родителях больного. Психопатология позволяет\n" +
            "овладеть схемой обследования психически больного, которая представляет собой\n" +
            "структурированную беседу. С ее помощью удается выявлять отдельные симптомы и даже распознавать заболевание. Умение беседовать с психически больным\n" +
            "дается не только знанием и опытом, но и определенными психическими качествами: вдумчивостью, внимательным отношением к больному, правдивостью,\n" +
            "простотой в общении, лишенной лицемерия и слащавости. Именно это необходимо для успешного получения анамнеза. Существенное значение имеет наблюдение за поведением больного. В связи с большой длительностью психических\n" +
            "заболеваний, повторностью приступов, возможностью неполного выздоровления\n" +
            "особенную роль играет катамнез (прослеживание судьбы больного). Он важен\n" +
            "также для оценки результатов лечения, абилитации, реабилитации и качества\n" +
            "жизни больного.\n" +
            "Психологам крайне необходимы знания методов психопатологической диагностики. Их используют для оценки уровня интеллектуального функционирования, особенностей созревания личности в целом, выявления психотравмирующих\n" +
            "комплексов, диагностики психических дефектов, установления функционального\n" +
            "диагноза.\n" +
            "Уровень профессионального мастерства психологов не может быть высоким без знания современных научных направлений и систематик заболеваний —\n" +
            "Международной классификации болезней 10-го пересмотра (МКБ-10) и других.\n" +
            "Освоение этих систематик позволит специалисту не только правильно кодировать\n" +
            "психические расстройства, но и успешно проводить их диагностику и дифференциальную диагностику.\n" +
            "Курс психиатрии дает представление об основных электрофизиологических,\n" +
            "рентгенологических, биохимических и других лабораторных методиках. Сведения\n" +
            "об этих параклинических исследованиях и получаемых в результате их проведения данных необходимы для понимания важности изучения биологических основ\n" +
            "психических заболеваний с целью их диагностики. Они используются также для\n" +
            "проникновения в этиологию и патогенез (механизм развития) диагностируемых\n" +
            "болезней.\n" +
            "Психологу жизненно необходимо освоить и социальную психиатрию. Она\n" +
            "ставит своей целью учитывать появление психически больных, что позволяет\n" +
            "иметь представление о распространенности различных форм психопатологии. Без\n" +
            "этих знаний невозможно оценить степень опасности того или иного заболевания,\n" +
            "очень сложно осуществлять превентивные меры в отношении групп повышенного\n" +
            "риска. В настоящее время это особенно актуально, так как очень быстрые социальные и экономические изменения в стране приводят к росту нервно-психических расстройств, алкоголизации и наркотизации. Так, половина дошкольников\n" +
            "эмоционально неустойчива, треть — беспокойна, агрессивна, или напротив, боязлива. 16—29 % детей 6-летнего возраста не готова к обучению в школе. У трети\n" +
            "школьников наблюдаются невротические расстройства. Только 15—20 % детей\n" +
            "оканчивают школу практически здоровыми, остальные страдают язвой желудка,\n" +
            "гастритом, колитом, неврозами, гипертонической болезнью и другими психосоматическими заболеваниями и нервно-психическими расстройствами. Столь раннее нарушение детского здоровья объясняется в первую очередь неблагополучием \n" +
            "в семьях, нестабильностью материального положения, конфликтами между членами семьи, пренебрежением родительскими обязанностями и т. д.\n" +
            "Социальная психиатрия разрабатывает юридические нормы, защищающие\n" +
            "права несовершеннолетних больных и регламентирующие работу с ними. Она же\n" +
            "формулирует правила, определяющие, кого из детей, как и когда следует консультировать у детско-подросткового психиатра, кто и при каких условиях направляется в стационарные учреждения. Взаимодействие с психиатрической службой\n" +
            "позволяет успешнее помогать больным, если у них распознаются нервно-психические расстройства и они своевременно направляются к психиатру для лечения.\n" +
            "Кроме того, специалисты, сотрудничающие с психиатром, могут получить информацию о совпадении своих заключений по поводу предполагаемых расстройств\n" +
            "с врачебной диагностикой, а также о состоянии направленных на лечение детей.\n" +
            "Это поможет проконтролировать уровень психиатрических знаний и тем самым\n" +
            "будет способствовать их улучшению.\n" +
            "Существует понимание важности проблем умственной отсталости и задержек\n" +
            "психического развития, однако не у всех завершивших высшее психологическое\n" +
            "образование хватает умения без больших ошибок диагностировать эти состояния.\n" +
            "Освоение приведенного здесь комплекса знаний и умений должно ликвидировать\n" +
            "этот пробел, дать необходимые знания и предоставить возможности для получения необходимого опыта.\n" +
            "Изменение структуры семьи, новое положение женщины в обществе, более\n" +
            "свободная сексуальная мораль, акселерация подростков, опасность заболевания\n" +
            "СПИДом и другими заболеваниями, передающимися половым путем, — все это\n" +
            "у детей, и особенно подростков, в процессе возрастных изменений создает психологические трудности, а иногда и приводит к нервно-психическим расстройствам.\n" +
            "Это, вместе с другими факторами, — важные аргументы в пользу ознакомления\n" +
            "с закономерностями психосексуального развития и его аномалий, а также основ\n" +
            "полового воспитания.\n" +
            "Не только правовым, но и нравственным ориентиром в работе психолога может служить принятый в 1992 г. Закон РФ «О психиатрической помощи и гарантиях прав граждан при ее оказании». Основные его положения, касающиеся детей,\n" +
            "требуют скрупулезного их соблюдения, и именно это будет создавать единственно возможный деонтологический климат в процессе работы с детьми, имеющими\n" +
            "нервно-психические расстройства и отклонения в развитии, а также с их семьями. Детальное изучение других официальных документов также должно являться\n" +
            "не только укреплением юридических знаний, но и способствовать созданию обязательной высокой моральной атмосферы, являющейся необходимым условием\n" +
            "оказания помощи душевнобольным детям и подросткам.\n" +
            "Перефразируя слова П. Б. Ганнушкина, можно в заключение сказать, что главная цель и изучения, и преподавания психиатрии должна состоять в том, чтобы\n" +
            "научить специальных психологов и других специалистов, работающих с детьми,\n" +
            "быть патопсихологами не только в детских учреждениях и центрах, но прежде\n" +
            "всего, в жизни, т. е. относиться к так называемым душевно здоровым, нормальным детям с тем же пониманием, с той же мягкостью, с той же вдумчивостью, но\n" +
            "и с той же прямотой, как к душевно нездоровым; разница между теми и другими,\n" +
            "если иметь в виду границы здоровья и болезни, вовсе не так уже велика."
}