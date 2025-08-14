package com.test.test45_checkmarks

/**
 * Для хранения в json поле
 */
class CheckmarkJsonTree(
    var id: Int? = null,
    var children: List<CheckmarkJsonTree>? = null
)
