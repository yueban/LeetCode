package com.yueban.tree

import com.yueban.tree.InvertBinaryTree.invertBinaryTree1
import kotlin.test.Test
import kotlin.test.assertTrue

class InvertBinaryTreeTest {
  private class TestCase(
    val root: TreeNode?,
    val result: TreeNode?,
  )

  private val testCases = listOf(
    TestCase(arrayOf<Int?>(4, 2, 7, 1, 3, 6, 9).toTreeNode(), arrayOf<Int?>(4, 7, 2, 9, 6, 3, 1).toTreeNode()),
    TestCase(arrayOf<Int?>(2, 1, 3).toTreeNode(), arrayOf<Int?>(2, 3, 1).toTreeNode()),
  )

  @Test
  fun invertBinaryTree1Test() {
    testCases.forEach { case ->
      assertTrue(areTreesEqual(case.result, invertBinaryTree1(case.root)))
    }
  }
}
