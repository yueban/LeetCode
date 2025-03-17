package com.yueban.dynamic

import com.yueban.dynamic.CoinChange.coinChange1
import kotlin.test.Test
import kotlin.test.assertEquals

class CoinChangeTest {
  private class TestCase(
    val coins: IntArray,
    val amount: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 5), 11, 3),
    TestCase(intArrayOf(2), 3, -1),
    TestCase(intArrayOf(1), 0, 0),
    TestCase(intArrayOf(186, 419, 83, 408), 6249, 20),
    TestCase(intArrayOf(397, 417, 24, 44, 235), 3383, 13),
  )

  @Test
  fun coinChange1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, coinChange1(case.coins, case.amount))
    }
  }
}
