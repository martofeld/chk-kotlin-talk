fun main() {
    val myList = listOf<String>("1", "2", "3")

    println(parseList(myList))

}

fun parseList(list: List<String>): Int? {
    return list
        .filter { return@filter it.length == 1 }
        .map {
//            return it.toIntOrNull()
            return@map it.toIntOrNull()
        }
        .filterNotNull()
        .sumBy { it }
}