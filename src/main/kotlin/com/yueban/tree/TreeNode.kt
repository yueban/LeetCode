package com.yueban.tree

import java.util.*

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun Array<Int?>.toTreeNode(): TreeNode? {
  if (isEmpty() || this[0] == null) return null

  val root = TreeNode(this[0]!!)
  val queue = LinkedList<TreeNode>()
  queue.add(root)
  var i = 1

  while (i < size) {
    val current = queue.poll()

    if (this[i] != null) {
      current.left = TreeNode(this[i]!!)
      queue.add(current.left!!)
    }
    i++

    if (i < size && this[i] != null) {
      current.right = TreeNode(this[i]!!)
      queue.add(current.right!!)
    }
    i++
  }

  return root
}
