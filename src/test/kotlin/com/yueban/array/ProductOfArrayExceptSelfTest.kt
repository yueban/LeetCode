package com.yueban.array

import com.yueban.array.ProductOfArrayExceptSelf.productOfArrayExceptSelf1
import com.yueban.array.ProductOfArrayExceptSelf.productOfArrayExceptSelf2
import com.yueban.array.ProductOfArrayExceptSelf.productOfArrayExceptSelf3
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ProductOfArrayExceptSelfTest {
  private class TestCase(
    val nums: IntArray,
    val result: IntArray,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 4), intArrayOf(24, 12, 8, 6)),
    TestCase(intArrayOf(-1, 1, 0, -3, 3), intArrayOf(0, 0, 9, 0, 0))
  )

  @Test
  fun productOfArrayExceptSelf1Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, productOfArrayExceptSelf1(case.nums))
    }
  }

  @Test
  fun productOfArrayExceptSelf2Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, productOfArrayExceptSelf2(case.nums))
    }
  }

  @Test
  fun productOfArrayExceptSelf3Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, productOfArrayExceptSelf3(case.nums))
    }
  }
}
