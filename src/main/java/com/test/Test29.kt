package com.test

import java.util.regex.Pattern

fun main() {
    val text = "Мы решили попрощаться красиво с 2024 годом и до конца декабря дарим вам самое выгодное предложение в этом году:\n" +
            "Скидки до 70% на все наши курсы.\n" +
            "До 12 уроков в подарок.\n" +
            "Год бесплатного доступа к обучающей онлайн-платформе\n" +
            "Но это еще не всё!\n" +
            "\n" +
            "Мы продлили акцию, действующую только для наших учеников: теперь вы можете получить курс по акценту от Accentit при оплате от 32 уроков до 31 декабря включительно.\n" +
            "\n" +
            "Напишите слово «зима» в ответ на это письмо, наши специалисты свяжутся с вами.\n" +
            "\n" +
            "Этот курс — для вас, если:\n" +
            "Вы хотите впечатлять своим английским.\n" +
            "Трудно понимаете носителей на слух.\n" +
            "Часто путешествуете или работаете с иностранцами.\n" +
            "Мечтаете о карьере в международной компании.\n" +
            "Сделайте шаг к идеальному английскому сейчас! \uD83C\uDF84"

//    println(reducingText(text, 52))

    val changeStatus = """
        _{{authorName}}_:
        Изменен статус задачи: {{changeStatusText}}

        Задача: *{{taskTitle}}*
        Проект: {{projectTitle}}

        Ссылка на задачу: {{link}}
    """.trimIndent()

    val result = setParameters(changeStatus, mapOf("authorName" to "Александр Алтухов", "taskTitle" to "Название Задачи"))

//    println(result)

    val taskLink = "{{domain}}/#/crm/task/{{taskId}}"

//    val link = setParameters(taskLink, mapOf("domain" to "https://crm.local:8080", "taskId" to "92"))
//    val link = replaceTemplateAllAliasesOrNull(taskLink, mapOf("domain" to "https://crm.local:8080", "taskId" to "92"))
    val link = replaceTemplateAllAliasesOrNull(taskLink, mapOf("domain" to "https://crm.local:8080", "taskId" to null))

    println(link)

}

private fun setParameters(template: String, parameters: Map<String, String>): String {
    var result = template
    val regex = Regex("\\{\\{.*?}}")
    var param = nextParameter(regex, result)
    while (param != null) {
        result = result.replace("{{$param}}", parameters[param] ?: "")
        param = nextParameter(regex, result)
    }
    return result
}

fun replaceTemplateAllAliasesOrNull(template: String, parameters: Map<String, String?>): String? {
    var result = template
    val regex = Regex("\\{\\{.*?}}", RegexOption.CANON_EQ)
    var param = nextParameter(regex, result)
    while (param != null) {
        result = result.replace("{{$param}}", parameters[param] ?: return null)
        param = nextParameter(regex, result)
    }
    return result
}

private fun nextParameter(regex: Regex, text: String)
        = regex.find(text)?.groups?.first()?.value?.removePrefix("{{")?.removeSuffix("}}")

fun reducingText(text: String, limit: Int): String {
    if (text.length > limit) {
        val length = limit - 3
        val pattern = Pattern.compile("^.{0,$length}\\b")
        val matcher = pattern.matcher(text)
        return if (matcher.find()) {
            matcher.group(0).plus("...")
        } else {
            text.substring(0, length).plus("...")
        }
    } else {
        return text
    }
}