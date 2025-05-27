package com.test

import java.time.LocalDate

fun main() {
    val year = 2025
//    LocalDate.of(year, 1, 1).datesUntil(LocalDate.of(year, 1, 1)).forEach {
//        println(it)
//    }

    println(LocalDate.of(year, 1, 1).datesUntil(LocalDate.of(year + 1, 1, 1)).map {
        CalendarDay(it)
    }.toList())
}