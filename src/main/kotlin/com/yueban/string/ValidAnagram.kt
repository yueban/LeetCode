package com.yueban.string

object ValidAnagram {
  fun validAnagram1(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val charCount = IntArray(26)
    s.forEach { charCount[it - 'a']++ }
    t.forEach {
      if (charCount[it - 'a'] == 0) {
        return false
      }
      charCount[it - 'a']--
    }

    return charCount.all { it == 0 }
  }
}
