package com.yueban.tree

import com.yueban.tree.SubtreeOfAnotherTree.subtreeOfAnotherTree1
import com.yueban.tree.SubtreeOfAnotherTree.subtreeOfAnotherTree2
import kotlin.test.Test
import kotlin.test.assertEquals

class SubtreeOfAnotherTreeTest {
  private class TestCase(
    val root: TreeNode?,
    val subRoot: TreeNode?,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf<Int?>(3, 4, 5, 1, 2).toTreeNode(),
      arrayOf<Int?>(4, 1, 2).toTreeNode(),
      true
    ),
    TestCase(
      arrayOf(3, 4, 5, 1, 2, null, null, null, null, 0).toTreeNode(),
      arrayOf<Int?>(4, 1, 2).toTreeNode(),
      false
    ),
  )

  @Test
  fun subtreeOfAnotherTree1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, subtreeOfAnotherTree1(case.root, case.subRoot))
    }
  }

  @Test
  fun subtreeOfAnotherTree2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, subtreeOfAnotherTree2(case.root, case.subRoot))
    }
  }
}
