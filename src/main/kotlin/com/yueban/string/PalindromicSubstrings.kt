package com.yueban.string

object PalindromicSubstrings {
  fun palindromicSubstrings1(s: String): Int {
    var result = 0

    for (i in 0 until s.length) {
      // s[i] is the center of the palindromic substring
      var step = 0
      while (i - step >= 0 && i + step <= s.length - 1 && s[i - step] == s[i + step]) {
        step++
        result++
      }

      // s[i],s[i+1] is the center of the palindromic substring
      step = 0
      while (i - step >= 0 && i + step + 1 <= s.length - 1 && s[i - step] == s[i + step + 1]) {
        step++
        result++
      }
    }

    return result
  }

  /**
   * basically same as [palindromicSubstrings1], but extract some common logic into palindromicSubstrings.
   */
  fun palindromicSubstrings2(s: String): Int {
    fun palindromicSubstrings(start: Int, end: Int): Int {
      var temp = 0
      var l = start
      var r = end
      while (l >= 0 && r <= s.length - 1 && s[l] == s[r]) {
        l--
        r++
        temp++
      }
      return temp
    }

    var result = 0

    for (i in 0 until s.length) {
      // s[i] is the center of the palindromic substring
      result += palindromicSubstrings(i, i)
      // s[i],s[i+1] is the center of the palindromic substring
      result += palindromicSubstrings(i, i + 1)
    }

    return result
  }
}
