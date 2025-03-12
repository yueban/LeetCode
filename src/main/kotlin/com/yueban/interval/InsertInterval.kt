package com.yueban.interval

import kotlin.math.max
import kotlin.math.min

object InsertInterval {
  private var IntArray.start
    get() = get(0)
    set(value) = set(0, value)
  private var IntArray.end
    get() = get(1)
    set(value) = set(1, value)

  fun insertInterval1(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()

    var i = 0
    while (i < intervals.size && intervals[i].end < newInterval.start) {
      result.add(intervals[i])
      i++
    }

    val mergedInterval = newInterval.copyOf()
    while (i < intervals.size && intervals[i].start <= mergedInterval.end) {
      mergedInterval.start = min(mergedInterval.start, intervals[i].start)
      mergedInterval.end = max(mergedInterval.end, intervals[i].end)
      i++
    }
    result.add(mergedInterval)

    while (i < intervals.size) {
      result.add(intervals[i])
      i++
    }

    return result.toTypedArray()
  }
}
