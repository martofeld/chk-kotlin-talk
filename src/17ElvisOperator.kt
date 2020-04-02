import kotlin.random.Random

fun main() {
//    val nonNullString = getNullableString() ?: ""
    val nonNullString = getNullableString() ?: run { String() }

    println(nonNullString)
}

fun getNullableString(): String? {
    return if (Random.nextBoolean()) {
        null
    } else {
        "NonNull"
    }
}