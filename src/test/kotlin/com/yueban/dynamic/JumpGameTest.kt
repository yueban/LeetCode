package com.yueban.dynamic

import com.yueban.dynamic.JumpGame.jumpGame1
import com.yueban.dynamic.JumpGame.jumpGame2
import com.yueban.dynamic.JumpGame.jumpGame3
import kotlin.test.Test
import kotlin.test.assertEquals

class JumpGameTest {
  class TestCase(
    val nums: IntArray,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(2, 3, 1, 1, 4), true),
    TestCase(intArrayOf(3, 2, 1, 0, 4), false),
  )

  @Test
  fun jumpGame1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, jumpGame1(case.nums))
    }
  }

  @Test
  fun jumpGame2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, jumpGame2(case.nums))
    }
  }

  @Test
  fun jumpGame3Test() {
    testCases.forEach { case ->
      assertEquals(case.result, jumpGame3(case.nums))
    }
  }
}
