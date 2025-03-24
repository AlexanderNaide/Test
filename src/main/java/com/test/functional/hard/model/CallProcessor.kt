package com.test.functional.hard.model

import com.test.functional.kotlin.services.StringUtil

abstract class CallProcessor: Predicate {
    val util = StringUtil()
}