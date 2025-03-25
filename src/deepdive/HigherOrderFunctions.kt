package deepdive

/**
 * Kotlin functions are first-class, which means they can be stored in variables and data structures,
 * and can be passed as arguments to and returned from other higher-order functions.
 *
 * A higher-order function is a function that takes functions as parameters, or returns a function.
 *
 * [Collection.fold] is a good example of a higher-order function
 */
fun showFold() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    println(
        numbers.fold(
        initial = "Even numbers in the list: ",
        operation = { accumulator, i -> if (i.isEven()) accumulator + "$i " else accumulator }
    ))
}

fun Int.isEven() = this % 2 == 0

fun main() {
    showFold()
}