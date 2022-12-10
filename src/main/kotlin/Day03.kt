object Day3 {


    private val characterRanges = CharRange('a', 'z') + CharRange('A', 'Z')
    private fun characterPriority(char: Char): Int = characterRanges.indexOf(char) + 1

    fun part1(input: List<String>): Int {
        return input.map { Pair(it.take(it.length / 2), it.takeLast(it.length / 2)) }
            .map { it.first.toSet().intersect((it.second.toSet())) }
            .map { it.first() }
            .sumOf { characterPriority(it) }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3)
            .map { group -> group.map { it.toSet() } }
            .map { group -> group.reduce{ left, right -> left.intersect(right)} }
            .map { it.first() }
            .sumOf { characterPriority(it) }
    }
}
