package com.test


fun main() {

    val node = Node(
        id = 1,
        child = listOf(
            Node(
                id = 2,
                child = listOf(
                    Node(
                        id = 3,
                        child = listOf()
                    ),
                    Node(
                        id = 4,
                        child = listOf()
                    )
                )
            ),
            Node(
                id = 5,
                child = listOf()
            ),
            Node(
                id = 4,
                child = listOf()
            )
        )
    )

    val parentNodeId = 2
    val removableIds = listOf(4)

    removeCheckmarkFromTree(node, parentNodeId, removableIds)

    println()

}

class Node (
    val id: Int?,
    var child: List<Node>?
)

fun removeCheckmarkFromTree(node: Node, parentNodeId: Int, removableIds: List<Int>) {
    node.child = node.child
//        ?.filter { node.id != parentNodeId && !removableIds.contains(it.id) }
        ?.filter { node.id == parentNodeId || !removableIds.contains(it.id) }
//        ?.filter { true }
        ?.onEach { removeCheckmarkFromTree(it, parentNodeId, removableIds) }
}