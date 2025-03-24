package com.test.functional.hard.services

import com.test.functional.hard.enums.PredicateCall
import com.test.functional.hard.model.IncomingCall

class IncomingCallService {
    var stringUtil: StringUtil = StringUtil()

    fun processCall(cal: IncomingCall, predicateCall: PredicateCall){
        predicateCall.predicate.process(cal)
    }
}