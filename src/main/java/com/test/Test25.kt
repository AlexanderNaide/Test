package com.test

fun main() {
    val prefix = "GF_"

    val input = "GF_145146_3"

    val cursor = input.substringAfter(prefix)

    println(cursor)

    val offset = cursor.substringBefore("_").toInt()
    val res = offset + 4

    println(offset)
    println(res)
}