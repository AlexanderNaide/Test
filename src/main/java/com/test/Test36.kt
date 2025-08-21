package com.test

fun main() {

    val keys = listOf(
        "key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9"
    )

    val res = checkKeys(keys)

    println(keys)
    println(res)

    val controlki = listOf(
        Controlka( "key1"),
        Controlka( "key2"),
        Controlka( "key3"),
        Controlka( "key4"),
    )

    checkOnEach(controlki)

    println("------------")

    controlki.forEach { println(it.key) }

}

fun checkKeys(keys: List<String>): List<String> {
    return keys.map { key ->
        if (key == "key3") {
            "Ta-da"
        } else key
    }
}
fun checkOnEach(controlki: List<Controlka>): List<Controlka> {
    return controlki.onEach { con ->
        if (con.key == "key3") {
            con.key = "Ta-da"
        }
    }
}


class Controlka(
    var key: String
)


