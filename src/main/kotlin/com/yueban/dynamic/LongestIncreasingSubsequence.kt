package com.yueban.dynamic

import kotlin.math.max

object LongestIncreasingSubsequence {
  fun longestIncreasingSubsequence1(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }
    var result = 1

    for (i in 1 until nums.size) {
      for (j in 0 until i) {
        if (nums[i] > nums[j]) {
          dp[i] = max(dp[i], dp[j] + 1)
        }
      }
      result = max(result, dp[i])
    }

    return result
  }

  /**
   * lis is not the current longest increasing subsequence.
   * lis maintains a list of “buckets” where each bucket represents a valid subsequence.
   * eg.
   *    For input nums [1,3,5,2,4].
   *    Firstly, set `lis[0] = nums[0] = 1` and `ptr = 0`.
   *    Then start iterating nums from index 1:
   *      for `nums[1]`, `nums[1] > lis[0]`, so `lis[1] = nums[1] = 3` and `ptr = 1`
   *      for `nums[2]`, `nums[2] > lis[1]`, so `lis[2] = nums[2] = 5` and `ptr = 2`
   *      for `nums[3]`, `nums[3] < lis[2]`, find the smallest number that larger than `nums[3]` which is `lis[1]`, and replace it with `nums[3]`,
   *      so `lis[1] = nums[3] = 2` and `ptr = 2`.
   *      for `nums[4]`, `nums[4] < lis[2]`, find the smallest number that larger than `nums[4]` which is `lis[2]`, and replace it with `nums[4]`,
   *      so `lis[2] = nums[4] = 4` and `ptr = 2`.
   *
   * So lis literally represents the possibly smallest number for a increasing subsequence. which means `lis[0]` is the
   * smallest increasing subsequence of length 1. `lis[0], lis[1]` is the smallest increasing subsequence of length 2.
   * `lis[0]...lis[n]` is the smallest increasing subsequence of length n+1.
   *
   * Thus, the longest increasing subsequence is `lis[0]...lis[ptr]`, and its length is ptr + 1.
   */
  fun longestIncreasingSubsequence2(nums: IntArray): Int {
    val lis = IntArray(nums.size)
    lis[0] = nums[0]

    fun binarySearchAndReplace(r: Int, target: Int) {
      var left = 0
      var right = r
      while (left <= right) {
        val mid = left + (right - left) / 2
        if (lis[mid] == target) return
        if (lis[mid] > target) {
          right = mid - 1
        } else {
          left = mid + 1
        }
      }
      lis[left] = target
    }

    var ptr = 0
    for (i in 1 until nums.size) {
      if (lis[ptr] < nums[i]) {
        ptr += 1
        lis[ptr] = nums[i]
      } else {
        binarySearchAndReplace(ptr, nums[i])
      }
    }
    return ptr + 1
  }
}
