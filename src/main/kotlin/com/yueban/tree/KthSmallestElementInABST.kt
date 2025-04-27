package com.yueban.tree

import com.yueban.tree.KthSmallestElementInABST.kthSmallestElementInABST1

object KthSmallestElementInABST {
  fun kthSmallestElementInABST1(root: TreeNode?, k: Int): Int {
    val list = mutableListOf<Int>()

    fun traverseBTS(node: TreeNode?) {
      if (node == null) return

      node.left?.apply(::traverseBTS)

      list.add(node.`val`)

      node.right?.apply(::traverseBTS)
    }

    traverseBTS(root)

    return list[k - 1]
  }

  /**
   * basically same as [kthSmallestElementInABST1] but use a counter to retrieve the kth smallest element during the traversal.
   */
  fun kthSmallestElementInABST2(root: TreeNode?, k: Int): Int {
    var count = 0
    var result = 0

    fun traverseBTS(node: TreeNode?) {
      if (node == null) return

      node.left?.apply(::traverseBTS)

      count++
      if (count == k) {
        result = node.`val`
      }
      if (count > k) return

      node.right?.apply(::traverseBTS)
    }

    traverseBTS(root)

    return result
  }
}
