object Day1 {

    fun part1(input: List<String>): Int {
        val elvesGrouped: List<List<Int>> = input.fold(listOf(emptyList())) { acc: List<List<Int>>, element ->
            (if (element == "") {
                acc.plusElement(emptyList())
            } else {
                val elfAdded: List<Int> = acc.last()  + element.toInt()
                acc.dropLast(1).plusElement(elfAdded)
            })
        }

        val elvesSummed = elvesGrouped.map { elf -> elf.sum()}
        return elvesSummed.max()
    }

    fun part2(input: List<String>): Int {
        val elvesGrouped: List<List<Int>> = input.fold(listOf(emptyList())) { acc: List<List<Int>>, element ->
            (if (element == "") {
                acc.plusElement(emptyList())
            } else {
                val elfAdded: List<Int> = acc.last()  + element.toInt()
                acc.dropLast(1).plusElement(elfAdded)
            })
        }

        val elvesSummed = elvesGrouped.map { elf -> elf.sum()}
        val elvesSorted = elvesSummed.sortedDescending()
        return elvesSorted.take(3).sum()
    }
}
