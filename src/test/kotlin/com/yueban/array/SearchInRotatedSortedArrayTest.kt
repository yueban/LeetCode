package com.yueban.array

import com.yueban.array.SearchInRotatedSortedArray.searchInRotatedSortedArray1
import com.yueban.array.SearchInRotatedSortedArray.searchInRotatedSortedArray2
import kotlin.test.Test
import kotlin.test.assertEquals

class SearchInRotatedSortedArrayTest {
  private class TestCase(
    val nums: IntArray,
    val target: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4),
    TestCase(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3, -1),
    TestCase(intArrayOf(1), 0, -1),
  )

  @Test
  fun searchInRotatedSortedArray1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, searchInRotatedSortedArray1(case.nums, case.target))
    }
  }

  @Test
  fun searchInRotatedSortedArray2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, searchInRotatedSortedArray2(case.nums, case.target))
    }
  }
}
