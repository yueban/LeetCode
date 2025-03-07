package com.yueban.dynamic

import com.yueban.dynamic.LongestIncreasingSubsequence.longestIncreasingSubsequence1
import com.yueban.dynamic.LongestIncreasingSubsequence.longestIncreasingSubsequence2
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestIncreasingSubsequenceTest {
  class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18), 4),
    TestCase(intArrayOf(0, 1, 0, 3, 2, 3), 4),
    TestCase(intArrayOf(7, 7, 7, 7, 7, 7, 7), 1),
  )

  @Test
  fun longestIncreasingSubsequence1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestIncreasingSubsequence1(case.nums))
    }
  }

  @Test
  fun longestIncreasingSubsequence2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestIncreasingSubsequence2(case.nums))
    }
  }
}
