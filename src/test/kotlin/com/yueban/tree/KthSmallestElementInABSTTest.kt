package com.yueban.tree

import com.yueban.tree.KthSmallestElementInABST.kthSmallestElementInABST1
import com.yueban.tree.KthSmallestElementInABST.kthSmallestElementInABST2
import kotlin.test.Test
import kotlin.test.assertEquals

class KthSmallestElementInABSTTest {
  private class TestCase(
    val root: TreeNode?,
    val k: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(arrayOf(3, 1, 4, null, 2).toTreeNode(), 1, 1),
    TestCase(arrayOf(5, 3, 6, 2, 4, null, null, 1).toTreeNode(), 3, 3),
    TestCase(arrayOf(3, 1, 4, null, 2).toTreeNode(), 3, 3),
  )

  @Test
  fun kthSmallestElementInABST1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, kthSmallestElementInABST1(case.root, case.k))
    }
  }

  @Test
  fun kthSmallestElementInABST2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, kthSmallestElementInABST2(case.root, case.k))
    }
  }
}
