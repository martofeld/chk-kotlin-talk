import kotlin.random.Random

fun main() {
    println("Hola todos, gracias por sumarse".goCrazy())
    println(1.customIsEmpty())
    println(String.customIsEmpty())

    val nullValue = null
    println(nullValue.customIsEmpty())
}

fun String.goCrazy(): String {
    return this.map { if (Random.nextBoolean()) it.toString().toUpperCase() else it.toString() }.joinToString("")
}

fun Any?.customIsEmpty(): Boolean {
    return Random.nextBoolean() || this == null
}

val String.empty
    get() = length == 0