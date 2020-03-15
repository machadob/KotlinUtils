import java.util.*

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
    // Create list of Random numbers.
    val fullList = ((1..20).shuffled()).toList()
    println(fullList)
    // Filter the list.
    val filteredList = fullList.filter { it > 10 }
    println(filteredList)
    // Map the filtered list to IdHolder objects.
    val mappedList = filteredList.map { IdHolder(it) }
    println(mappedList)
    // Filter and Map in one pipeline.
    val filteredAndMappedList = fullList.filter { it > 10 }.map { IdHolder(it) }
    println(filteredAndMappedList)
    // Filter, Map and Sort in one pipeline.
    val filteredAndMappedAndSortedList = fullList.filter { it > 10 }.map { IdHolder(it) }.sortedBy { it.id }
    println(filteredAndMappedAndSortedList)

}

