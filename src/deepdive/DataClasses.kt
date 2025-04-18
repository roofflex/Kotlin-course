package deepdive

fun main() {
    val myCat = Cat(color = "black")
    val friendsCat = myCat.copy()
    friendsCat.age = 3

    println("My cat: $myCat")
    println("My friend's cat: $friendsCat")
    println("My cat's age is ${myCat.age}")
    println("My friend's cat's age is ${friendsCat.age}")
    println(myCat == friendsCat)
}

data class Cat(
    val color: String
) {
    /**
     * By default, a property defined outside the data class' primary constructor
     * is not used in .equals(), .hashcode(), .copy() etc.
     */
    var age: Int = 1
}