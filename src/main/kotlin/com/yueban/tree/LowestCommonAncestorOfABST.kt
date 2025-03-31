package com.yueban.tree

import java.util.*
import kotlin.math.abs

object LowestCommonAncestorOfABST {
  /**
   * 1. construct a map contains all the nodes with their direct parent
   * 2. construct two ancestor list for p and q
   * 3. compare two list and find the lowest common ancestor
   */
  fun lowestCommonAncestorOfABST1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    val ancestorMap = mutableMapOf<TreeNode, TreeNode>()
    val queue = LinkedList<TreeNode>()
    queue.add(root!!)

    while (queue.isNotEmpty()) {
      val node = queue.poll()
      node.left?.let {
        ancestorMap[it] = node
        queue.add(it)
      }
      node.right?.let {
        ancestorMap[it] = node
        queue.add(it)
      }
    }

    val pAncestors = LinkedList<TreeNode>()
    val qAncestors = LinkedList<TreeNode>()
    pAncestors.add(p!!)
    qAncestors.add(q!!)
    while (true) {
      ancestorMap[pAncestors.last()]?.let { pAncestors.add(it) } ?: break
    }
    while (true) {
      ancestorMap[qAncestors.last()]?.let { qAncestors.add(it) } ?: break
    }

    val (longer, shorter) = if (pAncestors.size > qAncestors.size) {
      pAncestors to qAncestors
    } else {
      qAncestors to pAncestors
    }
    val bias = abs(pAncestors.size - qAncestors.size)
    for (i in 0 until shorter.size) {
      if (longer[i + bias] == shorter[i]) {
        return shorter[i]
      }
    }

    return null
  }

  /**
   * we have a BTS, so the left node is smaller than its ancestors and right node is bigger.
   * if both p and q are smaller than a node, which means p and q are both on the left of the current node, there must
   * be a smaller(lower) node as their ancestor on the left. As well as, if both p and q are greater than a node, then there
   * must be a bigger(lower) node as their ancestor on the right.
   */
  fun lowestCommonAncestorOfABST2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    fun dfs(node: TreeNode?): TreeNode? =
      when {
        node == null -> null
        p!!.`val` < node.`val` && q!!.`val` < node.`val` -> dfs(node.left)
        p.`val` > node.`val` && q!!.`val` > node.`val` -> dfs(node.right)
        else -> node
      }

    return dfs(root!!)
  }
}
