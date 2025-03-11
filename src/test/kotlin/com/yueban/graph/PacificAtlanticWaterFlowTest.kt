package com.yueban.graph

import com.yueban.graph.PacificAtlanticWaterFlow.pacificAtlanticWater1
import kotlin.test.Test
import kotlin.test.assertEquals

class PacificAtlanticWaterFlowTest {
  class TestCase(
    val heights: Array<IntArray>,
    val result: List<List<Int>>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4)
      ), listOf(
        listOf(0, 4), listOf(1, 3), listOf(1, 4), listOf(2, 2), listOf(3, 0), listOf(3, 1), listOf(4, 0)
      )
    ),
    TestCase(arrayOf(intArrayOf(1)), listOf(listOf(0, 0))),
    TestCase(
      arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(8, 9, 4),
        intArrayOf(7, 6, 5),
      ), listOf(
        listOf(0, 2), listOf(1, 0), listOf(1, 1), listOf(1, 2), listOf(2, 0), listOf(2, 1), listOf(2, 2)
      )
    ),
  )

  @Test
  fun pacificAtlanticWater1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, pacificAtlanticWater1(case.heights))
    }
  }
}
