package com.test.test45_checkmarks

class CheckmarkService {



    /**
     * Разворачивает дерево CheckmarkJsonTree до одноуровнего массива
     */
    fun expandTree(checkmarkJsonTree: CheckmarkJsonTree): List<CheckmarkJsonTree> {
        val childs = if (!checkmarkJsonTree.children.isNullOrEmpty()) {
            checkmarkJsonTree.children!!.map { expandTree(it) }.flatten()
        } else emptyList()
        return listOf(checkmarkJsonTree) + childs
    }

    fun buildCheckmarkTree(
        orderCheckmarks: List<CheckmarkJsonTree>,
        allCheckmarks: List<CheckmarkQueryResult>,
        visibleTasks: List<TestTask>
    ): List<Checkmark> {
        val visibleTasksMap = visibleTasks.associateBy { it.id }
        val checkmarksMap = allCheckmarks.associateBy { it.id }.filter { visibleTasksMap.keys.contains(it.key) }.toMutableMap()
        val resultList = mutableListOf<Checkmark>()
        orderCheckmarks.forEach { sampleCheckmark ->
            val visibleTask = visibleTasksMap[sampleCheckmark.id] ?: return@forEach
            val checkmark = checkmarksMap[sampleCheckmark.id] ?: return@forEach
            val sampleChildren = sampleCheckmark.children?.mapNotNull { it.id } ?: emptyList()
            val actualChildren = (sampleChildren.toSet().plus(checkmark.children ?: emptyList())).filter { visibleTasksMap.keys.contains(it) }
            resultList.add(
                Checkmark(
                    root = false,
                    task = visibleTask,
                    children = actualChildren
                )
            )
            checkmarksMap.remove(sampleCheckmark.id)
        }

        if (checkmarksMap.isNotEmpty()) {
            resultList.addAll(
                checkmarksMap.values.mapNotNull { checkmark ->
                    val task = visibleTasksMap[checkmark.id]
                    if (task != null) {
                        Checkmark(
                            root = false,
                            task = task,
                            children = checkmark.children?.filter { visibleTasksMap.keys.contains(it) } ?: emptyList()
                        )
                    } else null
                }
            )
        }
        return resultList
    }
}