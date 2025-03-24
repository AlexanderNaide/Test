package com.test.functional.hard

import com.test.functional.hard.enums.PredicateCall
import com.test.functional.hard.services.IncomingCallService

fun main() {
    val callGenerateProcessor = CallGenerateProcessor()
    val incomingCallService = IncomingCallService()

    Thread {
        for (i in 0 until 10) {
            val incomingCall = callGenerateProcessor.getCall(i)
            val predicateCall = PredicateCall.values()[(Math.random() * 4).toInt()]
            incomingCallService.processCall(incomingCall, predicateCall)
            Thread.sleep(1000)
        }
    }.start()

}