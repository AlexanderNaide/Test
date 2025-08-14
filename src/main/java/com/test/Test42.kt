package com.test

fun main() {
    val list = mutableListOf(1, 2, 3)

    val st = "ambassador"

    when {
        st.length > 0 -> {
            list.remove(1)
            println("keys 1")
        }
        st.length > 1 -> {
            list.remove(2)
            println("keys 2")
        }
        st.length > 2 -> {
            list.remove(3)
            println("keys 3")
        }
    }

    println(list.size)
}