package com.yueban.binary

import com.yueban.binary.ReserveBits.reverseBits1
import com.yueban.binary.ReserveBits.reverseBits2
import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseBitsTest {
  class TestCase(
    val n: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(
      "00000010100101000001111010011100".toUInt(2).toInt(), "00111001011110000010100101000000".toUInt(2).toInt()
    ),
    TestCase(
      "11111111111111111111111111111101".toUInt(2).toInt(), "10111111111111111111111111111111".toUInt(2).toInt()
    ),
  )

  @Test
  fun reverseBits1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, reverseBits1(case.n))
    }
  }

  @Test
  fun reverseBits2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, reverseBits2(case.n))
    }
  }
}
