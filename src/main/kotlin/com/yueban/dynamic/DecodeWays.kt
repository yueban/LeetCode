package com.yueban.dynamic

object DecodeWays {
  /**
   * brutal way to solve the problem, O(2^n)
   */
  fun decodeWays1(s: String): Int {
    fun decodeWays(index: Int): Int {
      return if (s[index] != '0') {
        if (index == s.length - 1) {
          1
        } else {
          decodeWays(index + 1)
        }
      } else {
        0
      } + if (index < s.length - 1 && (s[index] == '1' || (s[index] == '2' && s[index + 1] <= '6'))) {
        if (index == s.length - 2) {
          1
        } else {
          decodeWays(index + 2)
        }
      } else {
        0
      }
    }

    return decodeWays(0)
  }

  fun decodeWays2(s: String): Int {
    val n = s.length
    if (n == 0) return 0

    val dp = IntArray(n + 1)
    dp[n] = 1

    for (i in n - 1 downTo 0) {
      if (s[i] == '0') {
        dp[i] = 0
      } else {
        dp[i] = dp[i + 1]
        if (i + 1 < n && (s[i] == '1' || (s[i] == '2' && s[i + 1] <= '6'))) {
          dp[i] += dp[i + 2]
        }
      }
    }

    return dp[0]
  }
}
