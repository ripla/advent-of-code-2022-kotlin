object Day5 {

    class Command(val amount: Int, val from: Int, val to: Int)

    private val commandRegex = Regex("""\d+""")

    fun part1(input: List<String>): String {
        val (commandLines, rest) = input.partition { it.startsWith("move") }
        val stackLines = rest.dropLast(2);

        val numberOfStacks = stackLines.last().length
        val maxStackHeight = stackLines.size

        val transposedEmptyStacks = List(numberOfStacks) { CharArray(maxStackHeight) }

        val transposedStacks = stackLines
            .foldIndexed(transposedEmptyStacks) { index, acc, value ->
                value.toCharArray().withIndex().forEach { (stringIndex, charValue) ->
                    acc[stringIndex][index] = charValue
                }

                return@foldIndexed acc
            }
            .filter { !it.contains('[') && !it.contains(']') }
            .filter { !it.all { char -> char == ' ' } }
            .map {it -> it.filterNot { it.isWhitespace() }}
            .map { it.reversed() }
            .map { it.toMutableList() }

        return commandLines.map { commandLine ->
            val commandSplit = commandRegex.findAll(commandLine).map { it.value }.map { it.toInt() }.toList()
            Command(commandSplit[0], commandSplit[1]-1, commandSplit[2]-1)
        }.fold(transposedStacks) { stacks, command ->
            (1..command.amount).forEach { _ -> stacks[command.to].add(stacks[command.from].removeLast()) }
            stacks
        }.map { it.last() }.joinToString(separator = "")
    }

    fun part2(input: List<String>): String {
        val (commandLines, rest) = input.partition { it.startsWith("move") }
        val stackLines = rest.dropLast(2);

        val numberOfStacks = stackLines.last().length
        val maxStackHeight = stackLines.size

        val transposedEmptyStacks = List(numberOfStacks) { CharArray(maxStackHeight) }

        val transposedStacks = stackLines
            .foldIndexed(transposedEmptyStacks) { index, acc, value ->
                value.toCharArray().withIndex().forEach { (stringIndex, charValue) ->
                    acc[stringIndex][index] = charValue
                }

                return@foldIndexed acc
            }
            .filter { !it.contains('[') && !it.contains(']') }
            .filter { !it.all { char -> char == ' ' } }
            .map {it -> it.filterNot { it.isWhitespace() }}
            .map { it.reversed() }
            .map { it.toMutableList() }
            .toList()

        return commandLines.map { commandLine ->
            val commandSplit = commandRegex.findAll(commandLine).map { it.value }.map { it.toInt() }.toList()
            Command(commandSplit[0], commandSplit[1]-1, commandSplit[2]-1)
        }.fold(transposedStacks) { stacks, command ->
            stacks[command.to].addAll(stacks[command.from].takeLast(command.amount))
            (1..command.amount).forEach { _ -> stacks[command.from].removeLast() }
            stacks
        }.map { it.last() }.joinToString(separator = "")
    }
}
