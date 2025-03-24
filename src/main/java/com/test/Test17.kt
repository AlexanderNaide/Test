package com.test

import com.ibm.icu.text.PluralRules

fun main() {

    val parentList: MutableList<Any> = mutableListOf()
    parentList.add(3)
    parentList.add(6)
    parentList.add(mutableListOf(12,34))
    parentList.add(mutableListOf(44,47))
    parentList.add(mutableListOf(102, mutableListOf(204,207,212)))
    println(parentList)
    val newList: MutableList<Any> = mutableListOf()
    newList.addAll(test(parentList))

    println( newList )
//    println( parentList.apply {  } )




}

private fun test(list: List<Any>): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    for (i in list){
        if (i is Int) {
            result.add(i)
        } else if (i is MutableList<*>){
            result.addAll(test(i as MutableList<Any>))
        }
    }
    return result
}