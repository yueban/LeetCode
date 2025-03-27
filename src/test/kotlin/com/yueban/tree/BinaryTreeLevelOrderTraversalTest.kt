package com.yueban.tree

import com.yueban.tree.BinaryTreeLevelOrderTraversal.binaryTreeLevelOrderTraversal1
import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryTreeLevelOrderTraversalTest {
  private class TestCase(
    val root: TreeNode?,
    val result: List<List<Int>>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(3, 9, 20, null, null, 15, 7).toTreeNode(),
      listOf(listOf(3), listOf(9, 20), listOf(15, 7))
    ),
    TestCase(
      arrayOf<Int?>(1).toTreeNode(),
      listOf(listOf(1))
    ),
    TestCase(
      arrayOf<Int?>().toTreeNode(),
      listOf()
    ),
  )

  @Test
  fun binaryTreeLevelOrderTraversal1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, binaryTreeLevelOrderTraversal1(case.root))
    }
  }
}
