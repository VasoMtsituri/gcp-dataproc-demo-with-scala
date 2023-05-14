package dataproc.codelab

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

import scala.math.min

object minTempByStation {

  def parseCSVRow(row: String): (String, String, Float) = {
    val fields = row.split (",")

    val stationID = fields(0)
    val tempType = fields(1)
    val tempValue = fields(2).toFloat

    (stationID, tempType, tempValue)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("codelab").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "MinTempByStation")

    val lines = sc.textFile("tempsByStationID.csv")

    // User our parseCSVRow function to convert to (stationID, tempType, tempValue) tuples
    val rdd = lines.map(parseCSVRow)

    // Take only Min values from each station
    val minTemps = rdd.filter(x => x._2 == "TMIN")

    // Convert to (stationID, tempValue)
    val minTempsStations = minTemps.map(x => (x._1, x._3))

    // Reduce by StationID retaining th min temperature found
    val minTempsByStation = minTempsStations.reduceByKey((x, y) => min(x, y))

    val results = minTempsByStation.collect()

    for (result <- results.sorted){
      val stationID = result._1
      val temp = result._2
      val formattedTemp = f"$temp%.2f"
      println(s"$stationID min temp: $formattedTemp")
    }
  }
}
