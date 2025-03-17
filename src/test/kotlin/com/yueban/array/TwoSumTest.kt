package com.yueban.array

import com.yueban.array.TwoSum.twoSum1
import com.yueban.array.TwoSum.twoSum2
import com.yueban.array.TwoSum.twoSum3
import kotlin.test.Test
import kotlin.test.assertEquals

class TwoSumTest {
  private class TestCase(
    val nums: IntArray,
    val target: Int,
    val result: Set<Int>,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(2, 7, 11, 15), 9, setOf(0, 1)),
    TestCase(intArrayOf(3, 2, 4), 6, setOf(1, 2)),
    TestCase(intArrayOf(3, 3), 6, setOf(0, 1)),
  )

  @Test
  fun twoSum1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, twoSum1(case.nums, case.target))
    }
  }

  @Test
  fun twoSum2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, twoSum2(case.nums, case.target))
    }
  }

  @Test
  fun twoSum3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, twoSum3(case.nums, case.target))
    }
  }
}
