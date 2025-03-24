package com.test

fun main(){


    val key = 2147483647

    val ttt: Int = 998765432

    val list = listOf(2, 1248, 464656)
    val listres = list.map(::idAsString)
    val listresStr = listres.joinToString(".")


    println(idAsString(key))
    println(listresStr)

    val ower = listresStr.split(".").map { it.toInt() }

    println(ower)

    val testList = emptyList<Int>()

    println(testList.subList(0, 3))
}

private fun idAsString(id: Int): String {
    return id.toString().padStart(10, '0')
}