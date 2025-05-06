package com.yueban.array

import kotlin.math.max

object MaximumProductSubarray {
  fun maximumProductSubarray1(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    var curMax = 1
    var curMin = 1

    for (n in nums) {
      val temp = curMax * n
      curMax = maxOf(temp, curMin * n, n)
      curMin = minOf(temp, curMin * n, n)
      result = max(result, curMax)
    }

    return result
  }
}
