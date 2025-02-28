package com.yueban.array

import com.yueban.array.MaxProduct.maxProduct1
import kotlin.test.Test
import kotlin.test.assertEquals

class MaxProductTest {
  class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(2, 3, -2, 4), 6),
    TestCase(intArrayOf(-2, 0, -1), 0),
    TestCase(intArrayOf(-3, -1, -1), 3),
  )

  @Test
  fun maxProduct1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maxProduct1(case.nums))
    }
  }
}
