package com.test

import java.time.Instant
import java.time.LocalDateTime
import java.util.*

fun main(){

    val sb : StringBuilder = StringBuilder()

    for(i in 1 .. 5){
        sb.append("hfhfhf").append(", ")
    }
    sb.delete(sb.length - 2, sb.length)

    println(sb.toString())


    val date = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(0),
        TimeZone.getDefault().toZoneId()
    )

    val check = LocalDateTime.of(1970, 1,1, 3,0, 0)

    println(date == check)
}