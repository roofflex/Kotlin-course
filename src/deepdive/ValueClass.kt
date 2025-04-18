package deepdive

fun main() {
}

data class User(
    val nickName: String,
    val email: String,
    val password: Password
)

@JvmInline
value class Password(private val value: String) {
    init {
        require(value.length > 8) { "Minimum password length is 8 characters" }
        require(value.toCharArray().any { SPECIAL_CHARS.contains(it) }) {
            "Password must contain at least 1 special character (${SPECIAL_CHARS})"
        }
    }
}

private val SPECIAL_CHARS = setOf('@', '$')