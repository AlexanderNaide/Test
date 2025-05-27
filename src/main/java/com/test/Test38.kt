package com.test

import kotlin.compareTo

fun main() {

    val scheduleSequence = listOf(2,3,5,8,12,13,14,17,19,21,24,28)
    val currentDate = 17

    val currentSchedule1 = scheduleSequence.reversed().first { it <= currentDate }
    val currentSchedule2 = scheduleSequence.first { it <= currentDate }
    val currentSchedule3 = scheduleSequence.last { it <= currentDate }
    val currentSchedule4 = scheduleSequence.last { it > currentDate }

    println(currentSchedule1)
    println(currentSchedule2)
    println(currentSchedule3)
    println(currentSchedule4)

}