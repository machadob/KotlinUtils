import com.burt.kotlin.NewPerson
import kotlin.reflect.KProperty

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
 class TestPerson{
    lateinit var firstName:String  // Property with lateinit. If you don't want to initialize it immediately and be non-null.
                // You may get a PropertyNotInitialized exception at run time if you forget to init the variable.
                // lateinit is a reminder and hence an explicit override (you know what you are doing).

    fun getPerson():String{
        return firstName
    }
}

// Nested classes.
class Nester(val user:String){
    class Nested(){
        fun nestedFun(){
            //println(user.length) // This does not work. A Nested class is just like a name space.
            // You need a Nested class to use "user" variable from the outer class. See Inner class section below.
        }
    }
    fun nesterFun(){
        val nested = Nested()
        nested.nestedFun()
    }
}

fun testNester(){
    val nested = Nester.Nested()
}

// Inner class.
class Outer(val user:String){
    inner class Inner(){
        fun innerFun(){
            println(user.length) // Can access user from the outer class.
        }
    }
    fun nesterFun(){
        val nested = Inner()
//        Outer().nestedFun()
    }
}
fun testInner(){
    val inner = Outer("John").Inner()
    inner.innerFun()
}

// Companion objects. (Also demonstrates// Hiding Constructors)
// Each class can only have a single companion object.
class Logger private constructor(){ // private constructor prevents direct instantiation. Singleton Pattern
    companion object Factory{// private constructor is optional.
        fun createLogger(logFileName:String):Logger = Logger()
    }
    constructor(logFileName: String):this(){

    }
}

fun testLogger(){
    val logger = Logger.createLogger("test.log") // Use the method create logger directly like a static method.
}


// Sealed classes. (Can be used for switching instead of if statements)
// If a class a defined as sealed, another class can subclass it only in the same file.
sealed class MyBase()
class MyDerived():Base()

// Type aliases.
typealias name = String // Can use type name in place to String to make code more readable, or in DSLs.

object Region { //Singelton object
    val region = "US"
}

// Delegates --  Delegating member functions.
interface MyLogger{ // Only interfaces can be delegeted.
    fun log(message:String);
}
class Myapp(myLogger:MyLogger): MyLogger by myLogger{
    fun testLogger(){
        log("Test Message") // Call log method from the delegate directly;
    }
}
fun testDelegate(){ // This function tests Delegates.
    class MyLoggerImpl:MyLogger{
        override fun log(message: String) {
            println(message)
        }
    }
    val myApp = Myapp(MyLoggerImpl())
    myApp.testLogger()
}

// Delegates --  Delegating properties (Externalizing properties).
class DelPropTest {
    var myProperty : String by ExtProp() // If you have val you just need to implement the getter below.
}
class ExtProp {
    var backingField = "Default" // Is user created .. Not provided.
    operator fun getValue(delPropTest: DelPropTest, property: KProperty<*>):String{
        println(" In getvalue delPropTest : $delPropTest, property : ${property.name}")
        return backingField
    }
    operator fun setValue(delPropTest: DelPropTest, property: KProperty<*>, str:String){
        backingField = str
    }
}
fun DelPropTester(){
    val delPropTest =  DelPropTest()
    println(delPropTest.myProperty)
    delPropTest.myProperty = "New Value"
    println(delPropTest.myProperty)
}

// Property Delegation built into Kotlin.


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