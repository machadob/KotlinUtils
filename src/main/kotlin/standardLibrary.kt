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

    val boolArray = booleanArrayOf(true, false, true, false)
    val charArray = charArrayOf('A', 'B', 'C', 'D')

    // HashMap. Notice the different ways of creating Map entries.
    val map = hashMapOf("One" to 1, "Two" to 1, Pair("Three", 3), Pair("Four", 4))
    map.forEach { k, v ->  println("Key : $k, Value: $v")}

    // Filter, Map, FlatMap etc.
    data class IdHolder(var id:Int)
    val fullList = (1..20).toList() // Create list of nummbers.
    println(fullList) // Filter the list.
    val filteredList = fullList.filter { it > 10 }
    println(filteredList)
    val mappedList = filteredList.map { IdHolder(it) } // Map the filtered list to IdHolder objects.
    println(mappedList)
    val filteredAndMappedList = fullList.filter { it > 10 }.map { IdHolder(it) } // Filter and Map in onde pipeline.
    println(filteredAndMappedList)
}

