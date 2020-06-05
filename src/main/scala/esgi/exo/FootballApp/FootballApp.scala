package esgi.exo.FootballApp

import org.apache.spark.sql.types._
import org.apache.spark
import org.apache.spark.sql.{Row, SQLContext, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat

case class FootballApp(
    var X2: Int,
    var X4: Int,
    var X5: Int,
    var X6: Int,
    var adversaire: String,
    var score_france: Int,
    var score_adversaire: Int,
    var penalty_france: Int,
    var penalty_adversaire: Int,
    var date: String,
    var year: String,
    var outcome: String,
    var no: Int
    ) {

    def getDataFromCSV(path: String) = {
        val spark = org.apache.spark.sql.SparkSession.builder
          .master("local")
          .appName("Spark CSV Reader")
          .getOrCreate;
        val df = spark.read
          .format("csv")
          .option("header", "true") //first line in file has headers
          .option("mode", "DROPMALFORMED")
          .load(path)
    }

    def UpdateDataHeader(Name: String, newName : String) = {
        val spark = SparkSession.builder().appName("temp1").master("local").getOrCreate()
        val df = spark.read.json(Config.matchesPath)
        df.show()
        df.printSchema()
        df.withColumnRenamed(Name, newName)
    }

    def SelectColumn(Name: String, newName : String) = {

        val spark = SparkSession.builder().appName("temp1").master("local").getOrCreate()
        import spark.sqlContext.implicits._

        val df = spark.read.json(Config.matchesPath)
        df.show()
        df.printSchema()
        df.select($"match", $"competition", $"adversaire", $"score_france", $"score_adversaire",
            $"penalty_france", $"penalty_adversaire", $"date").show()

    }


    def CompleteByZero(dataFrame: DataFrame) = {
        dataFrame.map(row => {
            val row1 = row.getAs[Column](1)
            val make = if (isnull(row1)) "0"
            Row(row(0),make,row(2))
        }).collect().foreach(println)

    }

    def FilterByDate(dataFrame: DataFrame) = {
        dataFrame.filter(dataFrame("date").gt(lit("1980-03-01")))
    }

}
