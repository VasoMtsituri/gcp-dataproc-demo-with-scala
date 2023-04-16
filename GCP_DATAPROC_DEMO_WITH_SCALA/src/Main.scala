package src

import org.apache.spark.sql.SparkSession
object Main extends App{
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample")
    .getOrCreate();

  val filePath = "/home/vaso/Downloads/nyc_tlc_yellow_trips_2018_subset_1.csv"
  val fileRDD = spark.sparkContext.textFile(filePath)

  println("Number of rows: " + fileRDD.count())

  fileRDD.take(20).foreach(println)
}