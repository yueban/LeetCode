package com.yueban.array

object TwoSum {
  /**
   * Brute Force
   */
  fun twoSum1(nums: IntArray, target: Int): Set<Int> {
    nums.forEachIndexed { i, n ->
      for (j in 1 until nums.size) {
        if (n + nums[j] == target) {
          return setOf(i, j)
        }
      }
    }
    return setOf()
  }

  /**
   * Two-pass Hash Table
   */
  fun twoSum2(nums: IntArray, target: Int): Set<Int> {
    val map = HashMap<Int, Int>(nums.size)
    nums.forEachIndexed { index, i -> map[i] = index }
    nums.forEachIndexed { index, i ->
      val complement = target - i
      if (map.containsKey(complement) && (map[complement]) != index) {
        return setOf(index, map[complement]!!)
      }
    }
    return setOf()
  }

  /**
   * One-pass Hash Table
   */
  fun twoSum3(nums: IntArray, target: Int): Set<Int> {
    val map = HashMap<Int, Int>(nums.size)
    nums.forEachIndexed { index, i ->
      val complement = target - i
      if (map.containsKey(complement)) {
        return setOf(index, map[complement]!!)
      }
      map[i] = index
    }
    return setOf()
  }
}
