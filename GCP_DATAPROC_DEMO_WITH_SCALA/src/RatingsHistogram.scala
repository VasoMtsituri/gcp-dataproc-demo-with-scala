package dataproc.codelab

import org.apache.spark._
import org.apache.log4j._


object RatingsHistogram {
  def main(args: Array[String]): Unit = {

      // Set the log level to only print errors
      Logger.getLogger("org").setLevel(Level.ERROR)

      // Create a SparkContext using every core of the local machine,
      // named RatingsCounter
      val sc = new SparkContext("local[*]", "RatingsCounter")

      //Load up each line of the ratings data into a RDD
      val lines = sc.textFile("/home/vaso/Downloads/Datasets/ratings.csv")

      // Take out first row (representing header) and have a rdd without it
      val header = lines.first()
      val linesWithoutHeader = lines.filter(_ != header)

      // Convert each line to a string, split it out by commas, and extract
      // the third field. The file format is userId, movieId, rating, timestamp
      val ratings = linesWithoutHeader.map(x => x.split(",")(2))

      // Count up how many times each value (rating) occurs
      val results = ratings.countByValue()

      // Sort the resulting map of (rating, count) tuples
      val sortedResults = results.toSeq.sortBy(_._1)

      // Print each result on itw own line
      sortedResults.foreach(println)
  }
}
