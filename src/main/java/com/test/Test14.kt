package com.test

fun main() {

    val str1 = "  String1 "
    val str2 = "  String  1 "
    var str3 = "   "

    str3 = str3.trim()

    println(str1.trim())
    println(str2.trim())
    println(str3)
    println(str3.length)
    println(str3.isEmpty())


    val query = """
        replace into task (id, description) values (2, 'test test');
        replace into task (id, description) values (2, 'test test test');
    """.trimIndent()

//    val query = "replace into task (id, description) values (2, 'test test'); replace into task (id, description) values (2, 'test test test'); "
    println(query.split(";"))
    println(query!!.trim().split(";").filter { it.isNotEmpty() })
    println(query.trim().replace("\\;$".toRegex(), "").split(";"))

}