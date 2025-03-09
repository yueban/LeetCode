package com.yueban.dynamic

import com.yueban.dynamic.DecodeWays.decodeWays1
import com.yueban.dynamic.DecodeWays.decodeWays2
import kotlin.test.Test
import kotlin.test.assertEquals

class DecodeWaysTest {
  class TestCase(
    val s: String,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase("12", 2),
    TestCase("226", 3),
    TestCase("06", 0),
    TestCase("111111111111111111111111111111111111111111111", 1836311903),
  )

  @Test
  fun decodeWays1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, decodeWays1(case.s))
    }
  }

  @Test
  fun decodeWays2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, decodeWays2(case.s))
    }
  }
}
