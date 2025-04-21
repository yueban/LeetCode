package com.yueban.string

import com.yueban.string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters1
import com.yueban.string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters2
import com.yueban.string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters3
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestSubstringWithoutRepeatingCharactersTest {
  private class TestCase(
    val s: String,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase("abcabcbb", 3),
    TestCase("bbbbb", 1),
    TestCase("pwwkew", 3),
  )

  @Test
  fun longestSubstringWithoutRepeatingCharacters1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestSubstringWithoutRepeatingCharacters1(case.s))
    }
  }

  @Test
  fun longestSubstringWithoutRepeatingCharacters2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestSubstringWithoutRepeatingCharacters2(case.s))
    }
  }

  @Test
  fun longestSubstringWithoutRepeatingCharacters3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestSubstringWithoutRepeatingCharacters3(case.s))
    }
  }
}
