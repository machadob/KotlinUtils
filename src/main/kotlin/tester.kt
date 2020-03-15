package com.turf.test

fun main(args: Array<String>) {
    val testInvoke = TestInvoke()
    testInvoke()
}

class TestInvoke(){
    operator fun invoke(){
        println("In Invoke of class TestInvoke")
    }
}
