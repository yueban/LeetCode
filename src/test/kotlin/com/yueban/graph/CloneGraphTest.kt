package com.yueban.graph

import com.yueban.graph.CloneGraph.cloneGraph1
import com.yueban.graph.CloneGraph.cloneGraph2
import kotlin.test.Test

class CloneGraphTest {
  class TestCase(
    val node: Node?,
    val result: Node?,
  )

  private val testCases = listOf(
    TestCase(createTestCase1(), createTestCase1()),
    TestCase(Node(1), Node(1)),
    TestCase(null, null),
  )

  private fun Array<IntArray>.toNode(): Node? {
    if (isEmpty()) return null

    val nodeMap = indices.associate { it + 1 to Node(it + 1) }

    forEachIndexed { index, neighbors ->
      neighbors.forEach { neighborVal ->
        val neighborNode = nodeMap[neighborVal]
        nodeMap[index + 1]!!.neighbors.add(neighborNode)
      }
    }

    return nodeMap[1]
  }

  private fun createTestCase1(): Node? =
    arrayOf(intArrayOf(2, 4), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(1, 3)).toNode()

  @Test
  fun cloneGraph1Test() {
    testCases.forEach { case ->
      assert(areGraphsEqual(case.result, cloneGraph1(case.node)))
    }
  }

  @Test
  fun cloneGraph2Test() {
    testCases.forEach { case ->
      assert(areGraphsEqual(case.result, cloneGraph2(case.node)))
    }
  }
}

private fun areGraphsEqual(node1: Node?, node2: Node?): Boolean {
  if (node1 == null && node2 == null) return true
  if (node1 == null || node2 == null) return false
  if (node1.`val` != node2.`val`) return false

  val visited = mutableSetOf<Node>()
  return dfsCompare(node1, node2, visited)
}

private fun dfsCompare(node1: Node?, node2: Node?, visited: MutableSet<Node>): Boolean {
  if (node1 == null || node2 == null) return node1 == node2
  if (node1.`val` != node2.`val`) return false
  if (visited.contains(node1)) return true // Already visited

  visited.add(node1)

  // Check neighbors
  if (node1.neighbors.size != node2.neighbors.size) return false

  for (i in node1.neighbors.indices) {
    if (!dfsCompare(node1.neighbors[i], node2.neighbors[i], visited)) {
      return false
    }
  }
  return true
}
