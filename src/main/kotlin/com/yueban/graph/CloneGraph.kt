package com.yueban.graph

object CloneGraph {
  fun cloneGraph1(node: Node?): Node? {
    if (node == null) return null

    val nodeMap = mutableMapOf<Int, Node>()
    val neighborsMap = mutableMapOf<Int, IntArray>()

    // parse all nodes into nodeMap and neighborsMap separately
    fun parseNode(curNode: Node) {
      if (nodeMap.containsKey(curNode.`val`)) {
        return
      }
      nodeMap[curNode.`val`] = Node(curNode.`val`)
      if (curNode.neighbors.isNotEmpty()) {
        val neighborsArray = IntArray(curNode.neighbors.size)
        neighborsMap[curNode.`val`] = neighborsArray
        curNode.neighbors.forEachIndexed { index, n ->
          parseNode(n!!)
          neighborsArray[index] = n.`val`
        }
      }
    }

    parseNode(node)

    // add neighbors nodes to nodes in Map
    nodeMap.forEach { (i, n) ->
      n.neighbors.addAll(neighborsMap[i]?.map { nodeMap[it] } ?: listOf())
    }

    return nodeMap[1]
  }

  fun cloneGraph2(node: Node?): Node? {
    if (node == null) return null

    val nodeMap = mutableMapOf<Int, Node>()

    fun dfs(n: Node): Node {
      return nodeMap[n.`val`] ?: Node(n.`val`).also { clonedNode ->
        nodeMap[n.`val`] = clonedNode

        n.neighbors.forEach {
          clonedNode.neighbors.add(dfs(it!!))
        }
      }
    }

    return dfs(node)
  }
}
