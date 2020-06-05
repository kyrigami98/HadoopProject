package esgi.exo.FootballApp
import org.apache.spark.sql.types._
import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SQLContext

object Main {

  def main(args: Array[String]): Unit = {

    println("App Foot")

    // New 2.0.+ API: create SparkSession and use it for all purposes:
    //val session = SparkSession.builder().appName("test").master("local").getOrCreate()
    //session.read.load("src/main/resources/df_matches.csv") // OK

   // val FootballApp1 = new FootballApp(2, 32, 32, 32, ",kfk", 32, 32, 32, 32, "ll", "554", "d", 2)
    // println(FootballApp1.X2)  // prints (2, 3)

    QuickStart.runCode()
    ProgrammingGuideSQL.runCode()
    CreatingDatasets.runCode()

  }

}
