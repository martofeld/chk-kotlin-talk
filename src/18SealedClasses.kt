import kotlin.random.Random

fun main() {
    val sealedStatus = getSealedClassStatus()
    println(sealedStatus)
    when (sealedStatus) {
        is SealedClassStatus.Success -> println("Everything when great ${sealedStatus.result}")
        is SealedClassStatus.Error -> {
            println("Something went wrong")
            sealedStatus.error.printStackTrace()
            // Retry
        }
        is SealedClassStatus.Loading -> {
            // TODO set loading status
            sealedStatus.isLoading.not()
        }
    }

    val enumStatus = getEnumClassStatus()
    println(enumStatus)
    when (enumStatus.status) {
        EnumStatus.SUCCESS -> println("Everything when great ${enumStatus.result}")
        EnumStatus.ERROR -> {
            println("Something went wrong")
            enumStatus.error?.printStackTrace()
            // Retry
        }
        EnumStatus.LOADING -> {
            // TODO set loading status
            enumStatus.isLoading?.not()
        }
    }
}

fun getSealedClassStatus(): SealedClassStatus<String> {
    return when (Random.nextInt(10)) {
        in 0..3 -> SealedClassStatus.Success("Success Result")
        in 4..8 -> SealedClassStatus.Error(Throwable("asdasd"))
        else -> SealedClassStatus.Loading(false)
    }
}

fun getEnumClassStatus(): Result {
    return when (Random.nextInt(10)) {
        in 0..3 -> Result.success("Success Result")
        in 4..8 -> Result.error(Throwable("asdasd"))
        else -> Result.loading(false)
    }
}

sealed class SealedClassStatus<out T> {
    data class Success<T>(val result: T) : SealedClassStatus<T>()
    data class Error<T>(val error: Throwable) : SealedClassStatus<T>()
    data class Loading<T>(val isLoading: Boolean) : SealedClassStatus<T>()
}

enum class EnumStatus {
    SUCCESS,
    ERROR,
    LOADING
}

class Result(
    val status: EnumStatus,
    val result: String? = null,
    val error: Throwable? = null,
    val isLoading: Boolean? = null
) {
    companion object {
        fun success(result: String) = Result(EnumStatus.SUCCESS, result)

        fun error(throwable: Throwable) = Result(EnumStatus.ERROR, error = throwable)

        fun loading(loading: Boolean) = Result(EnumStatus.LOADING, isLoading = loading)
    }
}





sealed class Optional<out T> {
    class Present<T>(val value: T) : Optional<T>()
    object Absent : Optional<Nothing>()
}