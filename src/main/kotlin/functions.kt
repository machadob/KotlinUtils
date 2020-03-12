

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
val ff:(((Int, Int) -> Int), Int, Int) -> Int = {g, x:Int, y:Int -> g(x, y)} // Higher order function.
val gg:(((Int, Int) -> Int), Int, Int) -> Int = {sum, x:Int, y:Int -> sum(x, y)} // Higher order function.

fun main(args: Array<String>) {
    println(defParams(2))
    println(myAdd1(2, 3))
    println(myAdd(i = 8, j = 7)) //Named parameters
    printStrings("1")
    printStrings("1", "2")
    printStrings("1", "2", "4")
    println(f(7))
    println(g(4, 7))
    println(ff({x:Int, y:Int -> x*x + y*y},5,6)) // Invoke Higher order function.
    println(ff(::sum, 5, 6)) // Invoke Higher order function.
}