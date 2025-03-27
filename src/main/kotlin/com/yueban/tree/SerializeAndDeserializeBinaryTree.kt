package com.yueban.tree

import java.util.*

object SerializeAndDeserializeBinaryTree {
  class Codec1 {
    fun serialize(root: TreeNode?): String {
      if (root == null) return ""

      val queue = LinkedList<TreeNode?>()
      queue.add(root)
      val result = StringBuilder()

      while (queue.isNotEmpty()) {
        val node = queue.poll()
        result.append(node?.`val` ?: "null")
        result.append(",")
        node?.let {
          queue.add(it.left)
          queue.add(it.right)
        }
      }

      return result.toString()
    }

    fun deserialize(data: String): TreeNode? {
      val tree = data.split(",").map { it.toIntOrNull() }.toTypedArray().toTreeNode()
      return tree
    }

    private fun Array<Int?>.toTreeNode(): TreeNode? {
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
  }

  class Codec2 {
    fun serialize(root: TreeNode?): String {
      val result = StringBuilder()

      fun dfs(node: TreeNode?) {
        node ?: run {
          result.append(".,")
          return
        }

        result.append("${node.`val`},")
        dfs(node.left)
        dfs(node.right)
      }

      dfs(root)

      return result.toString()
    }

    fun deserialize(data: String): TreeNode? {
      var i = 0

      fun dfs(): TreeNode? {
        val index = data.indexOf(',', i)
        val value = data.substring(i, index)
        i = index + 1

        if (value == ".") return null
        val node = TreeNode(value.toInt())
        node.left = dfs()
        node.right = dfs()
        return node
      }

      return dfs()
    }
  }
}
