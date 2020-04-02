fun main() {
    JavaInteropObject.myStaticMethod()
    JavaInteropObject.nonPrimitiveElement
    JavaInteropObject.methodWithOverloads("", p3 = true)
    JavaInteropObject.nameForKotlin()
}

object JavaInteropObject {
    @JvmField
    val nonPrimitiveElement = MyUI()

    const val constant = "constant"

    @JvmStatic
    fun myStaticMethod() {
        println("Calling from static method")
    }

    @JvmOverloads
    fun methodWithOverloads(p1: String, p2: Int = 0, p3: Boolean = false): String {
        return "String=$p1, Integer=$p2, Boolean=$p3"
    }

    @JvmName("nameForJava")
    fun nameForKotlin(): String {
        return "Result is the same"
    }
}