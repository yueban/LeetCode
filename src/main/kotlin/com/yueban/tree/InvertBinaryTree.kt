package com.yueban.tree

object InvertBinaryTree {
  fun invertBinaryTree1(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val temp = invertBinaryTree1(root.left)
    root.left = invertBinaryTree1(root.right)
    root.right = temp
    return root
  }
}
