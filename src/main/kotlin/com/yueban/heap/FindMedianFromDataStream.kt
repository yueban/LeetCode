package com.yueban.heap

import java.util.*

interface FindMedianFromDataStream {
  fun addNum(num: Int)
  fun findMedian(): Double

  class FindMedianFromDataStream1 : FindMedianFromDataStream {
    private val smallerQueue = PriorityQueue<Int>(compareByDescending { it })
    private val largerQueue = PriorityQueue<Int>()

    override fun addNum(num: Int) {
      if (smallerQueue.isEmpty() || num < smallerQueue.peek()) {
        smallerQueue.offer(num)
      } else {
        largerQueue.offer(num)
      }

      // balance two queues, ensure (smallerQueue.size == largerQueue.size) or (smallerQueue.size == largerQueue.size + 1)
      if (smallerQueue.size > largerQueue.size + 1) {
        largerQueue.offer(smallerQueue.poll())
      } else if (largerQueue.size > smallerQueue.size) {
        smallerQueue.offer(largerQueue.poll())
      }
    }

    override fun findMedian(): Double {
      return if ((largerQueue.size + smallerQueue.size) % 2 == 0) {
        (smallerQueue.peek() + largerQueue.peek()) * 1.0 / 2
      } else {
        smallerQueue.peek().toDouble()
      }
    }
  }

  /**
   * specific for all integer numbers from the stream are in the range [0, 100]
   */
  class FindMedianFromDataStream2 : FindMedianFromDataStream {
    private val count = IntArray(101)
    private var total = 0

    override fun addNum(num: Int) {
      count[num]++
      total++
    }

    override fun findMedian(): Double {
      val index1 = (total + 1) / 2 // first middle, or single middle if odd
      val index2 = total / 2 + 1 // second middle

      var median1 = -1
      var median2 = -1

      var currentCount = 0
      for (i in 0 until count.size) {
        currentCount += count[i]
        if (currentCount >= index1 && median1 == -1) {
          median1 = i
        }
        if (currentCount >= index2) {
          median2 = i
          break
        }
      }

      return if (total % 2 == 0) {
        (median1 + median2) * 1.0 / 2
      } else {
        median1.toDouble()
      }
    }
  }
}
