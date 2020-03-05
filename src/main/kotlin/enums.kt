
enum class COLOR{
    RED,
    GREEN,
    BLUE,
    YELLOW
}

enum class COLOR1(val value: Int){
    RED(-1),
    GREEN(4),
    BLUE(6),
    YELLOW(7)
}

fun main(args: Array<String>) {
    val color = COLOR.BLUE
    val color1 = COLOR1.BLUE
    println("color : " + color.name)
    println("color : " + color.ordinal)
    println("color : " + color)
    println("color1 : " + color1.name)
    println("color1 : " + color1.ordinal)
    println("color1 : " + color1.value)  //6
    println("color1 : " + COLOR1.YELLOW.name)
    println("color1 : " + COLOR1.YELLOW.value)
}