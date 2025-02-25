package com.yueban

import com.yueban.FindMinRotatedSortedArray.findMinRotatedSortedArray1
import com.yueban.FindMinRotatedSortedArray.findMinRotatedSortedArray2
import kotlin.test.Test
import kotlin.test.assertEquals

class FindMinRotatedSortedArrayTest {
  class TestCase(
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
  fun findMinRotatedSortedArray1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, findMinRotatedSortedArray1(case.nums))
    }
  }

  @Test
  fun findMinRotatedSortedArray2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, findMinRotatedSortedArray2(case.nums))
    }
  }
}
