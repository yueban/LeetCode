package com.yueban.dynamic

object ClimbingStairs {
  fun climbingStairs1(n: Int): Int = when (n) {
    1 -> 1
    2 -> 2
    else -> climbingStairs1(n - 1) + climbingStairs1(n - 2)
  }

  fun climbingStairs2(n: Int): Int {
    val cacheSteps = mutableMapOf(1 to 1, 2 to 2)

    fun climbingStairs(n: Int): Int =
      cacheSteps[n] ?: (climbingStairs(n - 1) + climbingStairs(n - 2)).also { cacheSteps[n] = it }

    return climbingStairs(n)
  }

  /**
   * using array can get a better performance than map
   */
  fun climbingStairs3(n: Int): Int {
    val cacheSteps = IntArray(46)
    cacheSteps[0] = 0
    cacheSteps[1] = 1
    cacheSteps[2] = 2

    fun climbingStairs(n: Int): Int =
      cacheSteps[n].takeIf { it != 0 } ?: (climbingStairs(n - 1) + climbingStairs(n - 2)).also { cacheSteps[n] = it }

    return climbingStairs(n)
  }

  /**
   * ascend is better than descend because it can calculate the latter result by previous results
   */
  fun climbingStairs4(n: Int): Int {
    if (n <= 2) return n
    val cacheSteps = IntArray(n + 1)
    cacheSteps[0] = 0
    cacheSteps[1] = 1
    cacheSteps[2] = 2
    for (i in 3..n) {
      cacheSteps[i] = cacheSteps[i - 1] + cacheSteps[i - 2]
    }
    return cacheSteps[n]
  }
}
