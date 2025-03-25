package deepdive

import kotlin.math.abs

/**
 * Kotlin provides the possibility to overload operators.
 *
 * Although there are a lot of operators which can be overloaded,
 * most commonly it's used for "+" and "-" operators.
 */
data class Pupil(
    val name: String,
    val height: Int,
    val pocketMoney: Int
) {
    /**
     * For demonstration purposes.
     * @return a string stating how much pocket money pupils have in total
     */
    operator fun plus(other: Pupil): String =
        "${this.name} and ${other.name} have a total of ${this.pocketMoney + other.pocketMoney} pocket money"

    /**
     * For demonstration purposes.
     * @return a string stating if the first pupil is higher / shorter and by how many cm
     */
    operator fun minus(other: Pupil): String {
        val heightDifference = this.height - other.height

        return if (heightDifference < 0)
            "${this.name} is shorter than ${other.name} by ${abs(heightDifference)} centimeters"
        else
            "${this.name} is higher than ${other.name} by $heightDifference centimeters"
    }
}

fun main() {
    val jack = Pupil(name = "Jack", height = 120, pocketMoney = 31)
    val bob = Pupil(name = "Bob", height = 117, pocketMoney = 7)

    println(jack + bob)
    println(jack - bob)

    // == operator in Kotlin is overridden to call a?.equals(b) ?: (b === null)
    println("${jack.name} ${if (jack == bob) "is" else "is not"} equal to ${bob.name}")

    val pupils = listOf(jack, bob)
    val josh = jack.copy(name = "Josh")
    val secondBob = Pupil(name = "Bob", height = 117, pocketMoney = 7)

    // Kotlin allows easy check if collection contains a value with "in" keyword
    // "if (josh in pupils)" can be treated as "if (pupils.contain(josh))"
    println("${josh.name} ${if (josh in pupils) "is" else "is not"} a pupil")
    println("${secondBob.name} ${if (secondBob in pupils) "is" else "is not"} a pupil")
}