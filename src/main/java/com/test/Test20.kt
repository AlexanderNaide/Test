package com.test


fun main() {


    val sourceUrl = "https://76e6-91-240-208-20.ngrok-free.app/#/crm/task/9254?activityId=55"
//    val pattern = Regex("taskId=\\d+")
//    val result = pattern.find(url)
//    val result2 = result!!.groupValues[0]
//    println(result.value)
//    println(url.split(pattern).filter { it.isNotBlank() })
//    println(Regex("\\d+").find(result2)?.value)

//    val taskPattern = Regex("taskId=\\d+")
//    val preResult = taskPattern.find(url)?.value
//    val taskId = "\\d+".toRegex().find(taskPattern.find(url)?.value.toString())?.value?.toInt()

//    val taskPattern = Regex("task/\\d+")
//    val one = taskPattern.find(sourceUrl)?.value.toString()

//    val taskId = "\\d+".toRegex().find(taskPattern.find(sourceUrl)?.value.toString())?.value?.toInt()
    val taskId = Regex("\\d+").find(Regex("task/\\d+").find(sourceUrl)?.value.toString())?.value?.toInt()
    println(taskId)

}
