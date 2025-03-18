package com.yueban.matrix

import com.yueban.matrix.SetMatrixZeroes.setMatrixZeroes1
import com.yueban.matrix.SetMatrixZeroes.setMatrixZeroes2
import com.yueban.matrix.SetMatrixZeroes.setMatrixZeroes3
import kotlin.test.Test
import kotlin.test.assertTrue

class SetMatrixZeroesTest {
  private class TestCase(
    val matrix: Array<IntArray>,
    val result: Array<IntArray>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
      ),
      arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 1)
      ),
    ),
    TestCase(
      arrayOf(
        intArrayOf(0, 1, 2, 0),
        intArrayOf(3, 4, 5, 2),
        intArrayOf(1, 3, 1, 5)
      ),
      arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 4, 5, 0),
        intArrayOf(0, 3, 1, 0)
      ),
    )
  )

  @Test
  fun setMatrixZeroes1Test() {
    testCases.forEach { case ->
      setMatrixZeroes1(case.matrix)
      assertTrue(case.result.contentDeepEquals(case.matrix))
    }
  }

  @Test
  fun setMatrixZeroes2Test() {
    testCases.forEach { case ->
      setMatrixZeroes2(case.matrix)
      assertTrue(case.result.contentDeepEquals(case.matrix))
    }
  }

  @Test
  fun setMatrixZeroes3Test() {
    testCases.forEach { case ->
      setMatrixZeroes3(case.matrix)
      assertTrue(case.result.contentDeepEquals(case.matrix))
    }
  }
}
