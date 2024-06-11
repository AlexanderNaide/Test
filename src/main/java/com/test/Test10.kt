package com.test

fun main() {
    val list = listOf(
        Dev("Vasa", 20, listOf(
            Dev("Vasa", 15, listOf()),
            Dev("Masha", 99, listOf())
        )),
        Dev("Dasha", 10, listOf()),
        Dev("Masha", 15, listOf())
    )

    list
        .filter { it.name == "Vasa" }
        .onEach {
            it.child
                .filter { ch -> ch.name == "Vasa" }
                .forEach { ch -> it.age = ch.age }
        }


    list.forEach {
        println("${it.name} ${it.age} ${it.child.firstOrNull()?.age}")
    }
}

data class Dev(
    val name: String,
    var age: Int,
    val child: List<Dev>
)