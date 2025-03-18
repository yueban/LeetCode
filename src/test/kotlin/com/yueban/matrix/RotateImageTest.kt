package com.yueban.matrix

import com.yueban.matrix.RotateImage.rotateImage1
import kotlin.test.Test
import kotlin.test.assertTrue

class RotateImageTest {
  private class TestCase(
    val matrix: Array<IntArray>,
    val result: Array<IntArray>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
      ),
      arrayOf(
        intArrayOf(7, 4, 1),
        intArrayOf(8, 5, 2),
        intArrayOf(9, 6, 3)
      ),
    ),
    TestCase(
      arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16),
      ),
      arrayOf(
        intArrayOf(15, 13, 2, 5),
        intArrayOf(14, 3, 4, 1),
        intArrayOf(12, 6, 8, 9),
        intArrayOf(16, 7, 10, 11),
      )
    )
  )

  @Test
  fun rotateImage1Test() {
    testCases.forEach { case ->
      rotateImage1(case.matrix)
      assertTrue(case.result.contentDeepEquals(case.matrix))
    }
  }
}
