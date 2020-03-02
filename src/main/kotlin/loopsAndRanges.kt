fun main(args: Array<String>) {
    for(a:Int in 1..100){ // Type of a is explicitly stated. 1..100 is a Range.
        println(a)
    }

    for(a in 1..100){ // Type of a is inferred.
        println(a)
    }

    val numbers = 1..100
    for(num in numbers){
        println("num  : " + num)
    }

    for(a in 100 downTo 1){ //Reverse looping.
        println("Rev  : " + a)
    }

    for(a in 100..1){ //Reverse looping with the Range syntax.
        println("Rev_1  : " + a)
    }

    println((1..100).toList()) // Convert Range to List.

    for(b in 100 downTo 1 step 5){ // Loop in steps
        println("b  : " + b)
    }

    val animals = listOf("Dog", "Cat", "Dolphin", "Orca")
    for(animal in animals){
        println(animal)
    }

    var i = 10
    while(i>0){
        println(i);i--
    }

    loop@ for(i in 1..100){  //break and continue statements (with and without labels).
    loop2@    for(j in 1..100){
            if(j>50){
                break@loop
            }
            if(j==25){
                continue@loop
            }
            if(j==44){
                continue
            }
            if(j==47){
                continue@loop2
            }
        }
    }
}
