import com.burt.kotlin.NewPerson

class AirPlane  //A very simple class

class Customer {
    val id = 7  //This is a immutable property
    var name = "john" //This is a mutable property
}

class Person(firstName_: String, lastName_: String) {
    val firstName = firstName_
    var lastName = lastName_
}

class NewPerson(val firstName: String, var lastName: String)  //2 properties. one read-only and one read-write.

class NewPerson1(val firstName: String, var lastName: String) { //2 properties. one read-only and one read-write.
    init {
        lastName = lastName.toUpperCase() // Update property in init. init called after construction.
    }
}

class NewPerson2(val firstName: String, var lastName: String = "John")  //Default arg in constructors.

class NewPerson3(val firstName: String, var lastName: String = "John") {
    //Primary constructor
    constructor(firstName: String) : this(firstName, "Joe") { // Secondary constructor. Need to call the super with this.

    }
}

//Custom getters and setters.
class NewPerson4(val firstName: String, val offset: Int = 10, var lastName: String = "John") {
    val age: Int  //Property with a custom getter
        get() {
            return offset * 7
        }
    var ssn: String = ""
        set(value) { // Custom setter
            field = java.util.Date().toString() + value  //field is a special value that refers to the underlying property.
        }
}

class NewPerson5(val firstName: String, var lastName: String = "Doe") { // Functions in a class
    fun getName(): String { //Default is public access for class members.
        return firstName + lastName
    }

    private fun getName1(): String { // private function only visible inside the class.
        return firstName + lastName
    }

    protected fun getName2(): String {// protected function visible inside the class and it's subclasses.
        return firstName + lastName
    }
}

//Data class. Data classes can also have inheritence hierarchies.
data class Employee(var firstName: String, val lastName: String, val id: Int, val hobbies: List<String>)

//Data class with custom setter
data class Employee1(var firstName: String, val lastName: String, val id: Int, val hobbies: List<String>) {
    var ssn: String = "7777"
        set(value) {
            field = "4444"
        }

    override fun toString(): String { // You can override any auto generated methods in a data class.classes.kt
        return "Overridden toString() " + super.toString()
    }
}

open class Animal {
    // If not declared open, the class is considered final and cannot be subclasses.
    open fun speak() { // If not declared open, the method is considered final and cannot be subclasses.
    }

    open fun talk(){
    }
}

open class Dog : Animal { //Animal has to be declared open
    override fun speak(){  //override is mandatory for a overridden method.
    }

    final override fun talk(){ // to prevent overriding this method in a subclass of Dog use final.
    }
    constructor():super(){ //Call super constructor using super.
    }
}

class GoldenRetriever: Dog() {
    override fun speak(){
    }
//    override fun talk(){ // Cannot override talk since it is declared final in super class Dog.
//    }
}

abstract class Vehicle(val numWheels:Int, val name:String){
    fun getWheels():Int{
        return numWheels
    }
    abstract fun getType():String
}

class Car(val numWheels_:Int, val name_:String):Vehicle(numWheels_, name_){
    override fun getType(): String {
        return name
    }
}

// Late initialization.

// Nested classes.

// Companion objects.

// Hiding Constructors

// Sealed classes.

object Region { //Singelton object
    val region = "US"
}

fun main(args: Array<String>) {
    val emp = Employee("`Siddle`", "Middle", 77, listOf("Games", "Reading", "Cooking", "IOT"))
    println("Employee : " + emp)
    val customer = Customer() // new operator is not required for creating instance of a class.
    println("Name : " + customer.name)
    customer.name = "Doe" // Access class property.
    println("Name : " + customer.name)
    val np = NewPerson5("John")
    println("Name : " + np.getName())

    val localObject = object {
        val PI = Math.PI
    }
    println("local object : " + localObject.PI)
}