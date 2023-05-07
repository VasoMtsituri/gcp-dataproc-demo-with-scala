package dataproc.codelab

import java.io.{BufferedWriter, FileWriter}

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

  def generateFakeSocNetData(outputFilePath: String, numOfRows: Int, maxAge: Int, maxNumOfFriends: Int) = {
    val csvFields = Array("ID", "Name", "Age", "NumOfFriends")

    val rand = new Random

    val names = List("Joe", "John", "Jacob", "Brad", "Paul", "Laura", "Jenifer")
    val randomAges = Seq.fill(numOfRows)(Random.nextInt(maxAge))
    val randomNumOfFriends = Seq.fill(numOfRows)(Random.nextInt(maxNumOfFriends))

    var listOfRecords = new ListBuffer[Array[String]]()
    listOfRecords += csvFields
    for (i <- 1 to numOfRows) {
      listOfRecords += Array(i.toString, names(rand.nextInt(names.length)), randomAges(rand.nextInt(randomAges.length)).toString, randomNumOfFriends(rand.nextInt(randomNumOfFriends.length)))
    }

    val outputFile = new BufferedWriter(new FileWriter(outputFilePath))
    val csvWriter = new CSVWriter(outputFile)

    csvWriter.writeAll(listOfRecords.toList)
    outputFile.close()
  }

}
