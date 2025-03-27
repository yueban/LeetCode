package com.yueban.tree

import kotlin.test.Test
import kotlin.test.assertTrue

class SerializeAndDeserializeBinaryTreeTest {
  private class TestCase(
    val root: TreeNode?,
    val result: TreeNode?,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(1, 2, 3, null, null, 4, 5).toTreeNode(),
      arrayOf(1, 2, 3, null, null, 4, 5).toTreeNode()
    ),
    TestCase(
      arrayOf<Int?>().toTreeNode(),
      arrayOf<Int?>().toTreeNode()
    ),
  )

  @Test
  fun serializeAndDeserializeBinaryTree1Test() {
    testCases.forEach { case ->
      val ser = SerializeAndDeserializeBinaryTree.Codec1()
      val deser = SerializeAndDeserializeBinaryTree.Codec1()
      val data = ser.serialize(case.root)
      val ans = deser.deserialize(data)
      assertTrue(areTreesEqual(case.result, ans))
    }
  }

  @Test
  fun serializeAndDeserializeBinaryTree2Test() {
    testCases.forEach { case ->
      val ser = SerializeAndDeserializeBinaryTree.Codec2()
      val deser = SerializeAndDeserializeBinaryTree.Codec2()
      val data = ser.serialize(case.root)
      val ans = deser.deserialize(data)
      assertTrue(areTreesEqual(case.result, ans))
    }
  }
}
