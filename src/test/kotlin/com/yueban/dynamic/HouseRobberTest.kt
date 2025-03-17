package com.yueban.dynamic

import com.yueban.dynamic.HouseRobber.houseRobber1
import kotlin.test.Test
import kotlin.test.assertEquals

class HouseRobberTest {
  private class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 1), 4),
    TestCase(intArrayOf(2, 7, 9, 3, 1), 12),
  )

  @Test
  fun houseRobber1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, houseRobber1(case.nums))
    }
  }
}
