package com.test.functional.kotlin

import com.test.functional.kotlin.model.IncomingCall

class CallGenerateProcessor {

    fun getCall(number: Int): IncomingCall {
        return IncomingCall(
            name = "name$number",
            lastname = "lastname$number",
            phone = "8908121683$number"
        )
    }
}