package com.test

fun main(){


    println("------- Test 1 --------")
    val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12)
    val BATCH_SIZE_MC_REPLACE = 7
    var iter = 0
    do {
        val toIndex = (iter + 1) * BATCH_SIZE_MC_REPLACE
        val batch = list.subList(iter * BATCH_SIZE_MC_REPLACE, if (toIndex < list.size) toIndex else list.size)
        println(batch)
        iter++
    } while (list.size > BATCH_SIZE_MC_REPLACE * iter)

    println("------- Test 2 --------")
    val listString = listOf("gfhf", "", "tada", "", "koker", "task")
    println(listString.filter { it.isNotEmpty() }.joinToString(";"))


    println("------- Test 3 --------")
    val arrayOne = arrayOf(1, 2, 3)
    val arrayTwo = arrayOf(9, 12)
    val arraySum = arrayOne + arrayTwo + 24 // Сложить несколько Array или добавить отдельные элементы
    println(arraySum.joinToString(", "))

    println("------- Test 4 --------")
    val listOld = listOf(7, 9, 12, 24)
    val listNew = listOf(7, 12, 46)
    val listResult = listOld - listNew
    val listResult2 = listNew - listOld
    println(listResult.joinToString(", ")) // нужно получить 9 и 24
    println(listResult2.joinToString(", ")) // нужно получить 46

    val tastList: List<Int> = emptyList()

    tastList.forEach { println(it) }
}
