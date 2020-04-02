// TODO Debug me
fun main() {
    val element = MyClass()

    element.initialize()
    println(element.toString())
}

private class MyClass {
    val immutableValue = "immutableValue"
    var mutableValue: String? = "mutableValue"
    val lazyValue by lazy { "Lazy initialized value" }
    lateinit var lateInitValue: String

    fun initialize() {
        mutableValue = null
        lateInitValue = "initialized"
    }

    override fun toString(): String {
        return "MyClass(immutableValue='$immutableValue', mutableValue='$mutableValue', lateInitValue='$lateInitValue', lazyValue='$lazyValue')"
    }
}