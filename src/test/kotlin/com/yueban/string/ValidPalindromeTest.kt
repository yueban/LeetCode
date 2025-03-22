package com.yueban.string

import com.yueban.string.ValidPalindrome.validPalindrome1
import com.yueban.string.ValidPalindrome.validPalindrome2
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidPalindromeTest {
  private class TestCase(
    val s: String,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase("A man, a plan, a canal: Panama", true),
    TestCase("race a car", false),
    TestCase(" ", true),
  )

  @Test
  fun validPalindrome1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validPalindrome1(case.s))
    }
  }

  @Test
  fun validPalindrome2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validPalindrome2(case.s))
    }
  }
}
