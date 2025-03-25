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
}