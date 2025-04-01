package com.yueban.heap

import com.yueban.heap.FindMedianFromDataStream.FindMedianFromDataStream1
import com.yueban.heap.FindMedianFromDataStream.FindMedianFromDataStream2
import kotlin.test.Test
import kotlin.test.assertEquals

class FindMedianFromDataStreamTest {
  private class TestCase(
    val commands: Array<String>,
    val arguments: Array<Int?>,
    val outputs: Array<Double?>,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf("MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"),
      arrayOf(null, 1, 2, null, 3, null),
      arrayOf(null, null, null, 1.5, null, 2.0),
    ),
  )

  @Test
  fun findMedianFromDataStream1Test() {
    testCases.forEach { case ->
      val finder: FindMedianFromDataStream = FindMedianFromDataStream1()
      for (i in 1 until case.commands.size) {
        when (case.commands[i]) {
          "addNum" -> finder.addNum(case.arguments[i]!!)
          "findMedian" -> assertEquals(case.outputs[i], finder.findMedian())
        }
      }
    }
  }

  @Test
  fun findMedianFromDataStream2Test() {
    testCases.forEach { case ->
      val finder: FindMedianFromDataStream = FindMedianFromDataStream2()
      for (i in 1 until case.commands.size) {
        when (case.commands[i]) {
          "addNum" -> finder.addNum(case.arguments[i]!!)
          "findMedian" -> assertEquals(case.outputs[i], finder.findMedian())
        }
      }
    }
  }
}
