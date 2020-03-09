fun main(args: Array<String>) {
// Type casting
//if(obj is Employee){  // If you check to see if an object is of a particular type, you do not have to type cast it
//    obj.getName()     // to that type. Here we did not have to type cast obj to an Employee.
//}

// Tuples : Tuples were removed from Kotlin. Just use data classes. Pair and Triple can be used for 2 or 3 values.
    val pair:Pair<String, Long> = Pair("John", 77)
    println("First value : ${pair.first} Second value : ${pair.second}")
    val triple:Triple<String, String, Long> = Triple("John","Doe", 77)
    println("First value : ${triple.first} Second value : ${triple.second} Third value : ${triple.third}")

// Deconstructing values

// Exceptions

// Constants

// Annotations
}

