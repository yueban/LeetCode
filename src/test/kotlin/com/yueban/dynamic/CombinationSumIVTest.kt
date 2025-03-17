package com.yueban.dynamic

import com.yueban.dynamic.CombinationSumIV.combinationSumIV1
import kotlin.test.Test
import kotlin.test.assertEquals

class CombinationSumIVTest {
  private class TestCase(
    val nums: IntArray,
    val target: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3), 4, 7),
    TestCase(intArrayOf(9), 3, 0),
  )

  @Test
  fun combinationSumIV1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, combinationSumIV1(case.nums, case.target))
    }
  }
}
