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

//Extension functions.
fun String.hello(){
    println("I am a extended String")
}

fun String.decorate():String{ // Notice the this. It represents the object that is being operated upon.
    return this.split(" ").joinToString(" "){it.capitalize()}
}

fun String.decorate(arg:String):String{ // Extension functions can also take arguments.
    return (this.split(" ").joinToString(" "){it.capitalize()}) + arg
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
}