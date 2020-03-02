fun main(args: Array<String>) {
    var myString = "Hello"
    if(myString != "")
    {
        println("Not empty")
    }

    // Conditional are expressions that can return a value.
    val result =  if(myString != "") //if returns expression. Will return Unit of no retruns occur.
    {
       "Not empty"
    }else{
        "empty"
    }
    println("result : " + result)
    // You have to return the same types from if and else and the else condition is mandatory.

    when(result){ // When is like a case statement.
        is String -> print("is String")
        "value" -> print("value")
    }

    val res = when(result){ // When is like a case statement.
        is String -> "is String"
        "value" -> "value"
        else -> "def" // If using when in an expression, else is not optional.
    }
}

