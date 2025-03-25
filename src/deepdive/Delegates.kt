package deepdive

import kotlin.properties.Delegates
import kotlin.random.Random

data class Student(
    val name: String,
    val age: Int,
    private val heightFromApplicationLetter: Int
) {
    /**
     * The [Delegates.notNull] delegate is useful for properties that are expected to be non-null,
     * but can NOT be initialized immediately.
     *
     * **by** keyword delegates the implementation of the accessors (get / set) for this property to the Delegate
     *
     * Trying to read the property before the initial value has been assigned results in an exception.
     *
     * Use-case scenario:
     * A new study year starts in the university.
     * New students are recruited to the University.
     * The University has to create a record for each student, but the group will be assigned
     * only closer to the September.
     * The records will be read only after the lessons start in September.
     * By that time the University guarantees that every student will be assigned a group.
     *
     * That means: for now, the [group] is unknown, but later is will 100% be assigned BEFORE the record is read.
     */
    var group: String by Delegates.notNull()

    /**
     * [Delegates.observable] sets an initial value and calls a specified callback function when property is changed.
     *
     * Use-case scenario:
     * Every student record has an information about current year of studies.
     * Initially, all students have studyYear of 1 (they've just started).
     * After student goes to the next study year, a slight modification of the group name is required.
     *
     * In this case, "onChange" callback automatically does the minor changes to the group name, as the studyYear changes,
     * and also notifies of the studyYear and group changes (printing to the console, for simplicity)
     */
    var studyYear: Int by Delegates.observable(
        initialValue = 1,
        onChange = { _, _, newValue ->
            incrementGroup()
            println("$name has started year $newValue of studies. Group name was changed to $group")
        }
    )

    /**
     * [Delegates.vetoable] invokes the "onChange" callback before the new value is set, to check if the modification is allowed.
     * If the modification is not allowed (callback returns false), then update is VETOED (value stays unmodified).
     *
     * Use-case scenario:
     * Every student has a [height].
     * When student applies to the University, the record is created with the height from the student's application letter [heightFromApplicationLetter].
     * Once the student gies through the medical check, height should be set to the measurement, but erroneous measurements should be skipped.
     * (e.g. height == 0 or height == -20 makes no sense)
     */
    var height: Int by Delegates.vetoable(
        initialValue = heightFromApplicationLetter,
        onChange = { _, _, newValue ->
            val isCorrectValue = newValue >= 100
            if (isCorrectValue.not()) { println("Measurement $newValue is incorrect. Skipping the height update of $name") }

            isCorrectValue
        }
    )

    /**
     * *lateinit* keyword is another way to defer the initialization of a property.
     *
     * Differences from the [Delegates.notNull]:
     * - *lateinit* can NOT be used with primitive types, whereas Delegates.notNull() can
     * - *lateinit* offers a way to check if the property has been initialized (::property.isInitialized)
     */
    lateinit var libraryCard: LibraryCard

    private fun incrementGroup() {
        val groupPrefix = group.substring(startIndex = 0, endIndex = group.lastIndex)
        val incrementedGroupNumber = group[group.lastIndex].toString().toInt() + 1

        group = groupPrefix + incrementedGroupNumber
    }

    override fun toString(): String {
        return "Student(" +
                "name='$name', " +
                "age=$age, " +
                "heightFromApplicationLetter=$heightFromApplicationLetter, " +
                "group='$group', " +
                "studyYear=$studyYear, " +
                "height=$height, " +
                if (::libraryCard.isInitialized) libraryCard else "" +
                ")"
    }


}

data class LibraryCard(
    val id: Long,
    val studentId: String
)

fun main() {
    val john = Student(name = "John", age = 18, heightFromApplicationLetter = 185)

    // This will throw an exception, as we try to access a non-null property which has not been initialized yet.
    // The University tells us that this case is unrealistic.
    // println(john)

    john.group = "A3-1"
    println(john) // this works fine, as the group has been initialized

    // John starts his 2nd year
    john.studyYear = 2
    println(john) // a slight group change can be observed

    // John goes to medical check to measure the height
    // The measurement is incorrect (the bar dropped)
    john.height = 95
    println(john) // height update is skipped

    john.libraryCard = LibraryCard(
        id = Random.nextLong(),
        studentId = "${john.group.hashCode()}-${john.name.hashCode()}"
    )
    println(john) // now a library card can be seen for John
}
