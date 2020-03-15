import java.lang.StringBuilder

class Database { // Define a helper class for demo later.
    fun commit() {
        println("Committing ......")
    }
}

fun myAdd(i:Int, j:Int) = i + j  //return type inferred. Single line function with no body.

fun myAdd1(i:Int, j:Int):Int{
    return i + j   //Return statement and type required if you use curly brackets to define a function.
}
//Default parameters
fun defParams(i:Int, j:Int=10):Int{
    return i + j
}

// Variable number of parameters using vararg.
fun printStrings(vararg strings:String){
    for(string in strings){
        println("string : " + string)
    }
}

//spread operator *
fun testPrintStrings(vararg strings:String){
    printStrings(*strings)  //Use the spread operator to pass vararg into another function.
}

val f = {x:Int -> x*x} // A function variable. Invoke this with f(<param>)  e.g. f(7) to get 49.

val g = {x:Int, y:Int -> x*x + y*y} // Funtion taking more then one parameter.

fun sum(x:Int, y:Int):Int = x + y
fun square(x:Int) = x*x
val ff:(((Int, Int) -> Int), Int, Int) -> Int = {g, x, y -> g(x, y)} // Higher order function.
val gg:(((Int, Int) -> Int), Int, Int) -> Int = {sum, x, y -> sum(x, y)} // Higher order function.
val hh:(((Int) -> Int), Int) -> Int = {op, x -> op(x)} // Higher order function.
fun unary(f1:(Int)->Int){} // Look at the usage of this function below.
fun unaryOp(x:Int, op:(Int)->Int){}

fun transaction(db:Database, code:()->Unit){
    try{
        code()
    }finally{
        db.commit()
    }
}

//Closure
fun myFun(){
    for(num in 1..10){
        println("Printing .........")
        unaryOp(10, {
            x->println(num)
            x*num
        })
    }
}

//Extension functions. To use extension functions in another file import the package containing the extension function.
// If you create an extension function identical (with the same name and signature) to a class function,
// the class function will take precedence. You can create one by changing the signature, e.g. different no of args.
fun String.hello(){
    println("I am a extended String")
}

fun String.decorate():String{ // Notice the this. It represents the object that is being operated upon.
    return this.split(" ").joinToString(" "){it.capitalize()}
}

fun String.decorate(arg:String):String{ // Extension functions can also take arguments.
    return (this.split(" ").joinToString(" "){it.capitalize()}) + arg
}

// Extension functions are not polymorphic. See example below and example calls in the main function.
open class Base
class Derived : Base()
fun Base.ext(){
    println("In Base extension method")
}
fun Derived.ext(){
    println("In Derived extension method")
}
//val myInstance:Base = Derived()
// myInstance.ext() // This prints "In Base extension method"

// Local functions. You cannot access local functions from outside it's scope.
// e.g. innerFun cannot be accessed outside outerFun
fun outerFun(i:Int):Int{
    val num = 4
    fun innerFun(j:Int):Int = num*j  // Local function. Access num which is in outer scope of innerFun.
    return innerFun(i)
}

// Infix functions. Only extension functions or member function with single parameters can be infix. See example call in main.
infix fun String.isEqualTo(s:String) = this == s

// Anonymous functions.
fun myOp(i:Int, operation: (Int) -> Int):Int {
    return operation(i)
}
fun anonTest(){ //Look in main for an example call.
    println(myOp(4, fun (x):Int{  // Anonymous functions can specify a return type which is not possible with lambdas.
        if (x <= 4) {
            return x * x // Anonymous functions allow more than one return point which is not possible with lambdas.
        } else {
            return 4 * x // Anonymous functions allow more than one return point which is not possible with lambdas.
        }

    })) // Pass anonymous function, instead of a lambda, to function myOp.
} //With anonymous function you can specify return types and also have multiple return points which
// is not possible with lambdas.

// Inline functions. Inlining will copy-paste the contents of the function at the point of call.
// Suggested only for higher order functions. You cannot store a reference to an inlined function is a variable.
inline fun myOps(i:Int, operation: (Int) -> Int):Int { // TODO: Explore the keyword noinline
    return operation(i)
}

// Local returns (returning from local lambdas) . Local returns are not allowed from functions that are inlined.
fun enclosingFunction(){
    val intList = 1..100
    intList.forEach{
        if(it >7){
            return@forEach // This (local return) only returns from the forEach loop instead of enclosingFunction,
            // sp it will execute the println.
        }
    }
    println("End of enclosingFunction()")
}
fun enclosingFunction1(){
    val intList = 1..100
    intList.forEach mylabel@ {// Custom label for a local return.
        if(it >7){
            return@mylabel // Use custom label for a local return.
        }
    }
    println("End of enclosingFunction1()")
}
// Tail recursion. For instructing compiler to use tail recursion use the key word 'tailrec' before the method.

// Operator overloading.
class MyVector(val p1:Int, val p2:Int){
    operator fun plus(v:MyVector):MyVector{ // Overload the '+' operator with the function 'plus'. Note: keyword operator.
        return MyVector(this.p1 + v.p1, this.p2 + v.p2)
    }
}
fun addVectorsTest(v1:MyVector, v2:MyVector):MyVector{
    return v1 + v2
}
// Operators as extension functions.
operator fun StringBuilder.plus(stringBuilder:StringBuilder){
    stringBuilder.forEach { this.append(it) }
}

// Lambda extensions. See the full example below and note how it leads to DSL like syntax in the testLambdaExtensions function.
class Request(val method:String, val query:String, val contentType:String)
class Response (var contents:String, var status:Status){
    fun status(status: Status.() -> Unit){

    }
}
class Status(var code:Int, var description:String)
class RouteHandler(val request: Request, val response: Response){
    var executeNext = false
    fun next(){
        executeNext = true
    }
}
fun response(response: Response.() -> Unit){}
fun routeHandler(path:String, f:RouteHandler.() -> Unit): RouteHandler.() -> Unit = f
fun testLambdaExtensions(){
    routeHandler("index.html"){
        if(request.query != ""){
            //Process
        }
        response{
            status{
                code = 404
                description = "Not found"
            }
        }
    }
}

fun main(args: Array<String>) {
    println(defParams(2))
    println(myAdd1(2, 3))
    println(myAdd(i = 8, j = 7)) //Named parameters
    printStrings("1")
    printStrings("1", "2")
    printStrings("1", "2", "4")
    println(f(7))
    println(g(4, 7))
    println(ff({x, y -> x*x + y*y},5,6)) // Invoke Higher order function. Types for x and y are inferred.
    println(ff(::sum, 5, 6)) // Invoke Higher order function.
    println(hh({it*it}, 7)) // Use implicit it argument.
    unary {// Look at this. This pattern is used for writing DSLs.
        it*it
    }
    unaryOp(4, fun(x:Int):Int{return x*x}) // Anonymous function pattern. Used in DSLs.
    val db = Database()
    transaction(db){ // This is again a DSL pattern. Notice the second closure argument outside the brackets.
        //Execute code here. Exception and Resource handling will be taken care of in the transaction function.
    }
    myFun() //This demonstrates a Closure.
    "test".hello()
    println("this is a test of a decorated string".decorate())
    println("this is a yet another test of a decorated string".decorate(".......Arg"))
    val myInstance:Base = Derived()
    myInstance.ext()
    val myInstance1 = Derived()
    myInstance1.ext()
    println("outerFun(7) ${outerFun(7)}")
    val testResult = "Test"
    println(testResult isEqualTo "Test") // Call extension function with infix notation.
    anonTest(); // Test anonymous function.
}