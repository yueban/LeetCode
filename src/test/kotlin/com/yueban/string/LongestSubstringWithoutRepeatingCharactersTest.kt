package com.yueban.string

import com.yueban.string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters1
import com.yueban.string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharacters2
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
    TestCase(" ", 1),
    TestCase("abcdaefg", 7),
    TestCase("au", 2),
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
}
