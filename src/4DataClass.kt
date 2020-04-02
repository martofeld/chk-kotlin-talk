fun main() {
    val dataClass1 = MyDataClass("string", 1, true)
    val dataClass2 = MyDataClass("string", 1, true)

    println(dataClass1 == dataClass2)

    val regularClass1 = MyRegularClass("string", 1, true)
    val regularClass2 = MyRegularClass("string", 1, true)
    println(regularClass1 == regularClass2)

    println(dataClass1.hashCode())
    println(dataClass2.hashCode())
    println(regularClass1.hashCode())
    println(regularClass2.hashCode())

    dataClass1.copy(string = "Another String")
}

private data class MyDataClass(val string: String, val int: Int, val boolean: Boolean)

private class MyRegularClass(val string: String, val int: Int, val boolean: Boolean)