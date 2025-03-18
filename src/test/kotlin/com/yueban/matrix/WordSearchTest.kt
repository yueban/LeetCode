package com.yueban.matrix

import com.yueban.matrix.WordSearch.wordSearch1
import com.yueban.matrix.WordSearch.wordSearch2
import kotlin.test.Test
import kotlin.test.assertEquals

class WordSearchTest {
  private class TestCase(
    val board: Array<CharArray>,
    val word: String,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      "ABCCED",
      true
    ),
    TestCase(
      arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      "SEE",
      true
    ),
    TestCase(
      arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      "ABCB",
      false
    ),
    TestCase(
      arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'E', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
      ),
      "ABCESEEEFS",
      true
    )
  )

  @Test
  fun rotateImage1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, wordSearch1(case.board, case.word))
    }
  }

  @Test
  fun rotateImage2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, wordSearch2(case.board, case.word))
    }
  }
}
