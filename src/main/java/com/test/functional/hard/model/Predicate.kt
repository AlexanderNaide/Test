package com.test.functional.hard.model

fun interface Predicate {
    fun process(call: IncomingCall)
}