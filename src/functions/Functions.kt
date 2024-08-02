package functions

fun main(args: Array<String>) {
    val num: Byte = 5
    printType(num, "The type of number is")
    // params with default values may be omitted
    printType(6)
    println()

    printNumbers(1, 4, 9)
    println()

    println(
        "Area of a circle with a radius of 4cm is " +
                String.format("%.2f", calculateCircleArea(4)) +
                " cm2."
    )
}

// function parameters can have default values, like message here
fun printType(number: Number, message: String = "Type is") {
    println("$message ${number::class.java}")
}

fun printNumbers(vararg numbers: Number) {
    for (number in numbers) {
        println("Number is $number")
    }
    println()
}

// short functions may be declared in one line with '=' operator
fun calculateCircleArea(radius: Int) = Math.PI * Math.pow(radius.toDouble(), 2.0)