package dataproc.codelab

import java.io.{BufferedWriter, FileWriter}
import scala.collection.JavaConversions._
import org.apache.spark._
import org.apache.log4j._

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps
import scala.util.Random

import au.com.bytecode.opencsv.CSVWriter

object FriendsByAge {
  def parseLine(line: String): (Int, Int) = {

    val fields = line.split(",")

    val age = fields(2).toInt
    val numOfFriends = fields(3).toInt

    (age, numOfFriends)
  }

  def generateFakeSocNetData(outputFilePath: String, numOfRows: Int, maxAge: Int, maxNumOfFriends: Int): Unit = {
    val csvFields = Array("ID", "Name", "Age", "NumOfFriends")

    val rand = new Random

    val names = List("Joe", "John", "Jacob", "Brad", "Paul", "Laura", "Jenifer")
    val randomAges = Seq.fill(numOfRows)(Random.nextInt(maxAge))
    val randomNumOfFriends = Seq.fill(numOfRows)(Random.nextInt(maxNumOfFriends))

    var listOfRecords = new ListBuffer[Array[String]]()
    listOfRecords += csvFields
    for (i <- 1 to numOfRows) {
      listOfRecords += Array(i.toString, names(rand.nextInt(names.length)), randomAges(rand.nextInt(randomAges.length)).toString, randomNumOfFriends(rand.nextInt(randomNumOfFriends.length)).toString)
    }

    val outputFile = new BufferedWriter(new FileWriter(outputFilePath))
    val csvWriter = new CSVWriter(outputFile)

    csvWriter.writeAll(listOfRecords.toList)
    outputFile.close()
  }


  def main(args: Array[String]): Unit = {
    // generateFakeSocNetData(outputFilePath =  "1.csv", numOfRows = 10, maxAge = 80, maxNumOfFriends = 1000)

    Logger.getLogger("codelab").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "FriendsByAge")

    val lines = sc.textFile("1.csv")

    // User our parseLine function to convert to (age, numOfFriends) tuples
    val rdd = lines.map(parseLine)

    // We're starting with an RDD of form (age, numOfFriends) where age is the KEY and numOfFriends is the VALUE
    // We use mapValues to convert each numOfFriends value to tuple (numOfFriends, 1) then we use
    // reduceByKey to sum up the total numOfFriends and total instances for each age, by adding together all the
    // numOfFriends values and 1's respectively
    val totalsByAge = rdd.mapValues(x => (x, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))

    // So now we have tuples of (age, (totalFriends, totalInstances)).
    // To compute the average we divide totalFriends / totalInstances for each age
    val averageByAge = totalsByAge.mapValues(x => x._1 / x._2)

    val results = averageByAge.collect()

    results.sorted.foreach(println)
  }
}
