package src

import org.apache.spark.sql.SparkSession

object Main extends App {
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample")
    .getOrCreate();

  val filePath = "/home/vaso/Downloads/nyc_tlc_yellow_trips_2018_subset_1.csv"
  val fileRDD = spark.sparkContext.textFile(filePath)

  val header = fileRDD.first()

  val fileRDDWithoutHeader = fileRDD.filter(_ != header)

  println(header)

  val subsetOfNYCRides = fileRDDWithoutHeader.map(line => {
    val colArray = line.split(",")
    (colArray(0), colArray(2), colArray(3))
  }).take(10).foreach(println)
}