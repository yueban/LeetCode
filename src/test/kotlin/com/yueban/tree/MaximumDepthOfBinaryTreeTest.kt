package com.yueban.tree

import com.yueban.tree.MaximumDepthOfBinaryTree.maximumDepthOfBinaryTree1
import com.yueban.tree.MaximumDepthOfBinaryTree.maximumDepthOfBinaryTree2
import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumDepthOfBinaryTreeTest {
  private class TestCase(
    val root: TreeNode?,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(arrayOf(3, 9, 20, null, null, 15, 7).toTreeNode(), 3),
    TestCase(arrayOf(1, null, 2).toTreeNode(), 2),
  )

  @Test
  fun maximumDepthOfBinaryTree1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumDepthOfBinaryTree1(case.root))
    }
  }

  @Test
  fun maximumDepthOfBinaryTree2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, maximumDepthOfBinaryTree2(case.root))
    }
  }
}
