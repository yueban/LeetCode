package com.yueban.string

import com.yueban.string.LongestPalindromicSubstring.longestPalindromicSubstring1
import com.yueban.string.LongestPalindromicSubstring.longestPalindromicSubstring2

object LongestPalindromicSubstring {
  fun longestPalindromicSubstring1(s: String): String {
    var result = ""

    for (i in 0 until s.length) {
      // s[i] is the center of the palindromic substring
      var step = 0
      while (i - step >= 0 && i + step <= s.length - 1 && s[i - step] == s[i + step]) {
        step++
      }
      step--
      if (step * 2 + 1 > result.length) {
        result = s.substring(i - step, i + step + 1)
      }

      // s[i],s[i+1] is the center of the palindromic substring
      step = 0
      while (i - step >= 0 && i + 1 + step <= s.length - 1 && s[i - step] == s[i + 1 + step]) {
        step++
      }
      step--
      if (step * 2 + 2 > result.length) {
        result = s.substring(i - step, i + 2 + step)
      }
    }

    return result
  }

  /**
   * basically same as [longestPalindromicSubstring1] but extract some common logic into findLongestPalindromicSubstring.
   */
  fun longestPalindromicSubstring2(s: String): String {
    var result = ""

    fun findLongestPalindromicSubstring(start: Int, end: Int) {
      var l = start
      var r = end
      while (l >= 0 && r <= s.length - 1 && s[l] == s[r]) {
        l--
        r++
      }

      if (r - l - 1 > result.length) {
        result = s.substring(l + 1, r)
      }
    }

    for (i in 0 until s.length) {
      // s[i] is the center of the palindromic substring
      findLongestPalindromicSubstring(i, i)
      // s[i],s[i+1] is the center of the palindromic substring
      findLongestPalindromicSubstring(i, i + 1)
    }

    return result
  }

  /**
   * basically same as [longestPalindromicSubstring2] but use resultL and resultR pointer to reduce substring operations.
   */
  fun longestPalindromicSubstring3(s: String): String {
    var resultL = 0
    var resultR = 0

    fun findLongestPalindromicSubstring(start: Int, end: Int) {
      var l = start
      var r = end
      while (l >= 0 && r <= s.length - 1 && s[l] == s[r]) {
        l--
        r++
      }

      if (r - l - 1 > resultR - resultL) {
        resultL = l + 1
        resultR = r
      }
    }

    for (i in 0 until s.length) {
      // s[i] is the center of the palindromic substring
      findLongestPalindromicSubstring(i, i)
      // s[i],s[i+1] is the center of the palindromic substring
      findLongestPalindromicSubstring(i, i + 1)
    }

    return s.substring(resultL, resultR)
  }
}
