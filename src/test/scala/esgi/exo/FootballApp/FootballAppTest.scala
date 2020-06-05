package esgi.exo.FootballApp
import org.scalatest.FunSuite

import org.apache.spark.sql.DataFrame

class FootballAppTest {

  "A Unit test" should "have a readable Given" in {
    Given("A specific value on column 1")
    val inputDataFrame: DataFrame = List(
      TestRow(column1 = "specific value")
    ).toDF()

  }

}
