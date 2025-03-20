package com.yueban.string

import com.yueban.string.ValidAnagram.validAnagram1
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidAnagramTest {
  private class TestCase(
    val s: String,
    val t: String,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase("anagram", "nagaram", true),
    TestCase("rat", "car", false),
  )

  @Test
  fun validAnagram1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validAnagram1(case.s, case.t))
    }
  }
}
