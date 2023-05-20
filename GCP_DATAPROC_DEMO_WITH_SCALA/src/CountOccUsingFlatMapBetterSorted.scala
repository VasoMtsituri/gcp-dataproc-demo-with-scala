package dataproc.codelab

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object CountOccUsingFlatMapBetterSorted {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("codelab").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "CountOccUsingFlatMapBetterSorted")

    val lines = sc.textFile("lorem_ipsum.txt")

    // Split into words separated by appropriate regex this time
    val words = lines.flatMap(x => x.split("\\W+"))

    val allLowerWords = words.map(x => x.toLowerCase())

    // Count of the occurrences of each word
    val wordCounts = allLowerWords.map(x => (x, 1)).reduceByKey( (x, y) => x + y )

    // Flip (word, count) tuples to (count, word) and then sort by Key (the counts)
    val wordCountsSorted = wordCounts.map(x => (x._2, x._1)).sortByKey()

    for (result <- wordCountsSorted){
      val count = result._1
      val word = result._2
      println(s"$word: $count")
    }
  }
}
