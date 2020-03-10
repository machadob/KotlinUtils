import java.lang.Exception
import java.sql.SQLException

fun main(args: Array<String>) {
// Type casting
//if(obj is Employee){  // If you check to see if an object is of a particular type, you do not have to type cast it
//    obj.getName()     // to that type. Here we did not have to type cast obj to an Employee.
//    val emp = obj as Employee // Can also do thisgit
//}

// Tuples : Tuples were removed from Kotlin. Just use data classes. Pair and Triple can be used for 2 or 3 values.
    val pair:Pair<String, Long> = Pair("John", 77)
    println("First value : ${pair.first}, Second value : ${pair.second}")
    val triple:Triple<String, String, Long> = Triple("John","Doe", 77)
    println("First value : ${triple.first}, Second value : ${triple.second}, Third value : ${triple.third}")

// Deconstructing values
    val (one, two, three) = triple
    println("one : ${one}, two : ${two}, three : ${three}")
// Deconstructing values from a data class.
    data class Customer(var firstName: String, var lastName:String, var id:Int, var city:String)
    val customer = Customer("John", "Doe", 7, "NY")
    val (firstName, lastName, id, city) = customer // Deconstruct the values.
// Deconstruction in for loops.
    val listAnimalTypes = listOf(Pair("Dog", "Mammal"), "Tuna" to "Fish") // Note the second pair - Another way.
    for((name, type) in listAnimalTypes){ // Deconstruct each pair in a for loop.
        println("Name : $name, Type : $type")
    }

// Exceptions
    // Kotlin does not have checked exceptions.
    // try blocks are expressions as shown below:
    val retVal = try{
        1 // This is the value assigned to retVal if there are no exceptions thrown.
    }catch(exp: SQLException){
        2 // This is the value assigned to retVal if in case of a SQLException.
    }catch(exp: Exception){
        3// This is the value assigned to retVal if in case of a Exception.
    }finally {
        //Close resources etc.
        4 // This is the value assigned to retVal from finally.
    }
    println("retVal : $retVal")

// Constants
    PriceTypes.market // An object can be used to group constants.
}

// Constants
object PriceTypes{
    val market = " MARKET PRICE"
}

// Annotations
class AnnotationTester {
    @SuppressWarnings fun testAnnotation(){// Annotations are similar to Java.
    }
}

