package deepdive

import java.io.File

fun main() {
    val file = File("src/helper/book.json")

    // .use() automatically closes the resource after use
    file.bufferedReader().use { reader ->
        val content = reader.readText()
        println("File content:")
        println(content)
    }
}