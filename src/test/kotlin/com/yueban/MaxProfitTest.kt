package com.yueban

import com.yueban.MaxProfit.maxProfit1
import com.yueban.MaxProfit.maxProfit2
import kotlin.test.Test
import kotlin.test.assertEquals

class MaxProfitTest {
  class TestCase(
    val prices: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(7, 1, 5, 3, 6, 4), 5),
    TestCase(intArrayOf(7, 6, 4, 3, 1), 0),
    TestCase(intArrayOf(1, 2), 1),
  )

  @Test
  fun maxProfit1Test() {
    testCases.forEach { case ->
      assertEquals(maxProfit1(case.prices), case.result)
    }
  }

  @Test
  fun maxProfit2Test() {
    testCases.forEach { case ->
      assertEquals(maxProfit2(case.prices), case.result)
    }
  }
}
