package conditionals

fun main(args: Array<String>) {
    workWithIfExpression()
}

fun workWithIfExpression() {
    val number = 5

    // if-else may be used an expression to assign value to a variable
    val isEven = if (number % 2 == 0) "Even" else "Odd"
}