package oop

import kotlin.random.Random

fun main() {
    val key1 = Lock.createKey()
    val key2 = Lock.createKey()

    val lock1 = Lock(key1)

    println("Key 1 unlocks lock 1: ${lock1.unlock(key1)}")
    println("Key 2 unlocks lock 1: ${lock1.unlock(key2)}")
}

class Lock(private val key: Key) {
    private val secretCode: Int

    init {
        val generatedSecretCode = Random.nextInt()

        secretCode = generatedSecretCode
        key.secretCode = generatedSecretCode
    }

    fun unlock(key: Key): Boolean {
        return key.secretCode == this.secretCode
    }

    companion object {
        fun createKey(): Key {
            return Key()
        }
    }
}

class Key {
    var secretCode = 0
}