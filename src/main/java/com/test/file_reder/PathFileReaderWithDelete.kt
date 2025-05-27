package com.test.file_reder

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.extension

fun main() {
    val url = "text.txt"
    val path = Path.of(url)

    try {
        val lines = Files.readAllLines(path)
        lines.forEach {
            println(it)
        }
    } catch (e: IOException) {
        println(e.message)
    }
    println(path.toString())
//    println(File(path.toString()).delete())
    val csvFileName = path.toAbsolutePath().toString().substringBeforeLast(path.extension) + "csv"
    println(csvFileName)
}