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

  "findSurvivorPosition" should "calculate for large n with small k" in {
    findSurvivorPosition(Int.MaxValue, 2) shouldEqual 3
  }

  "findSurvivorPosition" should "calculate for n = 3 and k = 2" in {
    findSurvivorPosition(3, 2) shouldEqual 3
  }

  "findSurvivorPosition" should "always be the highest index when k = 1" in {
    findSurvivorPosition(100001, 1) shouldEqual (100001)
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
}
