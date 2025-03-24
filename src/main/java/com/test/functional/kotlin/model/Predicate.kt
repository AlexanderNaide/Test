package com.test.functional.kotlin.model

fun interface Predicate {
    fun process(call: IncomingCall)
}