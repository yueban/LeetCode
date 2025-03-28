package com.yueban.tree

import com.yueban.tree.ValidateBinarySearchTree.validateBinarySearchTree1
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidateBinarySearchTreeTest {
  private class TestCase(
    val root: TreeNode?,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(arrayOf<Int?>(2, 1, 3).toTreeNode(), true),
    TestCase(arrayOf(5, 1, 4, null, null, 3, 6).toTreeNode(), false),
    TestCase(arrayOf(3, 1, 5, 0, 2, 4, 6, null, null, null, 3).toTreeNode(), false),
  )

  @Test
  fun validateBinarySearchTree1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validateBinarySearchTree1(case.root))
    }
  }
}
