import kotlin.reflect.KClass

const val L = 21
const val M = 23

// https://proandroiddev.com/how-reified-type-makes-kotlin-so-much-better-7ae539ed0304
fun main() {
    val context = Context()
    withApiLevel(M) {
        val service = context.getSystemService<SystemService>() as SystemService
        println(service.isEnabled())
    }
}

inline fun withApiLevel(apiLevel: Int, block: () -> Unit) {
    if (apiLevel >= getApiLevel()) {
        block()
    }
}

inline fun <reified T> Context.getSystemService(): Any? {
    return when (T::class) {
        SystemService::class -> MockSystemService()
        else -> null
    }
}

// Mock function
fun getApiLevel() = L

class Context {
    fun getDrawable(drawable: Int): Int {
        return drawable
    }
}

interface SystemService {
    fun isEnabled(): Boolean
}

class MockSystemService : SystemService {
    override fun isEnabled() = true
}


interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}

fun <T> id(x: T): T = x

fun main2() {
    val f = Foo(42)

    asInline(f)    // unboxed: used as Foo itself
    asGeneric(f)   // boxed: used as generic type T
    asInterface(f) // boxed: used as type I
    asNullable(f)  // boxed: used as Foo?, which is different from Foo

    // below, 'f' first is boxed (while being passed to 'id') and then unboxed (when returned from 'id')
    // In the end, 'c' contains unboxed representation (just '42'), as 'f'
    val c = id(f)
}