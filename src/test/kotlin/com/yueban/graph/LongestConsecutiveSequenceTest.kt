package com.yueban.graph

import com.yueban.graph.LongestConsecutiveSequence.longestConsecutiveSequence1
import com.yueban.graph.LongestConsecutiveSequence.longestConsecutiveSequence2
import kotlin.test.Test
import kotlin.test.assertEquals

class LongestConsecutiveSequenceTest {
  private class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(100, 4, 200, 1, 3, 2), 4),
    TestCase(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9),
    TestCase(intArrayOf(1, 0, 1, 2), 3),
  )

  @Test
  fun longestConsecutiveSequence1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestConsecutiveSequence1(case.nums))
    }
  }

  @Test
  fun longestConsecutiveSequence2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, longestConsecutiveSequence2(case.nums))
    }
  }
}
