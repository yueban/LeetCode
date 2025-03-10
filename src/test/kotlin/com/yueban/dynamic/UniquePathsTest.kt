package com.yueban.dynamic

import com.yueban.dynamic.UniquePaths.uniquePaths1
import com.yueban.dynamic.UniquePaths.uniquePaths2
import kotlin.test.Test
import kotlin.test.assertEquals

class UniquePathsTest {
  class TestCase(
    val m: Int,
    val n: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(3, 7, 28),
    TestCase(3, 2, 3),
    TestCase(51, 9, 1916797311),
  )

  @Test
  fun uniquePaths1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, uniquePaths1(case.m, case.n))
    }
  }

  @Test
  fun uniquePaths2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, uniquePaths2(case.m, case.n))
    }
  }
}
