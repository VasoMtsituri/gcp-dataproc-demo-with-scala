// Exercise
// String have a built-in .toUpperCase method. For example, "foo".toUpperCase gives
// you back FOO. Write a function that converts a string to upper-case and use that
// function of a few test strings. Then, do the same thing using a function literal
// (so called, anonymous function or lambda function) instead of a separate, named
// function.

def toUpperWrapper(x: String): String = {
  x.toUpperCase()
}

val mars = "mars"
val upperMethodOfMars = toUpperWrapper(mars)
println(upperMethodOfMars)

// Some more examples
val jupiter = "jupiter"
println(toUpperWrapper(jupiter))


// Now let's use lambda function
def transformString(x: String, f: String => String): String = {
  f(x)
}

val earth = "earth"
val upperMethodLambdaEarth = transformString(earth, x => x.toUpperCase())
println(upperMethodLambdaEarth)

// Some more examples
println(transformString("venus", x => x.toUpperCase()))
println(transformString("pluto", x => x.toUpperCase()))