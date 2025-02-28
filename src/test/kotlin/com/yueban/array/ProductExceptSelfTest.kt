package com.yueban.array

import com.yueban.array.ProductExceptSelf.productExceptSelf1
import com.yueban.array.ProductExceptSelf.productExceptSelf2
import com.yueban.array.ProductExceptSelf.productExceptSelf3
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ProductExceptSelfTest {
  class TestCase(
    val nums: IntArray,
    val result: IntArray,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 4), intArrayOf(24, 12, 8, 6)),
    TestCase(intArrayOf(-1, 1, 0, -3, 3), intArrayOf(0, 0, 9, 0, 0))
  )

  @Test
  fun containsDuplicate1Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, productExceptSelf1(case.nums))
    }
  }

  @Test
  fun containsDuplicate2Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, productExceptSelf2(case.nums))
    }
  }

  @Test
  fun containsDuplicate3Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, productExceptSelf3(case.nums))
    }
  }
}
