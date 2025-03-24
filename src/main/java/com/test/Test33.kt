package com.test

fun main() {
    println("false - " + checkIncorrectInputValues(listOf<Boolean>(), null, true, true)) // сброс времени
    println("true - " + checkIncorrectInputValues(null, listOf<Boolean>(), true, true)) // сброс даты
    println("true - " + checkIncorrectInputValues(listOf<Boolean>(true), null, null, null)) // установка времени без даты
    println("false - " + checkIncorrectInputValues(null, listOf<Boolean>(true), null, null)) // установка даты без времени
    println("false - " + checkIncorrectInputValues(null, listOf<Boolean>(), null, true)) // сброс даты при отсутствии времени
    println("false - " + checkIncorrectInputValues(listOf<Boolean>(), listOf<Boolean>(), null, true)) // сброс времени и даты
}

private fun checkIncorrectInputValues(inputTime: List<*>?, inputDate: List<*>?, currentTime: Any?, currentDate: Any?) : Boolean {
    return (!inputTime.isNullOrEmpty() || currentTime != null) && (currentDate == null || inputDate.isNullOrEmpty())
}