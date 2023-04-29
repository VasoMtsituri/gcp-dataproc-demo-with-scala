// VALUES are immutable constants
val hello: String = "Hello"

// VARIABLES are mutable
var helloThere: String = hello
helloThere = hello + " There!"
println(helloThere)

// We can also create value like this way (as one liner)
val immutableHelloThere = hello + " There"
println(immutableHelloThere)

// Data types
val numberOne: Int = 1
val truth: Boolean = true
val letterA: Char = 'a'
val pi: Double = 3.14159265
val piSinglePrecision: Float = 14159265f
val bigNumber: Long = 123456789
val smallNumber: Byte = 127

println("Here is a big mess: " + numberOne + truth + letterA + piSinglePrecision)

println(f"PI is about $piSinglePrecision%.3f")

println(f"Zero padding on the left: $numberOne%05d")

println(s"I can use the s prefix to use variables like: $numberOne $truth $piSinglePrecision")
println(s"I can use the s prefix to eval expressions like: ${1+2}")

val regexString: String = "We are learning Scala major version 2."
val pattern = """.* ([\d]+).*""".r
val pattern(answerStr) = regexString

val answer = answerStr.toInt
println(answer)

// Booleans

val isGreater = 1 > 2
val isLesser = 1 < 2

// This is a bitwise operator &
val impossible = isGreater & isLesser

// This is a logical operator &&
val anotherWay = isGreater & isLesser

val picard: String = "Picard"
val bestCaptain: String = "Picard"

// Comparison is done by comparing values itself, not memory addresses
// So this evaluates true
val isBest: Boolean = picard == bestCaptain