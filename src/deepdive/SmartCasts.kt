package deepdive

fun showCasts() {
    val shapes = listOf(
        Shape.Square(length = 2),
        Shape.Square(length = 3),
        Shape.Circle(radius = 5)
    )

    shapes.forEach {
        // Smart cast: current element is automatically cast to Circle, as its type was checked before
        if (it is Shape.Circle) {
            println("The shape is a circle. Radius = ${it.radius}")
        }
    }

    // "as?" - is a "safe" (nullable) cast operator
    val firstShape = shapes.first() as? Shape.Square
    val lastShape = shapes.last() as? Shape.Square

    println(firstShape)
    println(lastShape)
}

fun main() {
    showCasts()
}

sealed class Shape {
    class Square(val length: Int) : Shape() {
        override fun toString(): String {
            return "Square(length=$length)"
        }
    }

    class Circle(val radius: Int) : Shape() {
        override fun toString(): String {
            return "Circle(radius=$radius)"
        }
    }
}