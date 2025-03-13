package com.yueban.interval

import kotlin.math.max

object MergeIntervals {
  private var IntArray.start
    get() = get(0)
    set(value) = set(0, value)
  private var IntArray.end
    get() = get(1)
    set(value) = set(1, value)

  fun mergeIntervals1(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size <= 1) return intervals

    intervals.sortBy { it.start }

    val result = mutableListOf<IntArray>()
    var mergedInterval = intervals[0]

    for (i in 1 until intervals.size) {
      if (intervals[i].start <= mergedInterval.end) {
        mergedInterval.end = max(intervals[i].end, mergedInterval.end)
      } else {
        result.add(mergedInterval)
        mergedInterval = intervals[i]
      }
    }

    result.add(mergedInterval)

    return result.toTypedArray()
  }
}
