package com.burt.kotlin.functional

data class Person(val firstName: String, val lastName: String, val salary: Double)

fun main(args: Array<String>) {
    testFunc()
}

fun testFunc() {//Added in github.
    val persons = listOf<Person>(Person("Burton", "Machado", 1000000.0), Person("Ruth", "Machado", 2000000.0), Person("Shaun", "Machado", 4000000.0))
    val filtered = persons.filter { it.salary < 4000000.0 }
    println("*********** Printing Filtered ***********")
    filtered.forEach({ println(it) })
    println("------------------------------------------------")
    println("*********** Printing Mapped ***********")
    val mapped = persons.map { it.firstName + " : " + it.lastName }
    mapped.forEach({ println(it) })
    println("------------------------------------------------")
}
