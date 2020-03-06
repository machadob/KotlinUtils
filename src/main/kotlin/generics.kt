
//Generics are similar to Java
interface Repository<T>{
    fun getById(id:Int):T
    fun getAll():List<T>
}

class CustomerRepository<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}

// Another way to implement generics. This time using generic methods.
// The class is more appropriate to implement this logic because we have the same generic type T.
// If the functions used different generic types like T and S then it would be justified.
interface Repo{
    fun<T> getById(id:Int):T
    fun<T> getAll(id:Int):List<T>
}

class MyRepo : Repo {
    override fun <T> getById(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun <T> getAll(id: Int): List<T> {
        TODO("Not yet implemented")
    }
}

fun main(args: Array<String>) {
 val customerRepo = CustomerRepository<Customer>()
    val customer = customerRepo.getById(1)
    val customers = customerRepo.getAll()
}
