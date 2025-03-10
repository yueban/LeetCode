package com.yueban.graph

import com.yueban.graph.CloneGraph.cloneGraph1
import com.yueban.graph.CloneGraph.cloneGraph2
import kotlin.test.Test
import kotlin.test.assertEquals

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
      assertEquals(case.result, cloneGraph1(case.node))
    }
  }

  @Test
  fun cloneGraph2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, cloneGraph2(case.node))
    }
  }
}
