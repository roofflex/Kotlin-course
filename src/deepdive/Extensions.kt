package deepdive

fun main() {
    val jack = Child(name = "Jack", toy = "Bear", heightInCm = 110)
    val amy = Child(name = "Amy", toy = "Giraffe", heightInCm = 117)

    println(jack)
    println(amy)

    // extension functions don't actually modify the class they extend.
    // they just provide a way to call the function with a dot notation on the
    // variables of extended class
    jack.swapToy(with = amy)

    println(jack)
    println(amy)

    val unknown: Child? = null

    jack.askAboutSwap(with = amy)
    // this won't do anything, as the receiver is null
    // (and we don't have any processing for null in our extension function)
    unknown.askAboutSwap(with = jack)

    println(
        "Amy's height in cm is ${amy.heightInCm}. Amy's recommended weight is ${amy.recommendedWeight}"
    )
}

private class Child(
    val name: String,
    var toy: String,
    val heightInCm: Int
) {
    override fun toString(): String {
        return "Child(name='$name', toy='$toy', heightInCm=$heightInCm)"
    }
}

/**
 * To declare an extension function, prefix the function's name with the receiver type.
 * **this** keyword refers to the receiver object.
 *
 * Extension functions, declared as members of other class (e.g., in A Spring Service class),
 * have multiple implicit receivers: *dispatch receiver* (enclosing class) and an
 * *extension receiver* (extended class).
 * (public / internal) Methods / fields of both the receivers are accessible inside.
 *
 * Extension function / properties can also be defined for Companion objects of classes.
 */
private fun Child.swapToy(with: Child) {
    val temp = this.toy
    this.toy = with.toy
    with.toy = temp
}

/**
 * Extension functions can have a nullable receiver.
 * However, don't forget to account for **null** when working with it
 */
private fun Child?.askAboutSwap(with: Child) =
    this?.let {
        println("Hey, ${with.name}, would you like to swap our toys?")
    }

/**
 * Kotlin allows declaring extension properties.
 *
 * **Note**: they don't have a backing field (since extensions do not actually insert members into classes),
 * and therefore initializers are not allowed.
 *
 * Their behavior can only be defined by explicitly providing getters/setters.
 */
private val Child.recommendedWeight: Int
    get() = this.heightInCm - 100
