package com.test.functional.kotlin.model

import com.test.functional.kotlin.services.StringUtil

abstract class CallProcessor: Predicate {
    val util = StringUtil()
}