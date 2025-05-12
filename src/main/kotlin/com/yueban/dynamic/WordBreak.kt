package com.yueban.dynamic

object WordBreak {
  /**
   * `dp[i]` represents if `s[0..i)` can be segmented by words.
   */
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

  /**
   * `dp[i]` represents if `s[0..i)` can be segmented by words.
   *    `dp[i] == -1` means idle state;
   *    `dp[i] == 0` means `s[0..i)` cannot be segmented by words;
   *    `dp[i] == 1` means `s[0..i)` can be segmented by words.
   */
  fun wordBreak2(s: String, wordDict: List<String>): Boolean {
    fun dfs(s: String, dp: IntArray, start: Int, wordDict: MutableSet<String>): Boolean {
      // start reaches s.length means the entire string has been successfully segmented
      if (start == s.length) {
        return true
      }

      // if the substring from start has been computed before, return the stored result
      if (dp[start] != -1) {
        return dp[start] == 1
      }

      for (end in start + 1..s.length) {
        if (s.substring(start, end) in wordDict && dfs(s, dp, end, wordDict)) {
          // mark the substring from start can be segmented
          dp[start] = 1
          return true
        }
      }

      // mark the substring from start cannot be segmented
      dp[start] = 0
      return false
    }

    val dp = IntArray(s.length) { -1 }

    return dfs(s, dp, 0, wordDict.toMutableSet())
  }
}
