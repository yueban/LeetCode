package com.yueban.dynamic

import kotlin.math.max

object HouseRobberII {
  /**
   * dp\[i\] means the maximum amount of money you can rob till the ith house.
   * dp1 starts from nums[0] to nums[n-2]. dp2 starts from nums[1] to nums[n-1].
   */
  fun houseRobberII1(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    if (nums.size == 2) return max(nums[0], nums[1])
    if (nums.size == 3) return maxOf(nums[0], nums[1], nums[2])

    val dp1 = IntArray(nums.size)
    val dp2 = IntArray(nums.size)
    dp1[0] = nums[0]
    dp1[1] = max(nums[0], nums[1])
    dp2[0] = nums[1]
    dp2[1] = max(nums[1], nums[2])

    for (i in 2 until nums.size - 1) {
      dp1[i] = max(dp1[i - 1], dp1[i - 2] + nums[i])
      dp2[i] = max(dp2[i - 1], dp2[i - 2] + nums[i + 1])
    }

    return max(dp1[nums.size - 2], dp2[nums.size - 2])
  }
}
