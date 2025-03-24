package com.test

fun main() {
    val list1 = listOf(1,2,3,4,5)
    val res1 = list1.filter { it < 4 }.onEach { it * 2 }.toList()

//    val res2 = list1.filter { it > 6 }.onEach { it * 2 }.let { if (it.isNotEmpty()) "dd ${it.toList()}" else null }




    println(res1)
//    println(res2)
}

private fun prList(list: List<Int>) {
    println("print List: $list")
}
