package com.yueban.interval

object NonOverlappingIntervals {
  private var IntArray.start
    get() = get(0)
    set(value) = set(0, value)
  private var IntArray.end
    get() = get(1)
    set(value) = set(1, value)

  fun nonOverlappingIntervals1(intervals: Array<IntArray>): Int {
    if (intervals.size <= 1) return 0

    intervals.sortBy { it.start }

    var count = 0

    var prevInterval = intervals[0]
    for (i in 1 until intervals.size) {
      when {
        // current one start is larger than previous one end, non-overlapping
        prevInterval.end <= intervals[i].start -> prevInterval = intervals[i]
        // else, which means current one is over-lapped with previous one, we need remove one of them, so count++.
        // always remove the one with larger end. and track the remaining one with prevInterval.
        prevInterval.end <= intervals[i].end -> count++
        else -> {
          prevInterval = intervals[i]
          count++
        }
      }
    }

    return count
  }
}
