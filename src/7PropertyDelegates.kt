import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main() {
    val user = MyUser(mapOf("name" to "Martin", "age" to 23))
    println(user)

    val myUI = MyUI()
    println(myUI.image)
    println(myUI.color)
}

class MyUser(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map

    override fun toString(): String {
        return "MyUser('name'=$name, 'age'=$age)"
    }
}

class MyUI {
    val image by bindResource(R.drawable.my_drawable)
    val color by bindResource(R.color.my_color)
}



fun bindResource(id: Int): ResourceLoader {
    return ResourceLoader(id)
}

class ResourceDelegate(val id: Int) : ReadOnlyProperty<MyUI, Int> {
    override fun getValue(thisRef: MyUI, property: KProperty<*>): Int {
        return Context().getDrawable(id)
    }
}

class ResourceLoader(private val id: Int) {
    operator fun provideDelegate(
        thisRef: MyUI,
        prop: KProperty<*>
    ): ReadOnlyProperty<MyUI, Int> {
        // create delegate
        return ResourceDelegate(id)
    }
}

object R {
    object drawable {
        val my_drawable = 0x1533
    }

    object color {
        val my_color = 0x4311
    }
}