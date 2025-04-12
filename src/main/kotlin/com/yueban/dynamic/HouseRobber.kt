package com.yueban.dynamic

import kotlin.math.max

object HouseRobber {
  /**
   * `dp[i]` means the maximum amount of money you can rob till the ith house.
   */
  fun houseRobber1(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    if (nums.size == 2) return max(nums[0], nums[1])

    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])

    for (i in 2 until nums.size) {
      dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    }

    return dp[nums.size - 1]
  }
}
