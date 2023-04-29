// Exercise
// Create a list of the numbers 1-20; your job is to print out numbers that are
// evenly divisible by three. (Scala's modula operator, like other languages,
// is %, which gives you the remainder after division. Do this first by iterating
// all the items in the list and testing each one as you go. Then, do it again
// by using a filter function on the list instead

// I choose not to create list of numbers hardcoded, so here is better way:
val x = (1 to 20).toList

for (number <- x if number%3==0) println(number)

val onlyNumbersDivisibleByThree = x.filter(_%3 == 0)
println(onlyNumbersDivisibleByThree)