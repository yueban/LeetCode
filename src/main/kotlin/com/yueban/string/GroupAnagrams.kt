package com.yueban.string

object GroupAnagrams {
  /**
   * counting charCount of the strs, group strs with same charCount.
   * bad performance on finding same strs because the IntArray comparison.
   */
  fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<IntArray, MutableList<String>>()

    strs.forEach { str ->
      val charCount = IntArray(26)
      str.forEach { char -> charCount[char - 'a']++ }
      val key = result.keys.find { it.contentEquals(charCount) }
      if (key != null) {
        result[key]!!.add(str)
      } else {
        result[charCount] = mutableListOf(str)
      }
    }

    return result.values.toList()
  }

  /**
   * sort every str by char sequence and use it as the key, group strs with same key.
   * better performance for key search, but with extra sorting step.
   */
  fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()

    strs.forEach { str ->
      val sortedStr = String(str.toCharArray().apply { sort() })
      result.getOrPut(sortedStr) { mutableListOf() }.add(str)
    }

    return result.values.toList()
  }

  /**
   * combine the ideas of [groupAnagrams1] and [groupAnagrams2], better performance for key search without sorting step.
   */
  fun groupAnagrams3(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()

    strs.forEach { str ->
      val charCount = CharArray(26)
      str.forEach { charCount[it - 'a']++ }
      val key = String(charCount)
      result.getOrPut(key) { mutableListOf() }.add(str)
    }

    return result.values.toList()
  }
}
