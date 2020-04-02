fun main() {
    val systemService = Context().getSystemService<SystemService>() as? SystemService

    println(systemService)
}