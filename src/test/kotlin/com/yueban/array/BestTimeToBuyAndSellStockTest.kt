package com.yueban.array

import com.yueban.array.BestTimeToBuyAndSellStock.bestTimeToBuyAndSellStock1
import com.yueban.array.BestTimeToBuyAndSellStock.bestTimeToBuyAndSellStock2
import kotlin.test.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockTest {
  private class TestCase(
    val prices: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(7, 1, 5, 3, 6, 4), 5),
    TestCase(intArrayOf(7, 6, 4, 3, 1), 0),
    TestCase(intArrayOf(1, 2), 1),
  )

  @Test
  fun bestTimeToBuyAndSellStock1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, bestTimeToBuyAndSellStock1(case.prices))
    }
  }

  @Test
  fun bestTimeToBuyAndSellStock2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, bestTimeToBuyAndSellStock2(case.prices))
    }
  }
}
