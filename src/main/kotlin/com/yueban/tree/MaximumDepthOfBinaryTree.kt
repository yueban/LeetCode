package com.yueban.tree

import kotlin.math.max

object MaximumDepthOfBinaryTree {
  fun maximumDepthOfBinaryTree1(root: TreeNode?): Int {
    fun maxDepth(node: TreeNode?): Int {
      if (node == null) return 0
      return 1 + max(maxDepth(node.left), maxDepth(node.right))
    }

    return maxDepth(root)
  }

  fun maximumDepthOfBinaryTree2(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + max(maximumDepthOfBinaryTree2(root.left), maximumDepthOfBinaryTree2(root.right))
  }
}
