package conditionals

fun main(args: Array<String>) {
    workWithIfExpression()
    workWithInKeyword()
    workWithWhenKeyword()
    workWithForLoop()
}

fun workWithIfExpression() {
    val number = 5

    // if-else may be used an expression to assign value to a variable
    val isEven = if (number % 2 == 0) "Even" else "Odd"
    println("$number is $isEven")
    println()
}

fun workWithInKeyword() {
    val cat = "cat"
    val parrot = "parrot"
    val animals = listOf("dog", "horse", "cat")

    println("animals = $animals")
    println("cat is ${if (cat in animals) "IN" else "NOT IN"} animals list")
    println("parrot is ${if (parrot in animals) "IN" else "NOT IN"} animals list")
    println()

    val seven = 7
    // a..b may represent a numeric range, so x in 1..10 translates to "if (x >= 1) and (x <= 10)"
    println("$seven is ${if (seven in 5..10) "IN BETWEEN" else "NOT IN BETWEEN"} 5..10")
    println()


    for (i in 8 downTo 0 step 2) println("descending from 8 to 0 with step 2, i=$i")
    println()
}

fun workWithWhenKeyword() {
    val animals = setOf("cat", "dog", "crocodile")

    val animal = animals.random()
    var action = ""
    var action2 = ""

    when (animal) {
        "cat" -> action = "pet it"
        "dog" -> action = "feed it"
        else -> action = "google it"
    }

    action2 = when (animal) {
        "cat" -> "go home"
        "dog" -> {
            println("Oh yeah, I met a dog!")
            "walk it"
        }
        else -> "walk away"
    }

    println("when you meet $animal, you should $action and $action2")
    println()

    val months = setOf("January", "February", "March", "April", "May")
    val month = months.random()

    val numberOfDays = when (month) {
        "January", "March", "May" -> 31
        "February" -> 28
        else -> 30
    }

    println("$month has $numberOfDays days")
    println()

    val names = setOf("John", "Donald", "Anastasia")
    val name = names.random()
    // an object that is checked in when may be captured into a val and then used in one of the cases:
    when (val nameLenght = name.length) {
        in 1..4 -> println("Name with $nameLenght letters in it is short")
        in 5..7 -> println("Name with $nameLenght letters in it has an average length")
        else -> println("Name with $nameLenght letters in it is long")
    }
    println()
}

fun workWithForLoop() {
    for (i in 8 downTo 0 step 2) println("descending from 8 to 0 with step 2, i=$i")
    println()

    val animals = setOf("cat", "dog", "crocodile")
    for (animal in animals) {
        println("I know $animal animal.")
    }
}