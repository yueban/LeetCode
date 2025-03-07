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
   *    For input nums [1,3,5,2,4], if current lis is [1,3,5] and nums[i] is 2, the result of lis after binarySearch will be [1,2,5]
   *    then next nums[i] is 4, the result of lis after binarySearch will be [1,2,4].
   *    So lis maintains a valid subsequence for each lis[0]...lis[ptr] which means lis[0] is the smallest valid longest increasing subsequence of length 1,
   *    as well as lis[1]...lis[ptr] represents the smallest valid longest increasing subsequence of length 2...ptr+1.
   *    So the key point of binarySearch is to make sure lis always represents the **smallest** valid longest increasing subsequence.
   */
  fun longestIncreasingSubsequence2(nums: IntArray): Int {
    val lis = IntArray(nums.size)
    lis[0] = nums[0]
    var ptr = 0

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
