fun main() {
    find()
    filter()
    fold()
    reduce()
    map()
    first()
    firstWithLambda()
    groupBy()
    forEach()
    all()
}

fun find() {
    val elements = listOf("Kotlin", "Rules", "Java", "Sucks", "!")
    elements.find {
        it.contains('a')
    }
        .also { println(it) }
}

fun filter() {
    val elements = listOf("Kotlin", "Rules", "Java", "Sucks", "!")
    elements.filter {
        it.contains('s')
    }
        .also { println(it) }
}

fun fold() {
    val elements = listOf(1, 2, 3, 4, 5)
    elements.fold(9) { acc, value ->
        acc + value
    }
        .also { println(it) }
}

fun reduce() {
    val elements = listOf(1, 2, 3, 4, 5)

    elements.reduce { acc, i ->
        acc * i
    }
        .also { println(it) }
}

fun map() {
    val elements = "Kotlin rules, Java doesn't"
    elements.mapNotNull {
        it
    }
        .also { println(it) }
}

fun first() {
    val elements = listOf(1, 2, 3, 4, 5, 6)

    elements.first()
        .also { println(it) }
}

fun firstWithLambda() {
    val elements = 1..15

    elements
        .shuffled()
        .first {
            it > 7
        }
        .also { println(it) }
}

fun groupBy() {
    val elements = "Pablito clavo un clavito que clavito clavo pablito"
    elements
        .split(Regex("\\s"))
        .groupBy { it.first() }
        .also { println(it) }
}

fun forEach() {
    val elements = listOf(true, false, false, true, 1, 4, "Hola")

    elements.forEachIndexed { index, it ->
        println(it)
    }
}

fun all() {
    val elements = listOf(true, false, false, true, 1, 4, "Hola")

    elements
        .all { it is Boolean }
        .also { println(it) }
}