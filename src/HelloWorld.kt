const val GOOGLE_URL = "google.com"

fun main(args: Array<String>) {
//    helloWorld()
//    stringExpressions()
//    readNumberFromCommandLine()
//    printTypes()

    printNullableAndNonnullVariables()
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

fun printTypes() {
    val dogs: Byte = 5
    println("value = $dogs, type = ${dogs::class.java}")
    val pi = 3.1415F
    println("value = $pi, type = ${pi::class.java}")
}

fun printNullableAndNonnullVariables() {
    val catName = "Chonkers"
    var dogName: String? = null

    println("Cat's name has ${catName.length} letters")
    //    ?. - null-safe call, will return either:
    //  - null, if the object on which it is called is null
    //  - value otherwise
    //
    //  null-safe calls may be chained
    println("Dog's name has ${dogName?.length} letters")

    var firstInt: Int? = null
    var secondInt: Int = 5

    println(secondInt * 2)
    // null-safe arithmetic operator
    println(firstInt?.times(2))

    // Elvis operator: gets either a value, or a default value if caller object is null
    println("Dog has a name: ${dogName?:"NO NAME"}")

    // !! / !!. - Non-null assertion, should be used only in tests
    println(dogName!!.length)
}
