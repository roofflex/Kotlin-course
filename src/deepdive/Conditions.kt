package deepdive

import helper.Fruit
import kotlin.random.Random

fun main() {
    val fruits = listOf(
        Fruit.BANANA,
        Fruit.APPLE,
        Fruit.ORANGE
    )

    when (val randomFruit = fruits.shuffled().first()) {
        Fruit.APPLE -> println("Mmmm, apple juice is coming...")
        Fruit.ORANGE -> println("Refreshing!")
        else -> println("I don't know what to do with $randomFruit")
    }

    // try-catch may be used as an expression
    val number: Int = try {
        val result = numberOrString()
        result as Int
    } catch (e: ClassCastException) {
        -1
    }
    println(number)
}

private fun numberOrString(): Any =
    if (Random.nextInt().isEven())
        3
    else
        "Hello"