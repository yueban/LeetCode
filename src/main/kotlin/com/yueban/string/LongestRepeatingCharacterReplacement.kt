package com.yueban.string

import com.yueban.string.LongestRepeatingCharacterReplacement.longestRepeatingCharacterReplacement1
import kotlin.math.max

object LongestRepeatingCharacterReplacement {
  fun longestRepeatingCharacterReplacement1(s: String, k: Int): Int {
    val charCount = IntArray(26) { 0 }
    var l = 0
    var result = 0

    var r = 0
    while (r < s.length) {
      // current char count +1
      charCount[s[r] - 'A']++
      // preserve the most frequent chars, convert all other chars to the most frequent char,
      // there are at most k other chars can be converted.
      val currentLength = r - l + 1
      // current substring s[l,r] is valid, make r++
      if (currentLength - charCount.max() - k <= 0) {
        result = max(result, currentLength)
        r++
      } else {
        // current substring s[l,r] is invalid, make l++
        charCount[s[l] - 'A']--
        l++
        // undo `charCount[s[r] - 'A']++`
        charCount[s[r] - 'A']--
      }
    }

    return result
  }

  /**
   * At each iteration step, the "Longest Repeating Character Replacement" is (k + max frequent char count) in current slide window.
   * So we can simplify the problem to finding max frequent char count in all slide windows.
   * Then at each iteration step, if (currentLength - max frequent char count > k), we can simply move l pointer + 1.
   *
   * Basically same as [longestRepeatingCharacterReplacement1], but simplify the way to calculate maxFrequentChars and move l pointer.
   */
  fun longestRepeatingCharacterReplacement2(s: String, k: Int): Int {
    val charCount = IntArray(26)
    var l = 0
    var maxFrequentChars = 0
    var result = 0

    for (i in 0 until s.length) {
      maxFrequentChars = max(maxFrequentChars, ++charCount[s[i] - 'A'])
      while (i - l + 1 - maxFrequentChars > k) {
        charCount[s[l] - 'A']--
        l++
      }
      result = max(result, i - l + 1)
    }

    return result
  }
}
