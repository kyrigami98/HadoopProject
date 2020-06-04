package esgi.exo.FootballApp

import org.apache.spark.sql.types._
import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SQLContext

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("App Foot")

    val FootballApp1 = new FootballApp(2, 32, 32, 32, ",kfk", 32, 32, 32, 32, "ll", "554", "d", 2)
    println(FootballApp1.X2)  // prints (2, 3)
  }
}
