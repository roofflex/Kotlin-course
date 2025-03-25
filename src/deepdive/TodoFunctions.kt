package deepdive

class Box(
    private val length: Int,
    private val width: Int,
    private val height: Int
) {
    fun basePerimeter(): Int = (length + width) * 2

    fun baseArea(): Int = length * width

    /**
     * Kotlin's [TODO] function allows to defer the implementation, yet the code will compile
     */
    fun volume(): Int = TODO()
}

fun main() {
    val box = Box(
        length = 7,
        width = 5,
        height = 3
    )

    // this will work
    println("Perimeter of the box's base is ${box.basePerimeter()}")
    // this will work
    println("Are of the box's base is ${box.baseArea()}")

    // this will fail, as TODO() function invocation always throws NotImplementedError
    println("Volume of teh box is ${box.volume()}")
}