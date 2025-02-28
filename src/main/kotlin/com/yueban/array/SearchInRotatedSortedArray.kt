package com.yueban.array

object SearchInRotatedSortedArray {
  fun searchInRotatedSortedArray1(nums: IntArray, target: Int): Int {
    for (i in 0 until nums.size) {
      if (nums[i] == target) {
        return i
      }
    }
    return -1
  }

  fun searchInRotatedSortedArray2(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
      val middle = (left + right) / 2
      if (nums[middle] == target) return middle
      if (nums[left] <= nums[middle]) {
        if (nums[left] <= target && target < nums[middle]) {
          right = middle - 1
        } else {
          left = middle + 1
        }
      } else {
        if (nums[middle] < target && target <= nums[right]) {
          left = middle + 1
        } else {
          right = middle - 1
        }
      }
    }

    return -1
  }
}
