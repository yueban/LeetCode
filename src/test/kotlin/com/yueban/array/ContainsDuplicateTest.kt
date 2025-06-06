package com.yueban.array

import com.yueban.array.ContainsDuplicate.containsDuplicate1
import kotlin.test.Test
import kotlin.test.assertEquals

class ContainsDuplicateTest {
  private class TestCase(
    val nums: IntArray,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 1), true),
    TestCase(intArrayOf(1, 2, 3, 4), false),
    TestCase(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2), true),
  )

  @Test
  fun containsDuplicate1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, containsDuplicate1(case.nums))
    }
  }
}
