package com.yueban.dynamic

import com.yueban.dynamic.ClimbingStairs.climbingStairs1
import com.yueban.dynamic.ClimbingStairs.climbingStairs2
import com.yueban.dynamic.ClimbingStairs.climbingStairs3
import com.yueban.dynamic.ClimbingStairs.climbingStairs4
import kotlin.test.Test
import kotlin.test.assertEquals

class ClimbingStairsTest {
  private class TestCase(
    val n: Int,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(2, 2),
    TestCase(3, 3),
    TestCase(45, 1836311903),
  )

  @Test
  fun climbingStairs1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, climbingStairs1(case.n))
    }
  }

  @Test
  fun climbingStairs2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, climbingStairs2(case.n))
    }
  }

  @Test
  fun climbingStairs3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, climbingStairs3(case.n))
    }
  }

  @Test
  fun climbingStairs4Test() {
    testCases.forEach { case ->
      assertEquals(case.result, climbingStairs4(case.n))
    }
  }
}
