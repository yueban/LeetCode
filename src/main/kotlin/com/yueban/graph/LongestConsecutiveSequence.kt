package com.yueban.graph

import kotlin.math.max

object LongestConsecutiveSequence {
  /**
   * convert nums to numSet to filter same numbers. use `l` and `r` to mark the boundaries of current longest consecutive
   * sequence. for each `nums[i]` in the iteration:
   *    1. if `nums[i] in (l,r)`, which means `nums[i]` has already been iterated by previous sequence, skip it.
   *    2. else, search numSet to find boundaries based on `nums[i]`.
   */
  fun longestConsecutiveSequence1(nums: IntArray): Int {
    val numSet = nums.toSet()

    var result = 0
    var l = Int.MIN_VALUE
    var r = Int.MIN_VALUE
    var count: Int

    for (i in 0 until nums.size) {
      if (nums[i] in l + 1 until r) continue

      l = nums[i]
      r = nums[i]
      count = 1
      while (numSet.contains(--l)) {
        count++
      }
      while (numSet.contains(++r)) {
        count++
      }
      result = max(result, count)
    }

    return result
  }

  fun longestConsecutiveSequence2(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    nums.sort()

    var result = 0
    var count = 1

    for (i in 1 until nums.size) {
      when (nums[i]) {
        nums[i - 1] -> continue
        nums[i - 1] + 1 -> count++
        else -> {
          result = max(result, count)
          count = 1
        }
      }
    }

    return max(result, count)
  }
}
