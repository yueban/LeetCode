package com.yueban.array

import kotlin.math.max

object MaxProduct {
  fun maxProduct1(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    for (n in nums) {
      result = max(result, n)
    }

    var curMax = 1
    var curMin = 1

    for (n in nums) {
      curMax = maxOf(curMax * n, curMin * n, n)
      curMin = minOf(curMax * n, curMin * n, n)

      result = max(result, curMax)
    }

    return result
  }
}
