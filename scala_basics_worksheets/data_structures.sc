// Data structures

// Tuples
// Immutable lists
val captainStuff = ("Picard", "Some", "foo")
println(captainStuff)

// Refer to individual fields with ONE-BASED index
println(captainStuff._1)
println(captainStuff._2)
println(captainStuff._3)

// Key-Value like structure mapping in Scala
val picardShip = "Picard" -> "Enterprise-D"
println(picardShip._1)
println(picardShip._2)

// Under tuple, there can be mixed types
val aBunchOfStuff = ("Kirk", 1964, true)


//Lists
// Like a tuple, but more functionality
// Must be the same type

val shipList = List("Enterprise", "Defiant", "Voyager")

// Lists are ZERO-BASED index
println(shipList(0))
println(shipList(1))

//Take very first element and print
println(shipList.head)

//Take every element in list, except first one, and print
println(shipList.tail)