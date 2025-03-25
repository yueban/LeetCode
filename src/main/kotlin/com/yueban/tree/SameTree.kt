package com.yueban.tree

object SameTree {
  fun sameTree1(p: TreeNode?, q: TreeNode?): Boolean =
    when {
      p == null && q == null -> true
      else -> p?.`val` == q?.`val` && sameTree1(p?.left, q?.left) && sameTree1(p?.right, q?.right)
    }
}
