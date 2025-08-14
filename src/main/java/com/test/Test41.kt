package com.test

import kotlin.collections.set

fun main() {

    var assigneesEmployeeIdNew: List<Int>? = listOf(5, 3)
    var assigneesEmployeeIdOld: Array<Int> = arrayOf(1, 5)
    println(assigneesEmployeeIdNew != null && (assigneesEmployeeIdNew.subtract(assigneesEmployeeIdOld.toList())).isNotEmpty())

    val list1 = listOf(1, 5)
    val list2 = listOf(5, 3)
    println(list1.subtract(list2))
    println(list2.subtract(list1))



    val changes = HashMap<ChangedTaskField, ChangeData>()

    val taskFieldDifference: MutableList<ChangedTaskField> = mutableListOf(
        ChangedTaskField.AUDITORS_EMPLOYEE,
//        ChangedTaskField.AUDITORS_GROUP,
//        ChangedTaskField.AUDITORS_CONTACT,
        ChangedTaskField.ASSIGNEES_EMPLOYEE,
        ChangedTaskField.PARTICIPANTS_GROUP
    )

    println("1 - " + taskFieldDifference.intersects(ChangedTaskField.AUDITORS_FIELDS))
    println("2 - " + ChangedTaskField.AUDITORS_FIELDS.all { field -> isFieldEmpty(field) })

    println("3 - " + (taskFieldDifference.intersects(ChangedTaskField.AUDITORS_FIELDS) && ChangedTaskField.AUDITORS_FIELDS.all { field -> isFieldEmpty(field) }))

    println("3 - " + ChangedTaskField.AUDITORS_FIELDS.any { field -> taskFieldDifference.contains(field) && isFieldEmpty(field) })



    if (taskFieldDifference.intersects(ChangedTaskField.AUDITORS_FIELDS) && ChangedTaskField.AUDITORS_FIELDS.all { field -> isFieldEmpty(field) }) {
        changes[ChangedTaskField.AUDITORS] = ChangeData(newData = "Из задачи исключены все ${TaskRoleInfo.AUDITOR.plural}")
        taskFieldDifference.removeAll(ChangedTaskField.AUDITORS_FIELDS)
    }


}

enum class ChangedTaskField {
    AUDITORS_EMPLOYEE,
    AUDITORS_GROUP,
    AUDITORS_CONTACT,

    ASSIGNEES_EMPLOYEE,
    ASSIGNEES_GROUP,
    ASSIGNEES_CONTACT,

    PARTICIPANTS_EMPLOYEE,
    PARTICIPANTS_GROUP,
    PARTICIPANTS_CONTACT,

    AUDITORS,
    ;

    companion object {
        val AUDITORS_FIELDS = setOf(
            AUDITORS_EMPLOYEE,
            AUDITORS_GROUP,
            AUDITORS_CONTACT
        )
    }
}

infix fun <T: Any> Collection<T>.intersects(other: Collection<T>) = any(other::contains)

private fun isFieldEmpty(field: ChangedTaskField): Boolean = when (field) {
    ChangedTaskField.ASSIGNEES_EMPLOYEE -> false
    ChangedTaskField.ASSIGNEES_GROUP -> false
    ChangedTaskField.ASSIGNEES_CONTACT -> false
    ChangedTaskField.PARTICIPANTS_EMPLOYEE -> false
    ChangedTaskField.PARTICIPANTS_GROUP -> false
    ChangedTaskField.PARTICIPANTS_CONTACT -> false
    ChangedTaskField.AUDITORS_EMPLOYEE -> true
    ChangedTaskField.AUDITORS_GROUP -> true
    ChangedTaskField.AUDITORS_CONTACT -> false
    else -> true
}

class ChangeData(
    val newData: String,
    val oldData: String? = null
)

enum class TaskRoleInfo(
    val plural: String,
    val dative: String,
    val ablative: String,
    val pluralAblative: String,
    val genitive: String,
    val pluralGenitive: String
) {
    ASSIGNEE(
        "исполнители",
        "исполнителям",
        "исполнителем",
        "исполнителями",
        "исполнителя",
        "исполнителей"
    ),
    PARTICIPANT(
        "участники",
        "участникам",
        "участником",
        "участниками",
        "участника",
        "участников"
    ),
    AUDITOR(
        "аудиторы",
        "аудиторам",
        "аудитором",
        "аудиторами",
        "аудитора",
        "аудиторов"
    ),
    EMPTY("", "", "", "", "", "");

    companion object {

        /**
         * Получение информации о роли в задаче по измененному полю
         */
        fun getRoleInfoByChangedField(field: ChangedTaskField): TaskRoleInfo = when (field) {
            ChangedTaskField.ASSIGNEES_EMPLOYEE,
            ChangedTaskField.ASSIGNEES_GROUP,
            ChangedTaskField.ASSIGNEES_CONTACT -> ASSIGNEE

            ChangedTaskField.PARTICIPANTS_EMPLOYEE,
            ChangedTaskField.PARTICIPANTS_GROUP,
            ChangedTaskField.PARTICIPANTS_CONTACT -> PARTICIPANT

            ChangedTaskField.AUDITORS_EMPLOYEE,
            ChangedTaskField.AUDITORS_GROUP,
            ChangedTaskField.AUDITORS_CONTACT -> AUDITOR

            else -> EMPTY
        }
    }
}
