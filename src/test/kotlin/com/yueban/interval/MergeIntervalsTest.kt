package com.yueban.interval

import com.yueban.interval.MergeIntervals.mergeIntervals1
import kotlin.test.Test
import kotlin.test.assertTrue

class MergeIntervalsTest {
  class TestCase(
    val intervals: Array<IntArray>,
    val result: Array<IntArray>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
      arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    ),
    TestCase(
      arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
      arrayOf(intArrayOf(1, 5))
    ),
    TestCase(
      arrayOf(intArrayOf(1, 4), intArrayOf(0, 4)),
      arrayOf(intArrayOf(0, 4))
    )
  )

  @Test
  fun mergeIntervals1Test() {
    testCases.forEach { case ->
      assertTrue(case.result contentDeepEquals mergeIntervals1(case.intervals))
    }
  }
}
