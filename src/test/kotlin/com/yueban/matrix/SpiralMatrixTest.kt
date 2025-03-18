package com.yueban.matrix

import com.yueban.matrix.SpiralMatrix.spiralMatrix1
import com.yueban.matrix.SpiralMatrix.spiralMatrix2
import kotlin.test.Test
import kotlin.test.assertEquals

class SpiralMatrixTest {
  class TestCase(
    val matrix: Array<IntArray>,
    val result: List<Int>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
      ),
      listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
    ),
    TestCase(
      arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
      ),
      listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
    ),
  )

  @Test
  fun spiralMatrix1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, spiralMatrix1(case.matrix))
    }
  }

  @Test
  fun spiralMatrix2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, spiralMatrix2(case.matrix))
    }
  }
}
