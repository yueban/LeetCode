package com.yueban.dynamic

object DecodeWays {
  /**
   * brutal way to solve the problem, O(2^n). can be optimized by using a map cache (index, numberOfWays).
   */
  fun decodeWays1(s: String): Int {
    fun decodeWays(index: Int): Int {
      val pickOneLetter =
        if (s[index] != '0') {
          if (index == s.length - 1) {
            1
          } else {
            decodeWays(index + 1)
          }
        } else {
          0
        }

      val pickTwoLetters =
        if (index < s.length - 1 && (s[index] == '1' || (s[index] == '2' && s[index + 1] <= '6'))) {
          if (index == s.length - 2) {
            1
          } else {
            decodeWays(index + 2)
          }
        } else {
          0
        }

      return pickOneLetter + pickTwoLetters
    }

    return decodeWays(0)
  }

  /**
   * iterate from the end of string to start. `dp[i]` means the amount of ways to decode s till `s[i..n-1]`.
   * Specifically, dp[n] represents the initial value for accumulating which is `1` way.
   *
   * for every `s[i]`, there are three circumstances:
   *    1. `s[i]` is '0', so substring `s[i..n-1]` starts with '0', means there is no possible way to decode `s[i..n-1]`, so `dp[i]` = 0
   *    2. `s[i]` is not '0', we accumulate two options for `dp[i]`
   *      2.1 we pick one letter to decode, so `dp[i] += dp[i + 1]`
   *      2.2 we pick two letters **if possible** to decode, so `dp[i] += dp[i + 2]`
   */
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
