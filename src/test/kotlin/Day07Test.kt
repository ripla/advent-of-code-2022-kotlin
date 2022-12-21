import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import Day7.part1
import Day7.part2

private const val TEST_INPUT_NAME = "Day07_test"
private const val INPUT_NAME = "Day07"
internal class Day07Test {

    @Test
    fun part1Test() {
        val testInput = readInput(TEST_INPUT_NAME)

        val testResult1 = part1(testInput)

        println("Solution for part 1 test: $testResult1")

        Assertions.assertEquals(95437, testResult1)

        val input = readInput(INPUT_NAME)

        val result1 = part1(input)

        println("Solution for part 1: $result1")

        Assertions.assertEquals(1084134, result1)
    }

    @Test
    fun part2Test() {
        val testInput = readInput(TEST_INPUT_NAME)

        val testResult2 = part2(testInput)

        println("Solution for part 2 test: $testResult2")

        Assertions.assertEquals(24933642, testResult2)

        val input = readInput(INPUT_NAME)

        val result2 = part2(input)

        println("Solution for part 2: $result2")

        Assertions.assertEquals(6183184, result2)
    }
}