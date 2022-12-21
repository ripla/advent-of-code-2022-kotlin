object Day7 {
    data class Directory(
        val name: String,
        val parent: Directory?,
        var directories: List<Directory> = emptyList(),
        var files: List<File> = emptyList()
    ) {
        fun getRoot(): Directory = parent?.getRoot() ?: this

        fun size(): Int = files.sumOf { it.size } + directories.sumOf { it.size() }

        fun subDirectoriesAsList(): List<Directory> = directories + directories.flatMap { it.subDirectoriesAsList() }
    }

    data class File(val name: String, val size: Int)

    private fun executeCommand(command: String, currentDir: Directory): Directory =
        when (val param = command.split(" ").last()) {
            "/" -> currentDir.getRoot()

            ".." -> currentDir.parent ?: currentDir

            "ls" -> currentDir // noop

            // cd abc
            else -> currentDir.directories.find { dir -> dir.name == param } ?: currentDir
        }

    private fun buildDirectoryTree(
        input: List<String>,
        root: Directory
    ) = input.fold(root) { currentDirectory, inputLine ->

        when {
            inputLine.startsWith("$") -> {
                val command = inputLine.drop(2)
                executeCommand(command, currentDirectory)
            }

            inputLine.startsWith("dir") -> {
                val (command, directoryName) = inputLine.split(" ")
                currentDirectory.directories = currentDirectory.directories + Directory(directoryName, currentDirectory)
                currentDirectory
            }

            inputLine.first().isDigit() -> {
                val (size, fileName) = inputLine.split(" ")
                currentDirectory.files = currentDirectory.files + File(fileName, size.toInt())
                currentDirectory
            }

            else -> throw Error("Unknown $inputLine")
        }
    }

    fun part1(input: List<String>): Int {
        val root = Directory("", null)

        buildDirectoryTree(input, root)

        return root.subDirectoriesAsList()
            .filter { it.size() < 100000 }
            .sumOf { it.size() }
    }

    fun part2(input: List<String>): Int {
        val root = Directory("", null)

        buildDirectoryTree(input, root)

        val totalDiskSpace = 70000000
        val currentlyUsedSpace = root.size()
        val unusedSpace = totalDiskSpace - currentlyUsedSpace
        val neededSpace = 30000000

        return root.subDirectoriesAsList()
            .map { it.size() }
            .sorted()
            .find { unusedSpace + it >= neededSpace } ?: -1
    }
}
