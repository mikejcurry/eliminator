import org.scalatest.{FlatSpec, Matchers}
import Eliminator._

class EliminatorTest extends FlatSpec with Matchers {

  "findSurvivorPosition" should "find the correct position for integers when n is greater than k" in {
    findSurvivorPosition(5, 2) shouldEqual 3
  }

  "findSurvivorPosition" should "find the correct position for integers when n is less than k" in {
    findSurvivorPosition(2, 5) shouldEqual 2
  }

  "findSurvivorPosition" should "find the correct position for integers when n is equal to k" in {
    findSurvivorPosition(2, 2) shouldEqual 1
  }

  "findSurvivorPosition" should "calculate for n = 3 and k = 2" in {
    findSurvivorPosition(3, 2) shouldEqual 3
  }

  "findSurvivorPosition" should "always be the highest index when k = 1" in {
    findSurvivorPosition(100001, 1) shouldEqual (100001)
  }

  "findSurvivorPosition" should "be capable of calculating for large numbers" in {
    // this test just verifies that there is no crash at large numbers such as Int.MaxValue
    // A better test will be to ensure that this is the correct value.
    findSurvivorPosition(Int.MaxValue, 53)
  }

  "findSurvivorPosition" should "pass a variety of tests" in {
    findSurvivorPosition(9, 4) shouldEqual 1
    findSurvivorPosition(10, 3) shouldEqual 4
    findSurvivorPosition(7, 4) shouldEqual 2
    findSurvivorPosition(6, 5) shouldEqual 1
    findSurvivorPosition(7, 3) shouldEqual 4
  }

  "findSurvivorPosition" should "consistent with linear time algorithm results" in {
    findSurvivorPosition(9, 4) shouldEqual linearTimeAlgorithmVersion(9, 4) + 1
    findSurvivorPosition(10, 3) shouldEqual linearTimeAlgorithmVersion(10, 3) + 1
    findSurvivorPosition(6, 5) shouldEqual linearTimeAlgorithmVersion(6, 5) + 1
    findSurvivorPosition(500, 3) shouldEqual linearTimeAlgorithmVersion(500, 3) + 1
    findSurvivorPosition(750, 4) shouldEqual linearTimeAlgorithmVersion(750, 4) + 1
    findSurvivorPosition(750, 1000) shouldEqual linearTimeAlgorithmVersion(750, 1000) + 1
  }

  "main" should "raise an error for non numeric inputs" in {
    assertThrows[NumberFormatException] {
      main(Array("a", "b"))
    }
    assertThrows[NumberFormatException] {
      main(Array("a", "1"))
    }
    assertThrows[NumberFormatException] {
      main(Array("1", "b"))
    }
  }

  "main" should "raise an error for empty arguments" in {
    assertThrows[IllegalArgumentException] {
      main(Array())
    }
  }

  "main" should "raise an error for too many arguments" in {
    assertThrows[IllegalArgumentException] {
      main(Array("1", "2", "3"))
    }
  }

  "main" should "raise an error for too few arguments" in {
    assertThrows[IllegalArgumentException] {
      main(Array("1"))
    }
  }

  def linearTimeAlgorithmVersion(n: Int, k: Int): Int = n match {
    case 1 => 0
    case _ => (linearTimeAlgorithmVersion(n - 1, k) + k) % n
  }
}
