package com.yueban.dynamic

object JumpGame {
  /**
   * brutal way to solve the problem, O(n^n)
   */
  fun jumpGame1(nums: IntArray): Boolean {

    fun jumpGame(index: Int): Boolean {
      if (index == nums.size - 1) return true
      if (nums[index] == 0) return false
      for (i in 1..nums[index]) {
        if (jumpGame(index + i)) return true
      }
      return false
    }

    return jumpGame(0)
  }

  /**
   * O(n^2)
   */
  fun jumpGame2(nums: IntArray): Boolean {
    val dp = BooleanArray(nums.size)
    dp[nums.size - 1] = true

    for (i in nums.size - 2 downTo 0) {
      if (nums[i] == 0) continue

      for (j in 1..nums[i]) {
        if (i + j < nums.size && dp[i + j]) {
          dp[i] = true
          break
        }
      }
    }

    return dp[0]
  }

  /**
   * O(n)
   *
   * targetIndex represents the leftmost position from which you can reach (or jump over) the current "target" position.
   * Initially, it's set to the last array index, since that’s our final goal.
   *
   * we iterate the array from right-to-left. For each index i, it checks `i + nums[i] >= targetIndex`, to determine
   * if from that position you can reach the current targetIndex.
   */
  fun jumpGame3(nums: IntArray): Boolean {
    var targetIndex = nums.size - 1

    for (i in targetIndex - 1 downTo 0) {
      if (nums[i] + i >= targetIndex) targetIndex = i
    }

    return targetIndex == 0
  }
}
