package dataproc.codelab

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object CountOccUsingFlatMapBetter {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("codelab").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "CountOccUsingFlatMap")

    val lines = sc.textFile("lorem_ipsum.txt")

    // Split into words separated by appropriate regex this time
    val words = lines.flatMap(x => x.split("\\W+"))

    val allLowerWords = words.map(x => x.toLowerCase())

    val wordCounts = allLowerWords.countByValue()

    wordCounts.foreach(println)
  }
}
