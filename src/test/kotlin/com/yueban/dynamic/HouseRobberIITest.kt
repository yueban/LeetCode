package com.yueban.dynamic

import com.yueban.dynamic.HouseRobberII.houseRobberII1
import kotlin.test.Test
import kotlin.test.assertEquals

class HouseRobberIITest {
  class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(2, 3, 2), 3),
    TestCase(intArrayOf(1, 2, 3, 1), 4),
    TestCase(intArrayOf(1, 2, 3), 3),
    TestCase(intArrayOf(1, 2, 1, 1), 3),
    TestCase(intArrayOf(1, 7, 9, 2), 10),
  )

  @Test
  fun houseRobberII1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, houseRobberII1(case.nums))
    }
  }
}
