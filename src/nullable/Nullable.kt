package nullable

fun main(args: Array<String>) {
    workWithNullableAndNonnullVariables()
}

fun workWithNullableAndNonnullVariables() {
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