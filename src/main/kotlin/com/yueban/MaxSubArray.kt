package com.yueban

import kotlin.math.max

object MaxSubArray {
  fun maxSubArray1(nums: IntArray): Int {
    var sum = Int.MIN_VALUE
    for (i in 0 until nums.size) {
      for (j in i until nums.size) {
        var tempSum = 0
        for (k in i..j) {
          tempSum += nums[k]
        }
        sum = max(sum, tempSum)
      }
    }
    return sum
  }

  fun maxSubArray2(nums: IntArray): Int {
    var sum = Int.MIN_VALUE
    for (i in 0 until nums.size) {
      var tempSum = 0
      for (j in i until nums.size) {
        tempSum += nums[j]
        sum = max(sum, tempSum)
      }
    }
    return sum
  }

  fun maxSubArray3(nums: IntArray): Int {
    var sum = nums[0]
    var tempSum = 0
    nums.forEach { num ->
      if (tempSum < 0) tempSum = 0
      tempSum += num
      sum = max(sum, tempSum)
    }
    return sum
  }

  fun maxSubArray4(nums: IntArray): Int {
    fun maxCrossingSum(nums: IntArray, start: Int, middle: Int, end: Int): Int {
      var sum = 0
      var leftSum = Int.MIN_VALUE

      for (i in middle downTo start) {
        sum += nums[i]
        if (sum > leftSum) leftSum = sum
      }

      sum = 0
      var rightSum = Int.MIN_VALUE
      for (i in middle + 1..end) {
        sum += nums[i]
        if (sum > rightSum) rightSum = sum
      }

      return leftSum + rightSum
    }

    fun maxSubSum(nums: IntArray, start: Int, end: Int): Int {
      if (start > end) return Int.MIN_VALUE
      if (start == end) return nums[start]
      val middle = (start + end) / 2
      val leftSum = maxSubSum(nums, start, middle)
      val rightSum = maxSubSum(nums, middle + 1, end)
      val crossingSum = maxCrossingSum(nums, start, middle, end)
      return max(max(leftSum, rightSum), crossingSum)
    }

    return maxSubSum(nums, 0, nums.size - 1)
  }
}
