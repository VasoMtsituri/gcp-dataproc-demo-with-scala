package src

import scala.util.Random
object RandomValueGenerator extends App{
  def generateRandomNumbers(n: Int): Seq[Int] = {
    val randomNumbers = Seq.fill(n)(Random.nextInt)

    return randomNumbers
//    Use lazy evaluation approach for generating random numbers
//    val stream = LazyList.continually(Random.nextInt())
//    return stream.take(5).toList
  }

  val n = 10
  print(generateRandomNumbers(n=n))
}
