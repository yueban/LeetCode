package com.yueban.binary

import com.yueban.binary.SumOfTwoIntegers.sumOfTwoIntegers1
import kotlin.test.Test
import kotlin.test.assertEquals

class SumOfTwoIntegersTest {
  class TestCase(
    val a: Int,
    val b: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(1, 2, 3), TestCase(2, 3, 5)
  )

  @Test
  fun sumOfTwoIntegers1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, sumOfTwoIntegers1(case.a, case.b))
    }
  }
}
