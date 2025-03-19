package com.yueban.string

import com.yueban.string.LongestRepeatingCharacterReplacement.longestRepeatingCharacterReplacement1
import com.yueban.string.LongestRepeatingCharacterReplacement.longestRepeatingCharacterReplacement2
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestRepeatingCharacterReplacementTest {
  private class TestCase(
    val s: String,
    val k: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase("ABAB", 2, 4),
    TestCase("AABABBA", 1, 4),
  )

  @Test
  fun longestRepeatingCharacterReplacement1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestRepeatingCharacterReplacement1(case.s, case.k))
    }
  }

  @Test
  fun longestRepeatingCharacterReplacement2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestRepeatingCharacterReplacement2(case.s, case.k))
    }
  }
}
