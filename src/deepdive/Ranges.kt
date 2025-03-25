package deepdive

fun main() {
    val x = 7

    // Range checks can be written in a very concise way in Kotlin
    if (x in 1..10) {
        println("$x is within the range of 1 to 10")
    }

    val numbers = listOf(1, 2, 3)
    val i = -3

    // imagine we do some non-trivial loops, and now we want to check if the index is within the list:
    if (i in numbers.indices) {
        println("Index is still within the list")
    } else {
        println("Index is outside of the list")
    }

    // Reverse range and step are also available:
    for (number in 9 downTo 0 step 3) {
        println("Descending")
        println(number)
    }
}