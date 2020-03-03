

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

fun main(args: Array<String>) {
    println(defParams(2))
    println(myAdd1(2,3 ))
    println(myAdd(i=8, j=7)) //Named parameters
    printStrings("1")
    printStrings("1", "2")
    printStrings("1", "2", "4")
}