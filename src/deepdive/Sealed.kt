package deepdive

/**
 * Sealed classes and interfaces provide controlled inheritance.
 * All direct subclasses of a sealed class are known at compile time.
 * No other subclasses may appear outside the module and package within which the sealed class is defined.
 *
 * Sealed class is **abstract** by default,
 * and its constructor has a default **protected** visibility.
 */
sealed class Animal(val color: String)

class Rhino : Animal(color = "grey")
class Lion : Animal(color = "yellow")
class Monkey : Animal(color = "brown")


fun main() {
   val animals = listOf(
       Rhino(),
       Monkey(),
       Monkey(),
       Rhino(),
       Lion()
   )

    for (animal in animals) {
        // Since all subclasses are known at compile time,
        // when expression is exhaustive without the else branch.
        // It'll also check that all the subclasses are covered
        when (animal) {
            is Rhino -> println("Rhino sound")
            is Lion -> println("lion sound")
            is Monkey -> println("Monkey sound")
        }
    }
}
