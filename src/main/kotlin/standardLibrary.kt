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

    // HashMap. Notice the different ways of creating Map entries.
    val map = hashMapOf("One" to 1, "Two" to 1, Pair("Three", 3), Pair("Four", 4))
    map.forEach { k, v ->  println("Key : $k, Value: $v")}

    // Filter, Map, FlatMap etc.
}

