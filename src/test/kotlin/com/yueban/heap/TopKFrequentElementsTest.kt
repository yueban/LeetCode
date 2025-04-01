package com.yueban.heap

import com.yueban.heap.TopKFrequentElements.topKFrequentElements1
import com.yueban.heap.TopKFrequentElements.topKFrequentElements2
import com.yueban.heap.TopKFrequentElements.topKFrequentElements3
import kotlin.test.Test
import kotlin.test.assertContentEquals

class TopKFrequentElementsTest {
  private class TestCase(
    val nums: IntArray,
    val k: Int,
    val result: IntArray,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 1, 1, 2, 2, 3), 2, intArrayOf(1, 2)),
    TestCase(intArrayOf(1), 1, intArrayOf(1)),
  )

  @Test
  fun topKFrequentElements1Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, topKFrequentElements1(case.nums, case.k))
    }
  }

  @Test
  fun topKFrequentElements2Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, topKFrequentElements2(case.nums, case.k))
    }
  }

  @Test
  fun topKFrequentElements3Test() {
    testCases.forEach { case ->
      assertContentEquals(case.result, topKFrequentElements3(case.nums, case.k))
    }
  }
}
