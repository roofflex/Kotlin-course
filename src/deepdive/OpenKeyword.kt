package deepdive

/**
 * Kotlin classes are final by default.
 * To allow inheritance, mark the class with *open* keyword
 */
open class Rectangle(
    private val length: Int,
    private val width: Int
) {
    /**
     * The same with functions and properties: unless they're *open*, they're final and non-overridable.
     */
    open fun perimeter(): Int = (length + width) * 2

    open fun area(): Int = length * width
}

class Square(private val side: Int) : Rectangle(length = side, width = side) {
    override fun perimeter(): Int = side * 4

    override fun area(): Int = side.squared()

    private fun Int.squared(): Int = this * this
}
