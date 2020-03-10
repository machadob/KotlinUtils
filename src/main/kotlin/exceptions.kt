import java.lang.Exception
import java.sql.SQLException

fun main(args: Array<String>) {
// Kotlin does not have checked exceptions.
// try blocks are expressions as shown below:
    val retVal = try{
        1 // This is the value assigned to retVal if there are no exceptions thrown.
    }catch(exp: SQLException){
        2 // This is the value assigned to retVal if in case of a SQLException.
    }catch(exp:Exception){
        3// This is the value assigned to retVal if in case of a Exception.
    }finally {
        //Close resources etc.
        4 // This is the value assigned to retVal from finally.
    }
    println("retVal : $retVal")
}
