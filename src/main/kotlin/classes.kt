

class AirPlane  //A very simple class

class Customer{
    val id = 7  //This is a immutable property
    var name = "john" //This is a mutable property
}

class Person(firstName_:String, lastName_:String){
    val firstName = firstName_
    var lastName = lastName_
}

class NewPerson(val firstName:String, var lastName:String)  //2 properties. one read-only and one read-write.

class NewPerson1(val firstName:String, var lastName:String){ //2 properties. one read-only and one read-write.
    init {
        lastName = lastName.toUpperCase() // Update property in init. init called after construction.
    }
}

fun main(args: Array<String>) {
    val customer = Customer()
    println("Name : " + customer.name)
    customer.name = "Doe"
    println("Name : " + customer.name)
}