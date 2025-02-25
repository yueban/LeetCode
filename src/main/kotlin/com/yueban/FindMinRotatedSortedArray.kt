package com.yueban

import kotlin.math.min

object FindMinRotatedSortedArray {
  fun findMinRotatedSortedArray1(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    for (i in 1 until nums.size) {
      if (nums[i] < nums[i - 1]) {
        return nums[i]
      }
    }
    return nums[0]
  }

  fun findMinRotatedSortedArray2(nums: IntArray): Int {
    fun findMin(nums: IntArray, start: Int, end: Int): Int {
      if (start > end) return Int.MAX_VALUE
      if (start == end) return nums[start]
      val middle = (start + end) / 2
      return if (nums[middle] >= nums[0]) {
        findMin(nums, middle + 1, end)
      } else {
        min(findMin(nums, start, middle), nums[middle])
      }
    }

    if (nums.size == 1) return nums[0]
    return min(findMin(nums, 0, nums.size - 1), nums[0])
  }
}
