package deepdive

/*
 Functional interfaces (which have only 1 abstract method)
 can be declared with 'fun' keyword
 */
fun interface VowelChecker {
    fun checkForVowels(string: String): Boolean
}

val VOWELS = listOf('a', 'e', 'i', 'o', 'u')

fun main() {
    val string1 = "bcd"
    val string2 = "Abc"

    val checker = VowelChecker { s -> s.toCharArray().any { it.lowercaseChar() in VOWELS } }

    println("String $string1 ${if (checker.checkForVowels(string1)) "has" else "doesn't have"} vowels")
    println("String $string2 ${if (checker.checkForVowels(string2)) "has" else "doesn't have"} vowels")
}

