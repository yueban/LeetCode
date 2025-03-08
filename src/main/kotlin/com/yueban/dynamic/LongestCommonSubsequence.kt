package com.yueban.dynamic

import kotlin.math.max

object LongestCommonSubsequence {
  fun longestCommonSubsequence1(text1: String, text2: String): Int {
    val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

    for (i in 1..text1.length) {
      for (j in 1..text2.length) {
        dp[i][j] = if (text1[i - 1] == text2[j - 1]) {
          dp[i - 1][j - 1] + 1
        } else {
          max(dp[i - 1][j], dp[i][j - 1])
        }
      }
    }

    return dp[text1.length][text2.length]
  }
}
