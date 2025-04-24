package com.yueban.tree

import kotlin.math.max

object MaximumDepthOfBinaryTree {
  fun maximumDepthOfBinaryTree1(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + max(maximumDepthOfBinaryTree1(root.left), maximumDepthOfBinaryTree1(root.right))
  }
}
