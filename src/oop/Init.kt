package oop

fun main() {
    val cucumber = Plant("Green")
    val tomato = Plant("Red")
}

class Plant(private val color: String) {

    // init block is executed right after an object of a class is created,
    // so this is like a "post-construct" function in some sense
    init {
        println("Plant color $color set")
    }
}