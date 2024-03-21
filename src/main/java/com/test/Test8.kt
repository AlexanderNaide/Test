package com.test

fun main(){


    val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12)
    val BATCH_SIZE_MC_REPLACE = 7
    var iter = 0
    do {
        val toIndex = (iter + 1) * BATCH_SIZE_MC_REPLACE
        val batch = list.subList(iter * BATCH_SIZE_MC_REPLACE, if (toIndex < list.size) toIndex else list.size)
        println(batch)
        iter++
    } while (list.size > BATCH_SIZE_MC_REPLACE * iter)


}
