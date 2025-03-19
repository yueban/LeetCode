package com.yueban.string

import com.yueban.string.MinimumWindowSubstring.minimumWindowSubstring1
import com.yueban.string.MinimumWindowSubstring.minimumWindowSubstring2
import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumWindowSubstringTest {
  private class TestCase(
    val s: String,
    val t: String,
    val result: String,
  )

  private val testCases = listOf(
    TestCase("ADOBECODEBANC", "ABC", "BANC"),
    TestCase("a", "a", "a"),
    TestCase("a", "aa", ""),
  )

  @Test
  fun minimumWindowSubstring1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, minimumWindowSubstring1(case.s, case.t))
    }
  }

  @Test
  fun minimumWindowSubstring2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, minimumWindowSubstring2(case.s, case.t))
    }
  }
}
