package esgi.exo.FootballApp
import org.apache.spark.sql.types._
import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SQLContext

object Main {

  def main(args: Array[String]): Unit = {

    QuickStart.runCode()
    ProgrammingGuideSQL.runCode()
    CreatingDatasets.runCode()

  }

}
