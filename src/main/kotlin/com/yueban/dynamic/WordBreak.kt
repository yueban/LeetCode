package com.yueban.dynamic

object WordBreak {
  fun wordBreak1(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1)
    dp[0] = true
    for (i in 1..s.length) {
      for (w in wordDict) {
        if (i >= w.length && dp[i - w.length] && s.subSequence(i - w.length, i) == w) {
          dp[i] = true
          break
        }
      }
    }
    return dp[s.length]
  }

  fun wordBreak2(s: String, wordDict: List<String>): Boolean {
    fun dfs(s: String, dp: IntArray, start: Int, wordDict: MutableSet<String>): Boolean {
      if (start == s.length) {
        return true
      }

      if (dp[start] != -1) {
        return dp[start] == 1
      }

      for (end in start + 1..s.length) {
        if (s.substring(start, end) in wordDict && dfs(s, dp, end, wordDict)) {
          dp[start] = 1
          return true
        }
      }

      dp[start] = 0
      return false
    }

    val n = s.length
    val dp = IntArray(n) { -1 }

    return dfs(s, dp, 0, wordDict.toMutableSet())
  }
}
