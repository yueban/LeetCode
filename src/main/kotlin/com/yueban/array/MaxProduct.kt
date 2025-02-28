package com.yueban.array

import kotlin.math.max
import kotlin.math.min

object MaxProduct {
  fun maxProduct1(nums: IntArray): Int {
    var res = Int.MIN_VALUE
    for (n in nums) {
      res = max(res, n)
    }

    var curMax = 1
    var curMin = 1

    for (n in nums) {
      curMax = max(curMax * n, max((curMin * n), n))
      curMin = min(curMax * n, min((curMin * n), n))

      res = max(res, curMax)
    }

    return res
  }
}
