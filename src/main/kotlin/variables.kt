import java.io.File

fun main(args: Array<String>) {
    var myId:Int; // Declare a mutable variable
    var name:String;
    var yourName = "John"  // Type of yourName inferred from the initialized value.
    val lastName = "Doe" // Declare and initilize immutable variable lastName. Type inferred from value;
//  lastName = "Moe"  // Error: Changing value of an immutable variable.
    var salary = 100000L // L is for long. F is float. 0x0F is hex F. 0xb01 is binary 1.
    var myInt = 77
//  var myLong:Long = myInt  //No implicit conversions in Kotlin. Even when the target is wide enough.
    var myLong:Long = myInt.toLong()  // Use explicit helper function when converting between types.

    val myChar = 'A'  //A char type.
    val myString = "Hello" // A String type.
    val multiLineString = """ This is a 
        multi line
        String.
        """ .trimIndent()
    val season = "Winter"
    val message = "The season is $season"  // String interpolation. Can also use ${season}.
    val lenMessage = "The length season is ${season.length}" // Function call in String interpolation. Can also use arbitrary code.
}