object Day6 {

    fun part1(input: List<String>): Int {
        val dataStreamBuffer = input.first()
        val windowSize = 4
        val marker = dataStreamBuffer.windowed(windowSize, 1).find { possibleMarker ->
            possibleMarker.toSet().size == possibleMarker.length
        } ?: ""

        return dataStreamBuffer.indexOf(marker) + windowSize
    }

    fun part2(input: List<String>): Int {
        val dataStreamBuffer = input.first()
        val windowSize = 14
        val marker = dataStreamBuffer.windowed(windowSize, 1).find { possibleMarker ->
            possibleMarker.toSet().size == possibleMarker.length
        } ?: ""

        return dataStreamBuffer.indexOf(marker) + windowSize
    }
}
