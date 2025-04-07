package com.yueban.array

import com.yueban.array.FindMinimumInRotatedSortedArray.findMinimumInRotatedSortedArray1
import com.yueban.array.FindMinimumInRotatedSortedArray.findMinimumInRotatedSortedArray2
import kotlin.test.Test
import kotlin.test.assertEquals

class FindMinimumInRotatedSortedArrayTest {
  private class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(3, 4, 5, 1, 2), 1),
    TestCase(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0),
    TestCase(intArrayOf(11, 13, 15, 17), 11),
    TestCase(intArrayOf(2, 1), 1),
  )

  @Test
  fun findMinimumInRotatedSortedArray1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, findMinimumInRotatedSortedArray1(case.nums))
    }
  }

  @Test
  fun findMinimumInRotatedSortedArray2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, findMinimumInRotatedSortedArray2(case.nums))
    }
  }
}
