package com.burt.kotlin.reference;

// Top level function

fun toplevelFunction(){
    println("I am a top level function")
}

// Top level property


// var and val

val myVal:Int = 10 // Cannot reassign to myVal

var myVar:Int = 10 // Can reassign to myVar


// type? (e.g. String?) (A variable can carry a null value if type if postfixed by ?)
val myString:String? = null

// if as expression
fun iffun(){
    val tmp = 4
    val retval = if(tmp == 4) true else false
    println("retval is ${retval}")
}

//let
fun letTest(){
    val s1:String? = null
    val s2 = "Hello"
    s1?.let{println("this is ${it}")}
    s2?.let{println("this is ${it}")}
}

//apply
fun applyTest() = StringBuilder().apply {
    for(letter in 'A'..'Z'){
        append(letter)
    }
}.toString()

//when
fun whenTest(){
val i = 11
    when(i){
        0 -> println("i is zero")
        1,2,3,4,5,6,7 -> println("i is between 1 and 7")
        else -> println("i is > 7")
    }
}

//with
fun withTest(){
val sb = java.lang.StringBuilder()
    with(sb){
        append("Hello ")
        append("World")
    }
    println("sb is : ${sb.toString()}")
}

fun nullTest(){
    val s1 = "Hello"
    val s2:String? = null
    val s3 = s1 as? String
    val s4 = s2 as? String
    val s5 = s2 as? String ?: "Ok"
    val len = s2?.length ?: 7
    val s6 = s2 as String?
    println("s1 : ${s1}")
    println("s2 : ${s2}")
    println("s3 : ${s3}")
    println("s4 : ${s4}")
    println("s5 : ${s5}")
    println("s6 : ${s6}")
    println("len : ${len}")
}

//extension function
fun String.mylength() = (this.length - 1)*2

//when
fun whenfun(x:Int){
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
}

//as. as?
fun asfun(y:Any){
    val x1: String = y as String
    val x2: String? = y as String?
    val x3: String? = y as? String //"Safe" (nullable) cast operator
}

//is, !is
fun isfun(obj:Any){
    if (obj is String) {
        print(obj.length)
    }

    if (obj !is String) { // same as !(obj is String)
        print("Not a String")
    }
    else {
        print(obj.length)
    }
}

//in, !in
fun infun(){
    for (i in 1..4) print(i)
}

//Exceptions
fun expfun(input:String){
    fun parseInt(i:String) = 7
    val a: Int? = try { parseInt(input) } catch (e: NumberFormatException) { null }
}

// Default arguments
fun defaultFun(b: Array<Byte>, off: Int = 0, len: Int = b.size) { }

// Named arguments
fun namedArgsFun(str:String){
    fun reformat(str: String,
                 normalizeCase: Boolean = true,
                 upperCaseFirstLetter: Boolean = true,
                 divideByCamelHumps: Boolean = false,
                 wordSeparator: Char = ' ') {
    }
    reformat(str, wordSeparator = '_')
}

// Inline functions
//inline fun <T> lock(lock: java.util.concurrent.locks.Lock, body: () -> T): T { return T}

//Infix calls

// Extension functions
fun extensionFun(){
    open class D { }

    class D1 : D() { }

    open class C {
        open fun D.foo() {
            println("D.foo in C")
        }

        open fun D1.foo() {
            println("D1.foo in C")
        }

        fun caller(d: D) {
            d.foo()   // call the extension function
        }
    }
}

// Local functions
fun localFun(){
    fun mylocal(s:String){
        println(" s is ${s}")
    }
    mylocal("Hello")
}

//Triple quoted strings
fun tripleStringFun(){
    val sss = """This is a
        |multiline string
    """.trimMargin()
}

// String interpolation
fun stringFun(){
    val i = 10
    println("The value of i is ${i}")
}

// classes
data class Person (val firstName: String, val age:Int) { }
class Person1(firstName: String) { } //If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted:
class Person2(val firstName: String, val lastName: String, var age: Int) {}
class Person4(val name: String) {
    constructor(name: String, parent: Person) : this(name) {
    }
}

// interfaces
interface MyInterface {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
}

// final and public (Default for declarations)
// open
/* classes are final in kotlin use open if you want to create subclasses.
open class can be inherited.
open fun can be overridden
val property is final field in java
 */

// internal
//Visibility limited to the kotlin module

// inner
// In kotlin inner classes are static inner classes unless qualified by the inner keyword.

//sealed
/*
To declare a sealed class, you put the sealed modifier before the name of the class.
A sealed class can have subclasses, but all of them must be declared in the same file as the sealed class itself.
 */
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

// Initializer block
//init {
//    /* You can define those blocks anywhere at the top level of a class declaration, and they will be executed as part of class construction.
//    You can even define more than one initializer block if you want, and they will all be executed.
//First, default constructor arguments are evaluated, starting with argument to the constructor you call directly, followed by arguments to any
//delegated constructors. Next, initializers (property initializers and init blocks) are executed in the order that they are defined in the class,
//top-to-bottom. Finally, constructors are executed, starting with the primary constructor and moving outward through delegated constructors until
//the constructor that you called is executed.
//    */
//}

//field  (under the hood storage for a property)
class User{
    var firstName : String = ""
        get() = field
        set(value) {field = value}

    var lastName : String = ""
        get() = field
        set(value) {field = value}


}

//data classes
data class Users(val name: String = "", val age: Int = 0)

// object (Singletons)
//object DefaultListener : MouseAdapter() {
//    override fun mouseClicked(e: MouseEvent) { }
//
//    override fun mouseEntered(e: MouseEvent) { }
//}
// companion object
class A {
    companion object {
        fun bar() {
            println("Companion object called")
        } }
}
//>>> A.bar()
//Companion object called

// it
//collection.forEach { println(it)}

// filter, map, all, any

// sequences
fun sequenceFun(){
    val people = listOf(Person("Alice", 31), Person("Bob", 29), Person("Carol", 31))
    people.asSequence()
            .map(Person::firstName)
            .filter { it.startsWith("A") }
            .toList()
}


// with
fun alphabet(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!")
        this.toString()
    }
}

// apply
fun alphabet1() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

// let
////The let function will be called only if the email value is non-null, so you use the email as a non-null argument of the lambda:
//email?.let { email -> sendEmailTo(email) }
//    //or more consicely
//email?.let { sendEmailTo(it) }


// ?


// ?:
//val t: String = s ?: ""  //(If “s” is null, the result is an empty string.)

// !!
fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

// Unit

// Nothing

// Lambda functions

fun testLambda(){
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.maxBy({ p: Person -> p.age })
}


// Higher order functions
fun higherOrderFun() {
    val sum = { x: Int, y: Int -> x + y }
    val action = {
        println(42)
    }

}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}