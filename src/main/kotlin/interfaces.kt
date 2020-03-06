
interface CustomerRepo{
    val isEmpty: Boolean  //Cannot initialize properties in interfaces. Interfaces cannot maintain state.

    val isRich:Boolean // Properties can have getters
    get() {return true}

    fun store(obj:Customer){

    }
    fun getById():Customer
}

class SQLCustomerRepo:CustomerRepo{
    override val isEmpty: Boolean // Define isEmpty property in the concreteclass.
        get() = TODO("Not yet implemented")

    override fun getById(): Customer {
        TODO("Not yet implemented")
    }

    override fun store(obj: Customer) { // Override non-abstract method in an interface.
        super.store(obj)
    }

}

// Implements two interfaces with the same method
interface If1{
    fun funA(){
        println("funA from If1")
    }
}

interface If2{
    fun funA(){
        println("funA from If2")
    }
}

// Create a class that implements If1 and If2.
class Class1and2:If1,If2{
    override fun funA() {
        super<If1>.funA() // To resolve ambiguity specify the exact interface for funA call.
        println("In funA of Class1and2")
    }
}

fun main(args: Array<String>) {
    val c1 = Class1and2()
    c1.funA() // Calls funA from Class1and2 without ambiguity since we provided just one implementation.
    println("END")
}
