package com.yueban.tree

import com.yueban.tree.WordSearchII.wordSearchII1
import com.yueban.tree.WordSearchII.wordSearchII2
import kotlin.test.Test
import kotlin.test.assertEquals

class WordSearchIITest {
  private class TestCase(
    val board: Array<CharArray>,
    val words: Array<String>,
    val result: List<String>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v')
      ),
      arrayOf("oath", "pea", "eat", "rain"),
      listOf("eat", "oath")
    ),
    TestCase(
      arrayOf(
        charArrayOf('a', 'b'),
        charArrayOf('c', 'd')
      ),
      arrayOf("abcb"),
      listOf()
    ),
  )

  @Test
  fun wordSearchII1Test() {
    testCases.forEach { case ->
      assertEquals(case.result.toSet(), wordSearchII1(case.board, case.words).toSet())
    }
  }

  @Test
  fun wordSearchII2Test() {
    testCases.forEach { case ->
      assertEquals(case.result.toSet(), wordSearchII2(case.board, case.words).toSet())
    }
  }
}
