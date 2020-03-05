
enum class COLOR{
    RED,
    GREEN,
    BLUE,
    YELLOW
}

enum class COLOR1(val value: Int){
    RED(-1){
        override fun toString(): String {
            return "Minus 1"
        }
    },
    GREEN(4),
    BLUE(6),
    YELLOW(7)
}

enum class COLOR2(val value: Int){
    RED(-1){
        override fun text(): String {
            TODO("Not yet implemented")
        }

        override fun toString(): String {
            return "Minus 1"
        }
    },
    GREEN(4) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    },
    BLUE(6) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    },
    YELLOW(7) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    };  // This is the only place in Kotlin where a semicolon (;) is mandatory.

    abstract fun text():String // All instances above have to implement this abstract method.
}

fun main(args: Array<String>) {
    val color = COLOR.BLUE
    val color1 = COLOR1.BLUE
    val color2 = COLOR1.BLUE
    println("color : " + color.name)
    println("color : " + color.ordinal)
    println("color : " + color)
    println("color1 : " + color1.name)
    println("color1 : " + color1.ordinal)
    println("color1 : " + color1.value)  //6
    println("color1 : " + COLOR1.YELLOW.name)
    println("color1 : " + COLOR1.YELLOW.value)
    println("color2 : " + COLOR2.RED.text())
}