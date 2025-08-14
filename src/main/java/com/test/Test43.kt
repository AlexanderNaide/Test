package com.test

fun main() {

    for (i in 1..3) {
        val str = when (i) {
                1 -> ""
                2 -> "ambassador  "
                else -> null
        }

        val attr = str?.trim() ?: ""

        println("\"$attr\"")
    }
}