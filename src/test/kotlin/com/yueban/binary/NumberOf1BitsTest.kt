package com.yueban.binary

import com.yueban.binary.NumberOf1Bits.numberOf1Bits1
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberOf1BitsTest {
  data class TestCase(
    val n: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(11, 3),
    TestCase(128, 1),
    TestCase(2147483645, 30),
  )

  @Test
  fun numberOf1Bits1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, numberOf1Bits1(case.n))
    }
  }
}
