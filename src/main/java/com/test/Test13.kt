package com.test

import java.time.LocalDateTime


fun main() {

    val channel1 = Channel(Type.TYPE_1, true, 2) // sys
    val channel2 = Channel(Type.TYPE_1, false, 2) // us
    val channel3 = Channel(Type.TYPE_1, true, 3)
    val channel4 = Channel(Type.TYPE_2, true, 2) // sys
    val channel5 = Channel(Type.TYPE_2, true, 2) // us
    val channel6 = Channel(Type.TYPE_3, true, 8) // sys

    println(channel1 == channel2)
    println(channel1 == channel3)
    println(channel1 == channel4)


    val list1 = listOf(channel2, channel5)
    val list2 = listOf(channel1, channel4, channel6)

    val keys1 = list1.map { it.type.key }
    val keys2 = list2.map { it.type.key }

    val resultKeys = list2.map { it.type.key } - list1.map { it.type.key }.toSet()

    val userList = list1 + list2.filter { resultKeys.contains(it.type.key) }

    println(userList)

}

data class Channel(
    val type: Type,
    val active: Boolean,
    val count: Int
)

enum class Type(val key: Int){
    TYPE_1(1),
    TYPE_2(2),
    TYPE_3(3),
    TYPE_4(4)
}