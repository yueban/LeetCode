package com.yueban.string

object MinimumWindowSubstring {
  /**
   * brutal way to solve the problem, use a slide window to search s.
   * every time moving the window, determine if all the characters of t are covered in window.
   * keep recording the minimum window.
   */
  fun minimumWindowSubstring1(s: String, t: String): String {
    val tCharsCount = mutableMapOf<Char, Int>()
    t.forEach {
      if (tCharsCount.containsKey(it)) {
        tCharsCount[it] = tCharsCount[it]!! + 1
      } else {
        tCharsCount[it] = 1
      }
    }

    var l = 0
    var resultLength = Int.MAX_VALUE
    var result = ""

    for (i in 0 until s.length) {
      if (tCharsCount.containsKey(s[i])) {
        tCharsCount[s[i]] = tCharsCount[s[i]]!! - 1
      }
      if (tCharsCount.all { it.value <= 0 }) {
        while (!tCharsCount.containsKey(s[l]) || (tCharsCount[s[l]] ?: 0) < 0) {
          if (tCharsCount.containsKey(s[l])) {
            tCharsCount[s[l]] = tCharsCount[s[l]]!! + 1
          }
          l++
        }
        if (i - l + 1 < resultLength) {
          result = s.substring(l, i + 1)
          resultLength = i - l + 1
        }
      }
    }

    return result
  }

  fun minimumWindowSubstring2(s: String, t: String): String {
    val tCharsCount = IntArray(128)
    // counting t chars
    t.forEach { tCharsCount[it.code]++ }

    var resultStart = 0
    var resultMinLength = Int.MAX_VALUE
    var l = 0
    var r = 0
    var tLength = t.length

    // iterate chars in s
    while (r < s.length) {
      val rightChar = s[r]
      tCharsCount[rightChar.code]--
      // only chars in t string can be >= 0 after previous line (decrease count of char)
      // any other chars that not in t string, their initial value in tCharCount is 0, and should be negative after previous line.
      if (tCharsCount[rightChar.code] >= 0) {
        tLength--
      }

      // tLength == 0 means all chars in t can be covered by current window (l,r), now we move l pointer
      while (tLength == 0) {
        val size = r - l + 1
        if (size < resultMinLength) {
          resultMinLength = size
          resultStart = l
        }

        val leftChar = s[l]
        tCharsCount[leftChar.code]++
        // only chars in t string can be > 0 after previous line (increase count of char)
        // any other chars that not in t string, their initial value in tCharCount is 0, and we decrease their count value
        // in outer loop (tCharsCount[rightChar.code]--). so after we increase their count value here, the result count
        // can only be <= 0 (0 is their initial value).
        if (tCharsCount[leftChar.code] > 0) {
          tLength++
        }

        l++
      }

      r++
    }

    return if (resultMinLength == Int.MAX_VALUE) "" else s.substring(resultStart, resultStart + resultMinLength)
  }
}
