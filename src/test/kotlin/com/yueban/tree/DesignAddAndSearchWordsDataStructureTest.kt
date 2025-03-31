package com.yueban.tree

import com.yueban.tree.DesignAddAndSearchWordsDataStructure.DesignAddAndSearchWordsDataStructure1
import com.yueban.tree.DesignAddAndSearchWordsDataStructure.DesignAddAndSearchWordsDataStructure2
import kotlin.test.Test
import kotlin.test.assertEquals

class DesignAddAndSearchWordsDataStructureTest {
  private class TestCase(
    val commands: Array<String>,
    val arguments: Array<String?>,
    val outputs: Array<Boolean?>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf("WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"),
      arrayOf(null, "bad", "dad", "mad", "pad", "bad", ".ad", "b.."),
      arrayOf(null, null, null, null, false, true, true, true)
    )
  )

  @Test
  fun designAddAndSearchWordsDataStructure1Test() {
    testCases.forEach { case ->
      val obj: DesignAddAndSearchWordsDataStructure = DesignAddAndSearchWordsDataStructure1()
      for (i in 1 until case.commands.size) {
        println("${case.commands[i]}, ${case.arguments[i]}, ${case.outputs[i]}")
        when (case.commands[i]) {
          "addWord" -> obj.addWord(case.arguments[i]!!)
          "search" -> assertEquals(case.outputs[i], obj.search(case.arguments[i]!!))
          else -> IllegalArgumentException("illegal command")
        }
      }
    }
  }

  @Test
  fun designAddAndSearchWordsDataStructure2Test() {
    testCases.forEach { case ->
      val obj: DesignAddAndSearchWordsDataStructure = DesignAddAndSearchWordsDataStructure2()
      for (i in 1 until case.commands.size) {
        println("${case.commands[i]}, ${case.arguments[i]}, ${case.outputs[i]}")
        when (case.commands[i]) {
          "addWord" -> obj.addWord(case.arguments[i]!!)
          "search" -> assertEquals(case.outputs[i], obj.search(case.arguments[i]!!))
          else -> IllegalArgumentException("illegal command")
        }
      }
    }
  }
}
