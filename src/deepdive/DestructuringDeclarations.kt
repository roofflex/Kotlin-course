package deepdive

import helper.Fruit


fun main() {
    val fruitToItsCount = mapOf(
        Fruit.APPLE to 3,
        Fruit.MANGO to 1,
        Fruit.ORANGE to 10
    )

    // here we can read an entry from map and destructure it to key and value
    for ((fruit, count) in fruitToItsCount) {
        if (count > 5) {
            println("We have more than 5 of $fruit. Time to make a juice")
        }
    }

    val kids = listOf(
        Kid(name = "Ivan", age = 5),
        Kid(name = "Zhenya", age = 6),
        Kid(name = "Borya", age = 6)
    )

    for (kid in kids) {
        // destructuring declarations are supported for the data classes
        // this is possible because of the component functions
        val (name, age) = kid

        if (age > 6) {
            println("$name is older than 6 years")
        }
    }
}

private data class Kid(
    val name: String,
    val age: Int
)