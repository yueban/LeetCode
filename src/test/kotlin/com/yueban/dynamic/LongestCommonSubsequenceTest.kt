package com.yueban.dynamic

import com.yueban.dynamic.LongestCommonSubsequence.longestCommonSubsequence1
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestCommonSubsequenceTest {
  private class TestCase(
    val text1: String,
    val text2: String,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase("abcde", "ace", 3),
    TestCase("abc", "abc", 3),
    TestCase("abc", "def", 0),
  )

  @Test
  fun longestCommonSubsequence1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestCommonSubsequence1(case.text1, case.text2))
    }
  }
}
