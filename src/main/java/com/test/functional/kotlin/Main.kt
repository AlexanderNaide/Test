package com.test.functional.kotlin

import com.test.functional.kotlin.enums.PredicateCall

fun main() {
    val callGenerateProcessor = CallGenerateProcessor()
    Thread {
        for (i in 0 until 10) {
            val incomingCall = callGenerateProcessor.getCall(i)
            val predicateCall = PredicateCall.values()[(Math.random() * 4).toInt()]
            predicateCall.predicate.process(incomingCall)
            Thread.sleep(1000)
        }
    }.start()

//    val incomingCall = callGenerateProcessor.getCall(8)
//    val predicateCall = PredicateCall.CREATE_CONTACT
//    predicateCall.predicate.process(incomingCall)
}