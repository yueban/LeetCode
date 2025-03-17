package com.yueban.binary

import com.yueban.binary.CountingBits.countingBits1
import com.yueban.binary.CountingBits.countingBits2
import kotlin.test.Test
import kotlin.test.assertContentEquals

class CountingBitsTest {
  private class TestCase(
    val n: Int,
    val result: IntArray,
  )

  private val testCases = listOf(
    TestCase(2, intArrayOf(0, 1, 1)),
    TestCase(5, intArrayOf(0, 1, 1, 2, 1, 2)),
  )

  @Test
  fun countingBits1Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, countingBits1(case.n))
    }
  }

  @Test
  fun countingBits2Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, countingBits2(case.n))
    }
  }
}
