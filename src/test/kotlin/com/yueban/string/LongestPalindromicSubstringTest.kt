package com.yueban.string

import com.yueban.string.LongestPalindromicSubstring.longestPalindromicSubstring1
import com.yueban.string.LongestPalindromicSubstring.longestPalindromicSubstring2
import com.yueban.string.LongestPalindromicSubstring.longestPalindromicSubstring3
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestPalindromicSubstringTest {
  private class TestCase(
    val s: String,
    val result: String,
  )

  private val testCases = listOf(
    TestCase("babad", "bab"),
    TestCase("cbbd", "bb"),
    TestCase("a", "a"),
  )

  @Test
  fun longestPalindromicSubstring1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestPalindromicSubstring1(case.s))
    }
  }

  @Test
  fun longestPalindromicSubstring2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestPalindromicSubstring2(case.s))
    }
  }

  @Test
  fun longestPalindromicSubstring3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestPalindromicSubstring3(case.s))
    }
  }
}
