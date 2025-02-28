package com.yueban.array

import com.yueban.array.ThreeSum.threeSum1
import com.yueban.array.ThreeSum.threeSum2
import com.yueban.array.ThreeSum.threeSum3
import com.yueban.array.ThreeSum.threeSum4
import kotlin.test.Test
import kotlin.test.assertEquals

class ThreeSumTest {
  class TestCase(
    val nums: IntArray,
    val result: List<List<Int>>,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(-1, 0, 1, 2, -1, -4), listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))),
    TestCase(intArrayOf(0, 1, 1), listOf()),
    TestCase(intArrayOf(0, 0, 0), listOf(listOf(0, 0, 0))),
    TestCase(intArrayOf(0, 0, 0, 0), listOf(listOf(0, 0, 0))),
  )

  @Test
  fun threeSum1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, threeSum1(case.nums))
    }
  }

  @Test
  fun threeSum2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, threeSum2(case.nums))
    }
  }

  @Test
  fun threeSum3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, threeSum3(case.nums))
    }
  }

  @Test
  fun threeSum4Test() {
    testCases.forEach { case ->
      assertEquals(case.result, threeSum4(case.nums))
    }
  }
}
