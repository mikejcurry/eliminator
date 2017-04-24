
object Eliminator {

  private def findSurvivorPositionInternal(n: Int, k: Int): Int = {
    (n, k) match {
      case (_, k) if k == 1 => n - 1  // minor optimization - when step size is one, last is the survivor (zero based)
      case (n, _) if n == 1 => 0
      case _ if n < k => (findSurvivorPositionInternal(n - 1, k) + k) % n
      case _ => {                                 // k <= n AND k != 1
        val n_prime = n - (n / k)

        /* todo: math.abs is wrong here. New tests written show incorrect results here..*/
        k * (Math.abs(findSurvivorPositionInternal(n_prime, k) - (n % k)) % n_prime) / (k - 1)
      }
    }
  }

  /* The recursive algorithm is zero index based, so to find the actual position we just need to add 1 to calculated value. */
  def findSurvivorPosition(n: Int, k: Int): Int = findSurvivorPositionInternal(n, k) + 1

  def main(args: Array[String]): Unit = {

    if (args.length != 2) {
      throw new IllegalArgumentException("Please provide n (the number of people in the circle) and k (the number of steps between eliminations)")
    }

    val n = args(0).toInt
    val k = args(1).toInt

    if (n < 1 || k < 1) {
      throw new IllegalArgumentException("n and k must be postitive integers")
    }

    println(findSurvivorPositionInternal(n, k) + 1)
  }
}