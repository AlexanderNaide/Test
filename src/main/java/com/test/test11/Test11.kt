package com.test.test11

fun main() {

    val scope = Scope.COMMONS

    println(scope)
    println(scope.scope)

    println(Scope.fromValue("commons")::class)
    println(Scope.fromValue("commons"))


}