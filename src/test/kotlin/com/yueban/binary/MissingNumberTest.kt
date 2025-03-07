package com.yueban.binary

import com.yueban.binary.MissingNumber.missingNumber1
import com.yueban.binary.MissingNumber.missingNumber2
import kotlin.test.Test
import kotlin.test.assertEquals

class MissingNumberTest {
  class TestCase(
    val nums: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(3, 0, 1), 2),
    TestCase(intArrayOf(0, 1), 2),
    TestCase(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1), 8),
  )

  @Test
  fun missingNumber1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, missingNumber1(case.nums))
    }
  }

  @Test
  fun missingNumber2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, missingNumber2(case.nums))
    }
  }
}
