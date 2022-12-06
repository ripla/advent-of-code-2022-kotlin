import Day1.part1
import Day1.part2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01Test {

    @Test
    fun part1Test(){
        val testInput = readInput("Day01_test")

        assertEquals(24000, part1(testInput))

        val input = readInput("Day01")
        println("Part 1: ${part1(input)}")
    }

    @Test
    fun part2Test(){
        val testInput = readInput("Day01_test")

        assertEquals(45000, part2(testInput))

        val input = readInput("Day01")
        println("Part 2: ${part2(input)}")
    }
}