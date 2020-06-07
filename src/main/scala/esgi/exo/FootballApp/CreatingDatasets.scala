package esgi.exo.FootballApp

import org.apache.spark.sql.SparkSession

object CreatingDatasets {

  def runCode() = {

    val spark = SparkSession.builder().appName("temp1").master("local").getOrCreate()
    import spark.implicits._

    val caseClassDS = Seq(FootballApp(2, 32, 32, 32, ",kfk", 32, 32, 32, 32, "ll", "554", "d", 2)).toDS()
    caseClassDS.show()

    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.show()
    primitiveDS.map(_ + 1).collect()

    val matchesPath = spark.read.json(Config.matchesPath).as[FootballApp]
    matchesPath.show()

    spark.stop()

  }



}
