package com.yueban.array

import com.yueban.array.MaximumProductSubarray.maximumProductSubarray1
import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumProductSubarrayTest {
  private class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(2, 3, -2, 4), 6),
    TestCase(intArrayOf(-2, 0, -1), 0),
    TestCase(intArrayOf(-3, -1, -1), 3),
  )

  @Test
  fun maximumProductSubarray1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumProductSubarray1(case.nums))
    }
  }
}
