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

// Apply reverse function to all the element in List using map
// Let's see if {} is necessary in map function on the right side
// because it works well, too without it, so...?
val reversedShipList = shipList.map((ship: String) => {ship.reverse})

for (ship <- reversedShipList){
  println(ship)
}


// reduce() to combine together all the items in a collection using some function
val numberList = List(1, 2, 3, 4, 5)
val sum = numberList.reduce((x: Int, y: Int) => x + y)

// But here we can simplify this is the following
val sumAlt = numberList.sum

// Just make sure we are doing such things right
println(s"Sum using reduce(): $sum")
println(s"Sum using sum builtin of List: $sumAlt")

// Now try to filter out some values using filter()
val iHateFives = numberList.filter((x: Int) => x != 5)
print(iHateFives)
// We can do filtering in another way using placeholder, like underscore

val iHateThrees = numberList.filter(_ != 3)
print(iHateThrees)

// Concatenate List using double plus operator (++)
val moreNumbers = List(6, 7, 8)
val bunchOfNumber = numberList ++ moreNumbers

//Some operations on List
val reversed = bunchOfNumber.reverse
val sorted = bunchOfNumber.sorted
val duplicatedList = numberList ++ numberList
val onlyUniques = duplicatedList.distinct
val maxValueInList = bunchOfNumber.max
// As mentioned above, we can use sum instead of reduce(), which will sum up all the numbers in the List
val total = numberList.sum
// Check if particular number is in the List (contains)
val hasThree = numberList.contains(3)

//Let's talk about MAPS
val numbersMap = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

print(numbersMap)

println(numbersMap(1))
println(numbersMap.contains(2))

//But what if the key does not exist at all and we try to get it?
//Here utils Try exception handling comes into play
val numberFour = util.Try(numbersMap(4)) getOrElse "Spelling of 4 is unknown"
println(numberFour)