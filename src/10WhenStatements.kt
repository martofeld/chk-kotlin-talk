fun main() {
    simpleWhen(Cardinals.NORTH)
    complexWhen("abcdefg")
    val position = whenStatement(Cardinals.EAST)
    println(position)
    val multiplier = whenStatement2(Cardinals.NORTH)
    println(multiplier)
}

private fun simpleWhen(cardinal: Cardinals) {
    when (cardinal) {
        Cardinals.SOUTH -> println("We are south of the wall")
        Cardinals.NORTH -> println("Winter is Coming")
        Cardinals.WEST -> println("This Is Westeros")
        Cardinals.EAST -> println("Meh, the east")
    }
}

private fun complexWhen(value: String) {
    when {
        value.contains("b") -> println("Value can't contain a b")
        value.length > 6 -> println("Value is long enough")
        value.startsWith("z") -> println("Value starts with z :)")
        !value.toBoolean() -> println("Why so negative?")
        else -> TODO()
    }
}

private fun whenStatement(cardinal: Cardinals): Int {
    return when (cardinal) {
        Cardinals.SOUTH -> 1
        Cardinals.NORTH -> 2
        Cardinals.WEST -> 3
        Cardinals.EAST -> 4
    }
}

private fun whenStatement2(cardinal: Cardinals): Int {
    return when (cardinal) {
        Cardinals.SOUTH -> -1
        Cardinals.NORTH -> 1
        else -> 0
    }
}

private enum class Cardinals {
    SOUTH, NORTH, WEST, EAST
}