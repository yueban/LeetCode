package com.yueban.interval

import com.yueban.interval.InsertInterval.insertInterval1
import kotlin.test.Test
import kotlin.test.assertTrue

class InsertIntervalTest {
  class TestCase(
    val intervals: Array<IntArray>,
    val newInterval: IntArray,
    val result: Array<IntArray>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)),
      intArrayOf(2, 5),
      arrayOf(intArrayOf(1, 5), intArrayOf(6, 9))
    ),
    TestCase(
      arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
      intArrayOf(4, 8),
      arrayOf(intArrayOf(1, 2), intArrayOf(3, 10), intArrayOf(12, 16))
    )
  )

  @Test
  fun insertInterval1Test() {
    testCases.forEach { case ->
      assertTrue(case.result contentDeepEquals insertInterval1(case.intervals, case.newInterval))
    }
  }
}
