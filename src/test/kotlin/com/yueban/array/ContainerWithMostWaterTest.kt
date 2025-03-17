package com.yueban.array

import com.yueban.array.ContainerWithMostWater.containerWithMostWater1
import com.yueban.array.ContainerWithMostWater.containerWithMostWater2
import com.yueban.array.ContainerWithMostWater.containerWithMostWater3
import kotlin.test.Test
import kotlin.test.assertEquals

class ContainerWithMostWaterTest {
  private class TestCase(
    val height: IntArray,
    val result: Int,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49),
    TestCase(intArrayOf(1, 1), 1),
    TestCase(intArrayOf(2, 3, 4, 5, 18, 17, 6), 17),
  )

  @Test
  fun containerWithMostWaterTest1() {
    testCases.forEach { case ->
      assertEquals(case.result, containerWithMostWater1(case.height))
    }
  }

  @Test
  fun containerWithMostWaterTest2() {
    testCases.forEach { case ->
      assertEquals(case.result, containerWithMostWater2(case.height))
    }
  }

  @Test
  fun containerWithMostWaterTest3() {
    testCases.forEach { case ->
      assertEquals(case.result, containerWithMostWater3(case.height))
    }
  }
}
