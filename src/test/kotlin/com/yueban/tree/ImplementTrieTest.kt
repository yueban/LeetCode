package com.yueban.tree

import com.yueban.tree.ImplementTrie.ImplementTrie1
import kotlin.test.Test
import kotlin.test.assertEquals

class ImplementTrieTest {
  private class TestCase(
    val commands: Array<String>,
    val arguments: Array<String?>,
    val outputs: Array<Boolean?>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf("Trie", "insert", "search", "search", "startsWith", "insert", "search"),
      arrayOf(null, "apple", "apple", "app", "app", "app", "app"),
      arrayOf(null, null, true, false, true, null, true)
    )
  )

  @Test
  fun implementTrie1Test() {
    testCases.forEach { case ->
      val obj: ImplementTrie = ImplementTrie1()
      for (i in 1 until case.commands.size) {
        when (case.commands[i]) {
          "insert" -> obj.insert(case.arguments[i]!!)
          "search" -> assertEquals(case.outputs[i], obj.search(case.arguments[i]!!))
          "startsWith" -> assertEquals(case.outputs[i], obj.startsWith(case.arguments[i]!!))
          else -> IllegalArgumentException("invalid command")
        }
      }
    }
  }
}
