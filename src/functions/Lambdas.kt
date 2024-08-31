package functions

fun main(args: Array<String>) {
    greetPeople()
}

fun greetPeople() {
    val menNames = listOf("Jack", "Bob")
    val womenNames = listOf("Rose", "Jessica", "Judy")

    val menGreetingLambda = { name: String -> println("Hello mr. $name") }

    // lamda may be used either like this:
    sayHello(menNames, menGreetingLambda)
    // or like this:
    sayHello(womenNames) { name: String -> println("Hello mrs. $name") }
    // the latter approach is used by far more often

    val allNames = listOf(
        menNames,
        womenNames
    ).flatten()

    // if lambda has 1 parameter, it can be referred to as "it"
    allNames.forEach { println("Hello $it") }

    // some of the handy functions
    val allNamesSortedByLength = allNames.sortedBy { it.length }
    val maxLengthName = allNames.maxByOrNull { it.length }
}

fun sayHello(names: List<String>, greetPerson: (String) -> Unit) {
    for (name in names) {
        greetPerson(name)
    }
}