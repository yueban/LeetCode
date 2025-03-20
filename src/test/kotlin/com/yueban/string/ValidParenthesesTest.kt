package com.yueban.string

import com.yueban.string.ValidParentheses.validParentheses1
import com.yueban.string.ValidParentheses.validParentheses2
import com.yueban.string.ValidParentheses.validParentheses3
import com.yueban.string.ValidParentheses.validParentheses4
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidParenthesesTest {
  private class TestCase(
    val s: String,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase("()", true),
    TestCase("()[]{}", true),
    TestCase("(]", false),
    TestCase("([])", true),
  )

  @Test
  fun validParentheses1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validParentheses1(case.s))
    }
  }

  @Test
  fun validParentheses2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validParentheses2(case.s))
    }
  }

  @Test
  fun validParentheses3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validParentheses3(case.s))
    }
  }

  @Test
  fun validParentheses4Test() {
    testCases.forEach { case ->
      assertEquals(case.result, validParentheses4(case.s))
    }
  }
}
