package com.test

fun main() {
//    val notisList = listOf(
//        Notis(1, "Notise1 by user 1", listOf("")),
//        Notis(2, "Notise1 by user 2", listOf("")),
//        Notis(1, "Notise2 by user 1", listOf("")),
//        Notis(3, "Notise1 by user 3", listOf("")),
//        Notis(2, "Notise2 by user 2", listOf("")),
//        Notis(3, "Notise2 by user 3", listOf("")),
//        Notis(1, "Notise3 by user 1", listOf("")),
//        Notis(3, "Notise3 by user 3", listOf("")),
//    )
//
//    val notificationsToUser: Map<Int, List<Notis>> = notisList.associate { it.employeeId to notisList.filter { not -> not.employeeId == it.employeeId } }
//
//    notificationsToUser.forEach{ println("${it.key} ->\n ${it.value.map { v -> "${v.employeeId}:${v.title} " }}\n\n") }


//    val listMessages = listOf(
//        "Вы были добавлены исполнителем в задачу \"Задача 2\" id:5",
//        "Изменен статус задачи Задача 2: В работе → Выполненная"
//    )
//
//    println(listMessages.joinToString("\n"))

//    println("\n\n\n\n")
//
//    val listRoles = listOf(
//        "исполнителем",
//        "аудитором",
//        "наблюдателем",
//        "участником"
//    )
//
//    println(concatenateListString(listRoles))
//    println(concatenateListStringLast(listRoles))

//    println("\n\n\n\n")
//
//    val listCases: List<Notis> = arrayListOf(
//        Notis(9,"", listOf("")),
//        Notis(2,"", listOf(""))
//    )
//
//    val resCase = listCases.joinToString("") { it.value.joinToString("") }
//    println(resCase)
//    println(resCase.isEmpty())
//    println(resCase.isBlank())


    val notisList = listOf(
        NotisChild(1, "Notise1 by user 1", listOf("")),
        NotisChild(2, "Notise1 by user 2", listOf(""), 3),
        NotisChild(1, "Notise2 by user 1", listOf(""), 3),
        NotisChild(3, "Notise1 by user 3", listOf(""), 1),
        NotisChild(2, "Notise2 by user 2", listOf(""), 1),
        NotisChild(3, "Notise2 by user 3", listOf(""), 1),
        NotisChild(1, "Notise3 by user 1", listOf("")),
        NotisChild(3, "Notise3 by user 3", listOf("")),
    )

    val notificationByGroups = notisList.groupBy { it.target }

    notificationByGroups.forEach { (currentGroup, notificationsByGroup) ->
        println("$currentGroup -> ${notificationsByGroup.joinToString(" ") { "${it.employeeId}-${it.title}" }}")
    }

}

open class Notis(
    val employeeId: Int,
    val title: String,
    val value: List<String>
)

class NotisChild(
    employeeId: Int,
    title: String,
    value: List<String>,
    val target: Int? = null
) : Notis(employeeId, title, value)

private fun concatenateListString(list: List<String>): String {
    return if (list.size > 1) list.subList(0, list.size - 1).joinToString(", ") + " и " + list.last()
    else list.first()
}

private fun concatenateListStringLast(list: List<String>): String {
    return if (list.size > 1) list.subList(0, list.lastIndex).joinToString(", ") + " и " + list.last()
    else list.first()
}