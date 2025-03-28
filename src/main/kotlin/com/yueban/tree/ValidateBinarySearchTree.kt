package com.yueban.tree

object ValidateBinarySearchTree {
  fun validateBinarySearchTree1(root: TreeNode?): Boolean {
    fun isValidBST(node: TreeNode?, min: Int, max: Int): Boolean {
      if (node == null) return true
      if (node.`val` > max || node.`val` < min) return false
      if ((node.`val` == Int.MIN_VALUE && node.left != null) || (node.`val` == Int.MAX_VALUE && node.right != null)) {
        return false
      }

      return isValidBST(node.left, min, node.`val` - 1) && isValidBST(node.right, node.`val` + 1, max)
    }

    return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
  }
}
