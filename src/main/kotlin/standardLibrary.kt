fun main(args: Array<String>) {
    // Create a immutable list.
    val list = listOf("First", "Second", "Third","Fourth")
    list.forEach { println(it) }

    // Create a mutable list.
    val mutableList = mutableListOf("New York")
    mutableList.add("Boston")
    mutableList.add("Philadelphia")
    mutableList.add("Phoenix")
    mutableList.forEach{println(it)}
}

