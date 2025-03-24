package com.yueban.string

import com.yueban.string.PalindromicSubstrings.palindromicSubstrings1
import com.yueban.string.PalindromicSubstrings.palindromicSubstrings2
import kotlin.test.Test
import kotlin.test.assertEquals

class PalindromicSubstringsTest {
  private class TestCase(
    val s: String,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase("abc", 3),
    TestCase("aaa", 6),
  )

  @Test
  fun palindromicSubstrings1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, palindromicSubstrings1(case.s))
    }
  }

  @Test
  fun palindromicSubstrings2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, palindromicSubstrings2(case.s))
    }
  }
}
