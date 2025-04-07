package com.yueban.array

import com.yueban.array.MaximumSubarray.maximumSubarray1
import com.yueban.array.MaximumSubarray.maximumSubarray2
import com.yueban.array.MaximumSubarray.maximumSubarray3
import com.yueban.array.MaximumSubarray.maximumSubarray4
import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumSubarrayTest {
  private class TestCase(
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
  fun maximumSubarray1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumSubarray1(case.nums))
    }
  }

  @Test
  fun maximumSubarray2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumSubarray2(case.nums))
    }
  }

  @Test
  fun maximumSubarray3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumSubarray3(case.nums))
    }
  }

  @Test
  fun maximumSubarray4Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumSubarray4(case.nums))
    }
  }
}
