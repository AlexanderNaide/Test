package com.test

class Test24 {
    fun parseMicroCardAsTree(inputList: List<MicroCardTreeItem>): List<MicroCardData> {
        val map = inputList.associateBy { it.id }
        for (row in map) {
            val parent = map[row.value.parentId]
            if (parent != null) {
                parent.hasChildren = true
            }
        }
        return map.values.map { it as MicroCardData }
    }
    fun parseMicroCardAsTreeWithStream(inputList: List<MicroCardTreeItem>): List<MicroCardData> {
        return inputList.onEach { card ->
            inputList.filter { it.id == card.parentId }.map { it.hasChildren = true }
        }.map { it as MicroCardData }
    }
}

fun main() {
    val resurs: MutableList<TaskMicroCardFieldData> = mutableListOf()
    val test24 = Test24()

    for (i in 1 .. 10000){
        resurs.add(TaskMicroCardFieldData(
            taskId = i,
            parentId = (Math.random() * 1).toInt(),
            depth = (Math.random() * 1).toInt(),
        ))
    }

    val methods = listOf(
        test24::parseMicroCardAsTree,
        test24::parseMicroCardAsTreeWithStream,
    )

    methods.forEach { method ->
        method(resurs)
        method(resurs)
        method(resurs)

        val start = System.currentTimeMillis()
        method(resurs)
        val finish = System.currentTimeMillis()

        println(">>>>>>>>>>>>>>>>>>>>>>>>> Method: ${method.name}, total: ${resurs.size} elements, duration is ${finish - start}ms")
    }

}

interface MicroCardTreeItem {
    var id: Int
    var parentId: Int?
    var depth: Int
    var hasChildren: Boolean
    var subTaskCount: Int
    var closed: Boolean
}

interface MicroCardData

class TaskMicroCardFieldData(
    var taskId: Int,
    val borderColor: String? = null,
    override var parentId: Int? = null,
    override var depth: Int = 0
) : MicroCardData, MicroCardTreeItem {

    override var id: Int
        get() = taskId
        set(value) {this.taskId = value}

    override var hasChildren: Boolean = false
    override var subTaskCount: Int = 0
    override var closed: Boolean = false
}