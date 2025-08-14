package com.test


fun main() {

    val list = listOf(
        Pair(1, "один"),
        Pair(2, "два"),
        Pair(3, "три"),
        Pair(2, "четыре"),
        Pair(3, "пять"),
        Pair(2, "шесть"),
    )

    val map = list.associateBy { it.first }

    println("${list.size}/${map.size}")
    map.forEach { println("${it.key} - ${it.value.second}")}


}