// Flow control

// If else
if (1 > 3) println("Impossible") else println("The world makes sense")

if (1 > 3){
  println("Impossible")
  println("Really?")
}
else {
  println("The world makes sense...")
  println("Still...")
}

val number = 3
number match {
  case 1 => println("One")
  case 2 => println("Two")
  case 3 => println("Three")
  case _ => println("The rest")
}


// Loops
for (x <- 1 to 5){
  val squared = x * x
  println(squared)
}

var x = 10
while (x >= 0){
  println(x)
  x-=1
}

x = 0
do { println(x); x+=1 } while (x <= 10)

// Expressions
{val x = 10; x + 20}

// Returns rightmost result of the expression
println({val x = 10; x + 20})