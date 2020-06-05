package esgi.exo.FootballApp

import org.apache.spark.sql.SparkSession

object ProgrammingGuideSQL {

  def runCode() = {

    val spark = SparkSession.builder().appName("temp1").master("local").getOrCreate()
    import spark.sqlContext.implicits._

    val df = spark.read.json(Config.matchesPath)
    df.show()
    df.printSchema()
    df.select("adversaire").show()
    df.select($"adversaire", $"X2" + 1).show()
    df.filter($"X2" > 21).show()
    df.groupBy("X2").count().show()

    df.createOrReplaceTempView("matches")
    val sqlDF = spark.sql("SELECT * FROM matches")
    sqlDF.show()

    spark.stop()
  }

}
