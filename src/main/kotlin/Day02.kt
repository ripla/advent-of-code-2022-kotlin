object Day2 {

    sealed interface Play {
        val score: Int
        val beats: Play
        val loses: Play
    }

    object ROCK : Play {
        override val score = 1
        override val beats = SCISSORS
        override val loses = PAPER

    }

    object PAPER : Play {
        override val score = 2
        override val beats = ROCK
        override val loses = SCISSORS
    }

    object SCISSORS : Play {
        override val score = 3
        override val beats = PAPER
        override val loses = ROCK
    }

    enum class PlayResult(val score: Int) {
        WIN(6), TIE(3), LOSE(0)
    }

    private fun stringPlayToEnum(input: String): Play {
        return when (input) {
            in "AX" -> ROCK
            in "BY" -> PAPER
            in "CZ" -> SCISSORS
            else -> {
                throw Error()
            }
        }
    }

    private fun calculateScore(opponentPlay: Play, myPlay: Play): Int {
        val playResult = calculateResult(opponentPlay, myPlay)
        return playResult.score + myPlay.score
    }

    private fun calculateResult(opponentPlay: Play, myPlay: Play): PlayResult {
        if (myPlay == opponentPlay) {
            return PlayResult.TIE
        }
        if (myPlay.beats == opponentPlay) {
            return PlayResult.WIN;
        }
        return PlayResult.LOSE
    }

    private fun playByStrategy(opponentPlayString: String, myStrategy: String): Pair<Play, Play> {
        val opponentPlay = stringPlayToEnum(opponentPlayString)
        return when (myStrategy) {
            "Y" -> Pair(opponentPlay, opponentPlay)
            "X" -> Pair(opponentPlay, opponentPlay.beats)
            "Z" -> Pair(opponentPlay, opponentPlay.loses)
            else -> throw Error()
        }
    }

    fun part1(input: List<String>): Int {
        return input
            .map { it.split(" ").toPair() }
            .map { stringPair -> stringPair.map { stringPlayToEnum(it) }}
            .sumOf { playPair -> calculateScore(playPair.first, playPair.second) }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split(" ").toPair() }
            .map { playPair -> playByStrategy(playPair.first, playPair.second) }
            .sumOf { playPair -> calculateScore(playPair.first, playPair.second) }
    }
}
