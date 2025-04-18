package deepdive

import kotlin.Double


open class ElectronicDevice(val powerSource: String)

open class PortableDevice(
    powerSource: String,
    val weight: Double
) : ElectronicDevice(powerSource = powerSource)

open class Computer(
    powerSource: String,
    weight: Double,
    val processor: String
) : PortableDevice(powerSource = powerSource, weight = weight)

open class Laptop(
    powerSource: String,
    weight: Double,
    processor: String,
    val batteryLife: Int
) : Computer(
    powerSource = powerSource,
    weight = weight,
    processor = processor
)

class GamingLaptop(
    powerSource: String,
    weight: Double,
    processor: String,
    batteryLife: Int,
    val gpuModel: String
) : Laptop(
    powerSource = powerSource,
    weight = weight,
    processor = processor,
    batteryLife = batteryLife
)

/**
 * Consumer: **in**,
 * Producer: **out**
 *
 * Let's suppose that we have a hierarchy of classes:
 * E extends D extends C extends B extends A
 * or
 * *A <- B <- C <- D <- E*.
 * So A is the root, G is the final child.
 *
 * Consumer takes the generic argument ***in***, so ***in*** keyword is used.
 * Instead of C, we may also pass one of [D, E] as a parameter,
 * as D, E **shrink in** to C.
 * The Compiler will show an error if the generic is tried to be returned.
 *
 * Consumer **in** C may consume parameter X, if X **shrinks in** to C. (X extends C).
 *
 * Producer returns the generic argument ***out***, so ***out*** keyword is used.
 * Instead of C, we may also assign the return value to a variable ot type [A, B],
 * as A, B **expand out** to C.
 * The Compiler will show an error if the generic is tried to be taken as a parameter.
 *
 * Producer **out** C may produce X, if X **expands out** to C (C extends X)
 *
 * This is called **Declaration-site variance**
 * See [Kotlin documentation](https://kotlinlang.org/docs/generics.html#declaration-site-variance).*
 */
fun interface ComputerConsumer<in Computer> {
    fun sell(computer: Computer)

    // compiler error:
    // Type parameter 'Computer' is declared as 'in' but occurs in 'out' position
//    fun giveBack(): Computer
}

fun interface ComputerProducer<out Computer> {
    fun nextComputer(): Computer

    // compiler error:
    // Type parameter 'Computer' is declared as 'out' but occurs in 'in' position
//    fun takeBack(computer: Computer)
}


fun main() {
    val computerProducer: ComputerProducer<Computer> = ComputerProducer {
        Computer(
            powerSource = "battery",
            weight = 1.2,
            processor = "AMD FX1200"
        )
    }

    // fine, as producer is <out Computer> and
    // ElectronicDevice expands out to Computer
    val electronicDevice: ElectronicDevice = computerProducer.nextComputer()

    // compile error
//    val laptop: Laptop = laptopProducer.nextLaptop()

    val computerConsumer: ComputerConsumer<Computer> = ComputerConsumer {
        println("Sold computer with processor ${it.processor} for 100$")
    }

    // fine, as consumer is <in Computer> and
    // Laptop shrinks in to Computer
    computerConsumer.sell(
        Laptop(
            powerSource = "battery",
            weight = 1.2,
            processor = "AMD FX1200",
            batteryLife = 80
        )
    )
    // compile error
//     computerSeller.sell(
//        PortableDevice(
//            powerSource = "battery",
//            weight = 0.4
//        )
//    )
}

/**
 * Type projections:
 *
 * We can prohibit the *copy* function from writing to **from** variable
 * by using the ***out*** keyword, which will tell the compiler that
 * *from* is strictly ***a producer***.
 *
 * This is called ***Use-site variance***
 */
fun copy(from: MutableList<out Computer>, to: MutableList<Computer>) {
    to.addAll(from)

    // compiler error
    // from is declared out, but is used as a consumer
//    from[0] = Computer(
//        powerSource = "battery",
//        weight = 1.2,
//        processor = "AMD FX1200"
//    )
}

/**
 * We can prohibit the *fill* from producing variables by
 * using the ***in*** keyword, which will tell the compiler that
 * *fill* is strictly ***a consumer***.
 *
 * We may save variable of any type that **shrinks in** to Computer to the
 * *destination* list, as well as *destination* can have any super type of Computer.
 */
fun fill(destination: MutableList<in Computer>, value: Computer) {
    destination.add(value)
}

/**
 * An **upper bound constraint** can be specified for generic type.
 *
 * In this function, [T] must extend the [PortableDevice]
 */
fun <T : PortableDevice> sort(list: List<T>) {
    list.sortedBy { it.weight }
}