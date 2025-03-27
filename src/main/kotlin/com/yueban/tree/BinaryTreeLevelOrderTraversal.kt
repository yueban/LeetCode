package com.yueban.tree

import java.util.*

object BinaryTreeLevelOrderTraversal {
  fun binaryTreeLevelOrderTraversal1(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()

    val queue = LinkedList<TreeNode>()
    val result = mutableListOf<List<Int>>()
    queue.push(root)

    while (queue.isNotEmpty()) {
      val values = mutableListOf<Int>()

      val size = queue.size
      for (i in 0 until size) {
        val node = queue.poll()
        values.add(node.`val`)
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
      }

      result.add(values)
    }

    return result
  }
}
