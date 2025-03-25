package oop

fun main() {
    val mac = Laptop("Mac OS")
    val lenovo = Laptop("Windows 10")
}

class Laptop(private val operatingSystem: String) {

    // init block is executed right after an object of a class is created,
    // so this is like a "post-construct" function in some sense
    init {
        println("Operating system $operatingSystem set")
    }
}