package com.yueban.array

import com.yueban.array.MaxSubArray.maxSubArray1
import com.yueban.array.MaxSubArray.maxSubArray2
import com.yueban.array.MaxSubArray.maxSubArray3
import com.yueban.array.MaxSubArray.maxSubArray4
import kotlin.test.Test
import kotlin.test.assertEquals

class MaxSubArrayTest {
  class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
    TestCase(intArrayOf(1), 1),
    TestCase(intArrayOf(5, 4, -1, 7, 8), 23),
    TestCase(intArrayOf(1, 2), 3),
    TestCase(intArrayOf(-1, -1, -2, -2), -1),
    TestCase(intArrayOf(8, -19, 5, -4, 20), 21),
  )

  @Test
  fun maxSubArray1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maxSubArray1(case.nums))
    }
  }

  @Test
  fun maxSubArray2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maxSubArray2(case.nums))
    }
  }

  @Test
  fun maxSubArray3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maxSubArray3(case.nums))
    }
  }

  @Test
  fun maxSubArray4Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maxSubArray4(case.nums))
    }
  }
}
