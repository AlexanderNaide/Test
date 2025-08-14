package com.test.test45_checkmarks

// отдаем как response для graphql, т.к. он не понимает рекурсию
class Checkmark (
    val root: Boolean,
    val task: TestTask,
    val children: List<Int>,
)
