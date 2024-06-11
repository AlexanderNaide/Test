package com.test

import java.time.LocalDateTime


fun main() {
    //до конца завтрашнего дня
    val endOfThisDay = LocalDateTime.now().toLocalDate().atStartOfDay().plusDays(1).minusSeconds(1)
    println("до конца завтрашнего дня")
    println(endOfThisDay)
    val endOfNextDayT = endOfThisDay.plusDays(1)
    println(endOfNextDayT)

    //ближайшие 7 дней
    val endOfNextDay = LocalDateTime.now().toLocalDate().atStartOfDay().plusDays(2).minusSeconds(1)
    println("до конца завтрашнего дня")
    println(endOfNextDay)
    val afterWeekDay = LocalDateTime.now().toLocalDate().atStartOfDay().plusDays(7).minusSeconds(1)
    println("ближайшие 7 дней")
    println(afterWeekDay)


    val endDateTime = LocalDateTime.of(2024, 6, 18, 12, 0, 0,0)
    val rec = endDateTime != null && endDateTime!!.isAfter(endOfNextDay) && (endDateTime!!.isBefore(afterWeekDay) || endDateTime!!.isEqual(afterWeekDay))

    println(rec)

}