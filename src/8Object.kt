fun main() {
    println(MyObject)
    println(MyObject == MyObject)

    MyObject.doMagic()

    AnotherClass.magicStuff()

    AnotherClass().magicStuff()
}

private object MyObject {
    fun doMagic() {
        println("Applying some magic")
    }
}

private class AnotherClass {
    fun magicStuff() {
        println("Class == ${this::class}")
    }

    companion object  {
        fun magicStuff() {
            println("Class == ${this::class}")
        }
    }
}