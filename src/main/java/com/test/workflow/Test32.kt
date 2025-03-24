package com.test.workflow

import java.time.*
import java.time.format.DateTimeFormatter

fun main() {
    val today = LocalDate.now()
    val count = 13
    val dayOfWeek = today.dayOfWeek.value
    val result = ((dayOfWeek + count - 1) / 5) * 2 + count
    val resultDay = today.plusDays(result.toLong())

//    println(dayOfWeek)
//    println(result)
//    println(resultDay)


//    val startTime = LocalTime.of(0, 20)
    val startTime: LocalTime? = null
//    val delayedTillTime = LocalTime.of(0, 30)
    val delayedTillTime: LocalTime? = null
    val resultTime = LocalTime.ofNanoOfDay((startTime?.toNanoOfDay() ?: 0) + (delayedTillTime?.toNanoOfDay() ?: 0))
//    println(resultTime)

    val delayedDate: LocalDate? = null
    val delayedTime: LocalTime? = LocalTime.of(6, 40)
    val delayedTillDate: LocalDateTime? = if (delayedDate == null && delayedTime == null) null else
        getLocalDateTime(getEpochSecond(delayedDate) + getEpochSecond(delayedTime))
//    println(delayedTillDate)


    val entryDate = getEntryDate(LocalDate.of(2025, 1, 1))
//    println(entryDate)
//    println(getDateFromEntry(entryDate))

    println(getLocalDateTime(1740122400))
    println(getLocalDateTime(1740986400))

    val date = LocalDateTime.of(1975, 1, 1, 23,1)
    val dataFormat = "yyyy-MM-dd"
    val dateFormatter1 = DateTimeFormatter.ofPattern(dataFormat)
    val dateFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE
    val res1 = dateFormatter1.format(date.toLocalDate())
    val res2 = dateFormatter2.format(date.toLocalDate())
    println(res1)
    println(res2)
    println(res1 == res2)

    val timeFormat = "HH:mm:ss"
    val timeFormatter1 = DateTimeFormatter.ofPattern(timeFormat)
    val timeFormatter2 = DateTimeFormatter.ISO_LOCAL_TIME
    val res3 = timeFormatter1.format(date.toLocalTime())
    val res4 = timeFormatter2.format(date.toLocalTime())
    println(res3)
    println(res4)
    println(res3 == res4)

}

fun getEpochSecond(dateTime: LocalDateTime): Int {
    return dateTime.atZone(ZoneId.of("Europe/Moscow")).toEpochSecond().toInt()
}

fun getEpochSecond(date: LocalDate?): Int {
    return date?.atStartOfDay()?.atZone(ZoneId.of("Europe/Moscow"))?.toEpochSecond()?.toInt() ?: 0
}

fun getEpochSecond(time: LocalTime?): Int {
    return time?.toSecondOfDay() ?: 0
}


fun getLocalDateTime(epochSecond: Int): LocalDateTime {
    return Instant.ofEpochSecond(epochSecond.toLong())
        .atZone(ZoneId.of("Europe/Moscow"))
        .toLocalDateTime()
}

fun getEntryDate(date: LocalDate?): Int {
    if (date == null) return 0

    val pattern = "yyyyMMdd"
    val outputFormatter = DateTimeFormatter.ofPattern(pattern)
    return outputFormatter.format(date).toInt()
}

fun getDateFromEntry(entry: Int): LocalDate? {
    val pattern = "yyyyMMdd"
    if (entry == 0) return null
    val outputFormatter = DateTimeFormatter.ofPattern(pattern)
    return LocalDate.parse(entry.toString(), outputFormatter)
}

