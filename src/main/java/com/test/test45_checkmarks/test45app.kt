package com.test.test45_checkmarks

fun main() {

    val checkmarkService = CheckmarkService()
    val sourceGenerator = Test45SourceGenerator()



    val checkmarkJsonTree = sourceGenerator.getCheckmarkJsonTree()
    val queryResult = sourceGenerator.getCheckmarkQueryResult()
    val visibleTasks = sourceGenerator.getVisibleTask()

    val expandCheckmarkJsonTree = checkmarkService.expandTree(checkmarkJsonTree)

    val result = checkmarkService.buildCheckmarkTree(expandCheckmarkJsonTree, queryResult, visibleTasks)

    println()

}