const val GOOGLE_URL = "google.com"

fun main(args: Array<String>) {
//    helloWorld()
//    stringExpressions()
    readNumberFromCommandLine()
}

fun helloWorld() {
    println("Hello World!")
    println()
}

fun stringExpressions() {
    val catName = "Cake"
    println("My friend has a cat. Its name is $catName")

    println("The cat has ${2 + 2} paws.")
}

fun readNumberFromCommandLine() {
    println("Input a number")

    val input = readLine()?:""
    println("The number is ${input.toInt()}")
}