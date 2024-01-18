package com.test

fun main(){

    val e = DurationType.fromValue(2)

    println(e)
    println(e.name)

}

enum class DurationType(val value: Int) {
    CALENDAR_DAYS(1),
    WORKER_DAYS(2);

    companion object{
        fun fromValue(v: Int) : DurationType {
            return values().first { f -> f.value == v }
        }
    }
}