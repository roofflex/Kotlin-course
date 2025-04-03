package deepdive

import kotlin.random.Random
import kotlin.random.nextInt

class Person(
    val firstName: String,
    val lastName: String,
    nickname: String,
) {
    val fullName: String
        // defining a get accessor allows creating a 'computable' property
        get() = "$firstName $lastName"

    var xboxNickname: String = nickname.appendRandom4Digits()
        // set accessor is called every time the field is modified, EXCEPT the initialization
        set(value) {
            field = value.appendRandom4Digits()
        }

    var assignedSupportAgentEmail: String = "mary.l@microsoft.com"
        // accessors can be made private. In case only visibility is changed, parenthesis and body may be omitted
        private set

    private fun String.appendRandom4Digits(): String =
        "$this${Random.nextInt(range = 1000..9999)}"

    override fun toString(): String {
        return "Person(firstName='$firstName', lastName='$lastName', fullName='$fullName', xboxNickname='$xboxNickname')"
    }
}

fun main() {
    val jack = Person(
        firstName = "Jack",
        lastName = "Sparrow",
        nickname = "blackpearl",
    )
    println("Initial Jack: $jack")

    jack.xboxNickname = "barbarossa"

    println("Jack with updated nickname: $jack")

    println("Jack's support agent is ${jack.assignedSupportAgentEmail}")
}