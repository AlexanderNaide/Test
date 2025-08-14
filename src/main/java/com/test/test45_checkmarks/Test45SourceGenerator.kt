package com.test.test45_checkmarks

class Test45SourceGenerator {

    fun getCheckmarkJsonTree(): CheckmarkJsonTree {
        return CheckmarkJsonTree(
            id = 15,
            children = listOf(
                CheckmarkJsonTree(
                    id = 18,
                    children = listOf(
                        CheckmarkJsonTree(
                            id = 21
                        )
                    )
                ),
                CheckmarkJsonTree(
                    id = 19
                )
            )
        )
    }

    fun getCheckmarkQueryResult(): List<CheckmarkQueryResult> {
        return listOf(
            CheckmarkQueryResult(id = 15, children = listOf(18, 19, 24)),
            CheckmarkQueryResult(id = 18, children = listOf(21, 22)),
            CheckmarkQueryResult(id = 19, children = listOf(25)),
            CheckmarkQueryResult(id = 21, children = listOf()),
            CheckmarkQueryResult(id = 22, children = listOf()),
            CheckmarkQueryResult(id = 24, children = listOf(28,36,44)),
            CheckmarkQueryResult(id = 25, children = listOf()),
            CheckmarkQueryResult(id = 28, children = listOf()),
            CheckmarkQueryResult(id = 36, children = listOf()),
            CheckmarkQueryResult(id = 44, children = listOf()),
        )
    }

    fun getVisibleTask(): List<TestTask> {
        return listOf(
            TestTask(id = 15, title = "task 15"),
            TestTask(id = 18, title = "task 18", parentId = 15),
            TestTask(id = 19, title = "task 19", parentId = 15),
            TestTask(id = 22, title = "task 22", parentId = 18),
            TestTask(id = 24, title = "task 24", parentId = 15),
            TestTask(id = 25, title = "task 25", parentId = 19),
            TestTask(id = 28, title = "task 28", parentId = 24),
            TestTask(id = 36, title = "task 36", parentId = 24),
        )
    }
}

data class TestTask(
    val id: Int,
    val title: String,
    val parentId: Int? = null,
)