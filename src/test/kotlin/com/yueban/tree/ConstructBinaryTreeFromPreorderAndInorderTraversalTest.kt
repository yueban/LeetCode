package com.yueban.tree

import com.yueban.tree.ConstructBinaryTreeFromPreorderAndInorderTraversal.constructBinaryTreeFromPreorderAndInorderTraversal1
import com.yueban.tree.ConstructBinaryTreeFromPreorderAndInorderTraversal.constructBinaryTreeFromPreorderAndInorderTraversal2
import kotlin.test.Test
import kotlin.test.assertTrue

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
  private class TestCase(
    val preorder: IntArray,
    val inorder: IntArray,
    val result: TreeNode?,
  )

  private val testCases = listOf(
    TestCase(
      intArrayOf(3, 9, 20, 15, 7),
      intArrayOf(9, 3, 15, 20, 7),
      arrayOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    ),
    TestCase(
      intArrayOf(-1),
      intArrayOf(-1),
      arrayOf<Int?>(-1).toTreeNode()
    ),
  )

  @Test
  fun constructBinaryTreeFromPreorderAndInorderTraversal1Test() {
    testCases.forEach { case ->
      assertTrue(
        areTreesEqual(
          case.result,
          constructBinaryTreeFromPreorderAndInorderTraversal1(case.preorder, case.inorder)
        )
      )
    }
  }

  @Test
  fun constructBinaryTreeFromPreorderAndInorderTraversal2Test() {
    testCases.forEach { case ->
      assertTrue(
        areTreesEqual(
          case.result,
          constructBinaryTreeFromPreorderAndInorderTraversal2(case.preorder, case.inorder)
        )
      )
    }
  }
}
