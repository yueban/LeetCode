package com.yueban.tree

import com.yueban.tree.BinaryTreeMaximumPathSum.binaryTreeMaximumPathSum1
import kotlin.math.max

object BinaryTreeMaximumPathSum {
  /**
   * For each node, the max sum of path has four scenarios:
   * 1. the node itself
   * 2. maxPathSum(node left child) + node
   * 3. maxPathSum(node right child) + node
   * 4. maxPathSum(node left child) + node + maxPathSum(node right child)
   *
   * But the 4th scenario is not a valid maxOneSide when iterating (function maxSinglePathSum), because the 4th
   * scenario has already used both left and right child nodes, so the 4th scenario cannot be connected by the parent again.
   *
   * But the 4th scenario is valid when calculating max result.
   */
  fun binaryTreeMaximumPathSum1(root: TreeNode?): Int {
    var result = Int.MIN_VALUE

    fun maxOneSideSum(node: TreeNode?): Int {
      if (node == null) return 0
      val maxLeft = maxOneSideSum(node.left)
      val maxRight = maxOneSideSum(node.right)
      val maxOneSide = maxOf(node.`val`, maxLeft + node.`val`, maxRight + node.`val`)
      result = maxOf(maxOneSide, maxLeft + maxRight + node.`val`, result)
      return maxOneSide
    }

    maxOneSideSum(root)

    return result
  }

  /**
   * Basically same as [binaryTreeMaximumPathSum1], but we simply omit left/right result when its value <= 0.
   * And we pick the max value of left and right when return which means the return value just use on side of child path.
   */
  fun binaryTreeMaximumPathSum2(root: TreeNode?): Int {
    var result = Int.MIN_VALUE

    fun maxOneSideSum(node: TreeNode?): Int {
      if (node == null) return 0

      val leftMax = max(0, maxOneSideSum(node.left))
      val rightMax = max(0, maxOneSideSum(node.right))

      result = max(result, node.`val` + leftMax + rightMax)

      return max(leftMax, rightMax) + node.`val`
    }

    maxOneSideSum(root)

    return result
  }
}
