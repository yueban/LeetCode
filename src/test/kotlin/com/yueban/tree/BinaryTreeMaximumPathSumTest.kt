package com.yueban.tree

import com.yueban.tree.BinaryTreeMaximumPathSum.binaryTreeMaximumPathSum1
import com.yueban.tree.BinaryTreeMaximumPathSum.binaryTreeMaximumPathSum2
import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryTreeMaximumPathSumTest {
  private class TestCase(
    val root: TreeNode?,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(arrayOf<Int?>(1, 2, 3).toTreeNode(), 6),
    TestCase(arrayOf(-10, 9, 20, null, null, 15, 7).toTreeNode(), 42),
  )

  @Test
  fun binaryTreeMaximumPathSum1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, binaryTreeMaximumPathSum1(case.root))
    }
  }

  @Test
  fun binaryTreeMaximumPathSum2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, binaryTreeMaximumPathSum2(case.root))
    }
  }
}
