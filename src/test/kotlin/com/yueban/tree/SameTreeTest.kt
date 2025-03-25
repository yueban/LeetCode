package com.yueban.tree

import com.yueban.tree.SameTree.sameTree1
import kotlin.test.Test
import kotlin.test.assertEquals

class SameTreeTest {
  private class TestCase(
    val p: TreeNode?,
    val q: TreeNode?,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(arrayOf<Int?>(1, 2, 3).toTreeNode(), arrayOf<Int?>(1, 2, 3).toTreeNode(), true),
    TestCase(arrayOf<Int?>(1, 2).toTreeNode(), arrayOf(1, null, 2).toTreeNode(), false),
    TestCase(arrayOf<Int?>(1, 2, 1).toTreeNode(), arrayOf<Int?>(1, 1, 2).toTreeNode(), false),
  )

  @Test
  fun sameTree1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, sameTree1(case.p, case.q))
    }
  }
}
