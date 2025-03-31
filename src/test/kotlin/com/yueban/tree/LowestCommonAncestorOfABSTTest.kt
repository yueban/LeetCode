package com.yueban.tree

import com.yueban.tree.LowestCommonAncestorOfABST.lowestCommonAncestorOfABST1
import com.yueban.tree.LowestCommonAncestorOfABST.lowestCommonAncestorOfABST2
import java.util.*
import kotlin.test.Test
import kotlin.test.assertTrue

class LowestCommonAncestorOfABSTTest {
  private class TestCase(
    val root: TreeNode?,
    val p: TreeNode?,
    val q: TreeNode?,
    val result: TreeNode?,
  )

  private val testCases = listOf(
    arrayOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5).toTestCase(2, 8, 6),
    arrayOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5).toTestCase(2, 4, 2),
    arrayOf<Int?>(2, 1).toTestCase(2, 1, 2),
  )

  private fun Array<Int?>.toTestCase(p: Int, q: Int, result: Int): TestCase {
    if (isEmpty() || this[0] == null) throw IllegalArgumentException("invalid tree")

    val root = TreeNode(this[0]!!)
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var i = 1
    var pNode: TreeNode? = null
    var qNode: TreeNode? = null
    var resultNode: TreeNode? = null

    if (root.`val` == p) pNode = root
    if (root.`val` == q) qNode = root
    if (root.`val` == result) resultNode = root

    while (i < size) {
      val current = queue.poll()

      if (this[i] != null) {
        current.left = TreeNode(this[i]!!)
        if (this[i] == p) pNode = current.left
        if (this[i] == q) qNode = current.left
        if (this[i] == result) resultNode = current.left
        queue.add(current.left!!)
      }
      i++

      if (i < size && this[i] != null) {
        current.right = TreeNode(this[i]!!)
        if (this[i] == p) pNode = current.right
        if (this[i] == q) qNode = current.right
        if (this[i] == result) resultNode = current.right
        queue.add(current.right!!)
      }
      i++
    }

    return TestCase(root, pNode, qNode, resultNode)
  }

  @Test
  fun lowestCommonAncestorOfABST1Test() {
    testCases.forEach { case ->
      assertTrue(areTreesEqual(case.result, lowestCommonAncestorOfABST1(case.root, case.p, case.q)))
    }
  }

  @Test
  fun lowestCommonAncestorOfABST2Test() {
    testCases.forEach { case ->
      assertTrue(areTreesEqual(case.result, lowestCommonAncestorOfABST2(case.root, case.p, case.q)))
    }
  }
}
