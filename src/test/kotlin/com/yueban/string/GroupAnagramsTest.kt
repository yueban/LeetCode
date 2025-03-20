package com.yueban.string

import com.yueban.string.GroupAnagrams.groupAnagrams1
import com.yueban.string.GroupAnagrams.groupAnagrams2
import com.yueban.string.GroupAnagrams.groupAnagrams3
import kotlin.test.Test
import kotlin.test.assertEquals

class GroupAnagramsTest {
  private class TestCase(
    val strs: Array<String>,
    val result: List<List<String>>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
      listOf(
        listOf("bat"),
        listOf("nat", "tan"),
        listOf("ate", "eat", "tea")
      )
    ),
    TestCase(arrayOf(""), listOf(listOf(""))),
    TestCase(arrayOf("a"), listOf(listOf("a"))),
  )

  @Test
  fun groupAnagrams1Test() {
    testCases.forEach { case ->
      assertEquals(case.result.map { it.toSet() }.toSet(), groupAnagrams1(case.strs).map { it.toSet() }.toSet())
    }
  }

  @Test
  fun groupAnagrams2Test() {
    testCases.forEach { case ->
      assertEquals(case.result.map { it.toSet() }.toSet(), groupAnagrams2(case.strs).map { it.toSet() }.toSet())
    }
  }

  @Test
  fun groupAnagrams3Test() {
    testCases.forEach { case ->
      assertEquals(case.result.map { it.toSet() }.toSet(), groupAnagrams3(case.strs).map { it.toSet() }.toSet())
    }
  }
}
