// Exercise
// Write some code that prints the first 10 values of the fibonacci sequence.
// This is a sequence where every number is the sum of the two numbers before it.
// So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

var x = 0
var y = 1

var i = 0
while (i < 10)
{
  val previous = x
  println(previous)
  x = y
  y += previous
  i += 1
}