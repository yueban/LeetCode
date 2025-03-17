package com.yueban.interval

import com.yueban.interval.NonOverlappingIntervals.nonOverlappingIntervals1
import kotlin.test.Test
import kotlin.test.assertEquals

class NonOverlappingIntervalsTest {
  private class TestCase(
    val intervals: Array<IntArray>,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3)), 1),
    TestCase(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2)), 2),
    TestCase(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)), 0),
    TestCase(arrayOf(intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(3, 5), intArrayOf(4, 6)), 2),
  )

  @Test
  fun nonOverlappingIntervals1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, nonOverlappingIntervals1(case.intervals))
    }
  }
}
