package com.yueban.string

import com.yueban.string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters1
import kotlin.math.max

object LongestSubstringWithoutRepeatingCharacters {
  /**
   * use a slide window to track distinct chars. when iterating, check the position of `s[i]` appeared last time,
   * move `l` to make sure current window doesn't contain two `s[i]`, keep going to make sure current window doesn't
   * have repeating chars.
   */
  fun longestSubstringWithoutRepeatingCharacters1(s: String): Int {
    if (s.length <= 1) return s.length

    val map = mutableMapOf<Char, Int>()
    var result = 0
    var l = 0

    for (i in 0 until s.length) {
      val char = s[i]
      l = max(l, map.getOrDefault(char, -1) + 1)
      result = max(result, i - l + 1)
      map[s[i]] = i
    }

    return result
  }

  /**
   * basically same as [longestSubstringWithoutRepeatingCharacters1], but use array for a better performance.
   */
  fun longestSubstringWithoutRepeatingCharacters2(s: String): Int {
    if (s.length <= 1) return s.length

    // min value of Char.code is 32 which is space, max value of Char.code is 126 which is '~'
    val chars = IntArray(128) { -1 }
    var result = 0
    var l = 0

    for (i in 0 until s.length) {
      val char = s[i].code
      l = max(l, chars[char] + 1)
      result = max(result, i - l + 1)
      chars[char] = i
    }

    return result
  }
}
