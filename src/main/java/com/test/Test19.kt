package com.test

import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.nio.file.Paths
import kotlin.io.path.Path
import kotlin.io.path.extension
import kotlin.io.path.fileSize
import kotlin.io.path.name


fun main() {

    val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
    val placeholder = Path("$projectDirAbsolutePath/src/main/resources/templates/img/placeholder.png")

    println(placeholder.fileName)
    println(placeholder.name)
    println(placeholder.fileSize().toString())
    println(placeholder.extension)

    val scanner = PathMatchingResourcePatternResolver()
    val resource = scanner.getResource("/templates/img/placeholder.png")

    println(resource.filename)
    println("image/${resource.file.extension}")
    println(resource.file.length().toString())

    val placeholderhtml = Path("$projectDirAbsolutePath/src/main/resources/templates/html/placeholder.png")
    val output = Path("$projectDirAbsolutePath/src/main/resources/templates/img/nature-output.png")

}

