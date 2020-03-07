fun main(args: Array<String>) {
    val nullMessage: String? = null // nullable types have to be explicitly specified using a ? at the end of the type name.
    val inferredNull = null
    println(nullMessage?.length)  //Invoke method length only if nullMessage is not null
    println(nullMessage!!.length) //Invoke methond length assuming nullMessage is guaranteed to be non-null.
    //You can use ? in a sequence like customer?.address?houseNumber. This avoids nested null checks.
}
