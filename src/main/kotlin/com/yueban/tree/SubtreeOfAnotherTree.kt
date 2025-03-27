package com.yueban.tree

import java.util.*

object SubtreeOfAnotherTree {
  fun subtreeOfAnotherTree1(root: TreeNode?, subRoot: TreeNode?): Boolean {
    val queue = LinkedList<TreeNode?>()
    queue.add(root)

    while (queue.isNotEmpty()) {
      val node = queue.poll()
      if (isSameTree(node, subRoot)) return true
      node?.left?.apply(queue::add)
      node?.right?.apply(queue::add)
    }

    return false
  }

  fun subtreeOfAnotherTree2(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) return true
    if (root == null) return false
    if (isSameTree(root, subRoot)) return true
    return subtreeOfAnotherTree2(root.left, subRoot) || subtreeOfAnotherTree2(root.right, subRoot)
  }

  private fun isSameTree(expected: TreeNode?, actual: TreeNode?): Boolean =
    when {
      expected == null && actual == null -> true
      else -> expected?.`val` == actual?.`val` &&
        isSameTree(expected?.left, actual?.left) &&
        isSameTree(expected?.right, actual?.right)
    }
}
