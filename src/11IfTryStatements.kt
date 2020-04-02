import kotlin.random.Random

fun main() {
    val whatToDo = if (Random.nextBoolean()) {
        "Something Something"
    } else {
        "Another Another"
    }
    println(whatToDo)

    val booleanResult = try {
        // Unsafe operation that needs to be wrapped
        true
    } catch (e: Exception) {
        false
    }

    println(booleanResult)

    val nullableResult = try {
        // Unsafe operation that needs to be wrapped
        "NonNull"
    } catch (e: Exception) {
        null
    }
    println(nullableResult)
}