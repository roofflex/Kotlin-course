fun main(args: Array<String>) {
    println("Hello World!")
    println()

    stringExpressions()
}

fun stringExpressions() {
    val catName = "Cake"
    println("My friend has a cat. Its name is $catName")

    println("The cat has ${2 + 2} paws.")
}