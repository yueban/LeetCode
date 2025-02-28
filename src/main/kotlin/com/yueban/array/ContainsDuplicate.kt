package com.yueban.array

object ContainsDuplicate {
  fun containsDuplicate1(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    nums.forEach { num ->
      if (set.contains(num)) {
        return true
      } else {
        set.add(num)
      }
    }
    return false
  }
}
