package oop

fun main(args: Array<String>) {
    val motorbike = Motorbike("Kawasaki R1000", 340)

    val defaultCar = Car()
    val upgradedCar = Car(210)
    val newCar = Car("BMW M3", 280)

    val currentTopSpeed = newCar.topSpeed
    newCar.topSpeed = currentTopSpeed + 30
}

// if a class has single constructor, it may be defined right after the class name.
// "constructor" keyword is not necessary, this would work the same:
//
// "Motorbike(val model: String, val topSpeed: Int)"
class Motorbike constructor(val model: String, val topSpeed: Int) {
}

class Car {
    var model: String = DEFAULT_MODEL
    var topSpeed: Int = DEFAULT_TOP_SPEED
        // getters and setters may be overridden to contain additional logic
        get() {
            println("Reading the topSpeed value")
            return field
        }
        set(value) {
            println("Setting the topSpeed value")
            field = value
        }

    constructor() {}

    constructor(topSpeed: Int) {
        this.topSpeed = topSpeed
    }

    constructor(model: String, topSpeed: Int) {
        this.model = model
        this.topSpeed = topSpeed
    }


    companion object {
        const val DEFAULT_MODEL = "VW Golf"
        const val DEFAULT_TOP_SPEED = 150
    }
}