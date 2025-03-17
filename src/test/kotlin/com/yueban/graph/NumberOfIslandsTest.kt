package com.yueban.graph

import com.yueban.graph.NumberOfIslands.numberOfIslands1
import com.yueban.graph.NumberOfIslands.numberOfIslands2
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberOfIslandsTest {
  private class TestCase(
    val grid: Array<CharArray>,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0'),
      ), 1
    ),
    TestCase(
      arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
      ), 3
    ),
  )

  @Test
  fun numberOfIslands1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, numberOfIslands1(case.grid))
    }
  }

  @Test
  fun numberOfIslands2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, numberOfIslands2(case.grid))
    }
  }
}
