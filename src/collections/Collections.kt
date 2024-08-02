package collections

fun main(args: Array<String>) {
    workWithCollections()
}

fun workWithCollections() {
    val trafficLightColors = listOf("red", "yellow", "green")

    val darkColors = mutableListOf<String>()
    darkColors.add("black")
    darkColors.add("grey")
    darkColors.add("brown")

    println("The first dark color I remembered is ${darkColors[0]}")

    val set1 = setOf(1, 2, 5, 7, 9)
    val set2 = setOf(2, 3, 4, 7)

    println("set1 = $set1")
    println("set2 = $set2")
    println("Intersection of set1 and set2 is ${set1.intersect(set2)}")
    println("Union of set1 and set2 is ${set1.union(set2).sorted()}")

    val ageByName = mapOf<String, Int>(
        "Ivan" to 19,
        "Jack" to 21,
        "John" to 35
    )

    println(ageByName)
}