package com.yueban.heap

import java.util.*

object TopKFrequentElements {
  fun topKFrequentElements1(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEach { n ->
      map[n] = map.getOrPut(n) { 0 } + 1
    }
    return map.entries.sortedByDescending { it.value }.take(k).map { it.key }.toIntArray()
  }

  /**
   * use a priority queue to optimize result filtering.
   */
  fun topKFrequentElements2(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEach { n ->
      map[n] = map.getOrPut(n) { 0 } + 1
    }

    val queue = PriorityQueue<Map.Entry<Int, Int>>(compareBy { it.value })
    map.forEach {
      queue.offer(it)
      if (queue.size > k) queue.poll()
    }

    return queue.map { it.key }.reversed().toIntArray()
  }

  /**
   * use a bucket(count, numsOfCount) to optimize result filtering.
   */
  fun topKFrequentElements3(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEach { n ->
      map[n] = map.getOrPut(n) { 0 } + 1
    }

    val bucket = Array(nums.size + 1) { mutableListOf<Int>() }
    map.forEach {
      bucket[it.value] += it.key
    }

    val result = IntArray(k)
    var count = 0
    for (i in bucket.size - 1 downTo 0) {
      bucket[i].forEach {
        result[count++] = it
        if (count == k) return result
      }
    }

    return result
  }
}
