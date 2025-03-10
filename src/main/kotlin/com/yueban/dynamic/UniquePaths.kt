package com.yueban.dynamic

object UniquePaths {
  /**
   * brutal way to solve the problem, O(2^n)
   */
  fun uniquePaths1(m: Int, n: Int): Int {

    fun uniquePaths(fromM: Int, fromN: Int): Int {
      if (fromM == m - 1 || fromN == n - 1) return 1
      return uniquePaths(fromM + 1, fromN) + uniquePaths(fromM, fromN + 1)
    }

    return uniquePaths(0, 0)
  }

  fun uniquePaths2(m: Int, n: Int): Int {
    val dp = Array(m) { IntArray(n) }

    for (i in 0..m - 1) {
      for (j in 0..n - 1) {
        dp[i][j] = when {
          i == 0 || j == 0 -> 1
          else -> dp[i - 1][j] + dp[i][j - 1]
        }
      }
    }

    return dp[m - 1][n - 1]
  }
}
