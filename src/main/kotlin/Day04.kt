object Day4 {

    private fun stringToIntRange(stringRange: String): IntRange =
        stringRange
            .split("-")
            .toPair()
            .map { it.toInt() }
            .toIntRange()

    private fun containsOther(elfPair: Pair<IntRange, IntRange>): Boolean =
        elfPair.first.all(elfPair.second::contains) || elfPair.second.all(elfPair.first::contains)

    private fun rangesOverlap(elfPair: Pair<IntRange, IntRange>): Boolean =
        elfPair.first.intersect(elfPair.second).isNotEmpty()

    fun part1(input: List<String>): Int {
        return input.map { it.split(",").toPair() }
            .map { it.map(::stringToIntRange) }
            .map(::containsOther)
            .count { it }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(",").toPair() }
            .map { it.map(::stringToIntRange) }
            .map(::rangesOverlap)
            .count { it }
    }
}
