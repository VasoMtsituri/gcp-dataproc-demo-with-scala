package dataproc.codelab

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object CountOccUsingFlatMap {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("codelab").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "CountOccUsingFlatMap")

    val lines = sc.textFile("lorem_ipsum.txt")

    // Split into words separated by a space character
    // Note, using map() for this operation gives us the following
    // error: "Cannot use map-side combining with array keys"
    val words = lines.flatMap(x => x.split(" "))

    val wordCounts = words.countByValue()

    wordCounts.foreach(println)

  }
}
