package com.test

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.fileSize

private const val uploadFilePath: String = "/tmp/upload/"

fun main() {

    val test = Test30()
//    val path = test.readTextResource("text.txt")

    val cur = Paths.get("/src/main/resources/dir/text.txt").toAbsolutePath().toString()
    val f = Files.size(Path.of(cur))
    println(f)


//    println(test.writePreview())
}

class Test30 {


    fun readTextResource(fileName: String): Path? {
        val resource = this.javaClass.getResource("/dir")
        val url = "$resource/$fileName"
        return if (Files.exists(Path.of(url))){
            Paths.get(url)
        } else {
            Files.createFile(Path.of(url))
        }
    }

//    fun writePreview(): String {
//
//        val outputFilePath: String = Path.of(uploadFilePath)
//            .resolve(Paths.get("jhbfdsjvhbdsfvjsdjb-mndkfjvn2-xklj87.png"))
//            .normalize()
//            .toAbsolutePath().toString()
//
//        val previewFilePath = Path.of(outputFilePath)
//
//        return ""
//    }
}

