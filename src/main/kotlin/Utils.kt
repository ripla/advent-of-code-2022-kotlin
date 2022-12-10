import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/resources", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

fun <T> List<T>.toPair(): Pair<T, T> {
    if (this.size != 2) {
        throw IllegalArgumentException("List length must be exactly 2! Was ${this.size}")
    }
    return Pair(this[0], this[1])
}

fun <T, T2> Pair<T, T>.map(mapFun: (T) -> T2): Pair<T2, T2> {
    return Pair(mapFun(this.first), mapFun(this.second))
}

fun Pair<Int,Int>.toIntRange(): IntRange {
    return IntRange(this.first, this.second)
}