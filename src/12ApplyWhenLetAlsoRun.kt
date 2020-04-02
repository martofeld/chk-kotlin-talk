import java.lang.StringBuilder

// https://medium.com/@fatihcoskun/kotlin-scoping-functions-apply-vs-with-let-also-run-816e4efb75f5

fun main() {
    "".also { it.substring(0, 5) }
    "".apply { substring(0, 5) }
    val myVay = StringBuilder().run {
        append("")
        if("" != null) {
            append("Hola")
        }
        toString()
    }
    val myStringNN = myString ?: return
    myStringNN.length
    with(MyUI()) {
        image
        color
    }
}

var myString: String? = null
