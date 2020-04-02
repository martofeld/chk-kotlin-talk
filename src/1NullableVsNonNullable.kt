fun main() {
    integers()
//    booleans()
//    strings()
//    nulls()
}

fun integers() {
    val myInt: Int = 9
    val myNullableInt: Int? = 2

    println(myInt)
    println(myNullableInt)
    println(myInt::class.java)
    println(myNullableInt!!::class.java)
}

fun booleans() {
    val myBoolean: Boolean = false
    val myNullableBoolean: Boolean? = true

    println(myBoolean)
    println(myNullableBoolean)
    println(myBoolean::class.java)
    println(myNullableBoolean!!::class.java)
}

fun strings() {
    val myString = "myString"
    val myNullableString: String? = "myNullableString"

    println(myString)
    println(myNullableString)
    println(myString::class.java)
    println(myNullableString!!::class.java)
}

fun nulls() {
    val `null` = null
    val nullString: String? = null
    println(`null`)
    println(nullString)
}
