package com.yueban.tree

object ConstructBinaryTreeFromPreorderAndInorderTraversal {
  /**
   * 1. preorder always starts with the root node, so we can divide it into subtrees(preStart, preEnd), every preStart is the root of a subtree.
   * 2. every node in inorder always has a smaller index to all its right nodes, so we can divide it into subtrees(inStart, inEnd).
   * 3. first we pick the root of subtree from preorder(preStart), then we search the index of it in inorder as rootIndex,
   * so that we use rootIndex to separate inorder into two subtrees. besides, we know the size of two subtrees.
   * 4. for preorder, as we have already known the size of two subtrees and preorder always starts from a root node of the subtree and then traverse the left part first.
   * so we can deduce the left subtree of preorder[preStart + 1, preStart + leftSize], as well as the right part preorder[preEnd + rightSize +1, preEnd].
   * (+1 means omitting the subtree root itself)
   */
  fun constructBinaryTreeFromPreorderAndInorderTraversal1(preorder: IntArray, inorder: IntArray): TreeNode? {
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    fun buildTree(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
      if (preStart > preEnd || inStart > inEnd) return null
      if (preStart == preEnd || inStart == inEnd) return TreeNode(inorder[inStart])

      val root = TreeNode(preorder[preStart])

      val rootIndex = inorderMap[preorder[preStart]]!!

      val leftSize = rootIndex - inStart
      val rightSize = inEnd - rootIndex

      root.left = buildTree(preStart + 1, preStart + leftSize, inStart, rootIndex - 1)
      root.right = buildTree(preEnd - rightSize + 1, preEnd, rootIndex + 1, inEnd)

      return root
    }

    return buildTree(0, preorder.size - 1, 0, inorder.size - 1)
  }

  /**
   * prioritize building the nodes on the left side.
   */
  fun constructBinaryTreeFromPreorderAndInorderTraversal2(preorder: IntArray, inorder: IntArray): TreeNode? {
    var count = 0
    var i = 0

    fun helper(stop: Int): TreeNode? {
      // check if all nodes have been traversed
      if (count >= preorder.size) return null

      // stop is actually the value of root node iterating from preorder array.
      // compare it to inorder(which always start from left node) to ensure always building to most left nodes.
      // only if the current left node(which is inorder[i]) can be the child of the root node(which is stop), we make i++
      // to wait for next inorder[i] can be child of next root node. and return null to denote that left part of current
      // root node(stop) is completely traversed.
      if (inorder[i] == stop) {
        i++
        return null
      }

      // construct node
      val node = TreeNode(preorder[count++])
      // ensure building the left nodes first
      node.left = helper(node.`val`)
      node.right = helper(stop)
      return node
    }

    return helper(Int.MIN_VALUE)
  }
}
