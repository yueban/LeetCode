package com.yueban.array

import java.util.*

object ThreeSum {
  fun threeSum1(nums: IntArray): List<List<Int>> {
    val map = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
      map[nums[i]] = i
    }

    fun twoSum(nums: IntArray, start: Int): Set<List<Int>> {
      val target = 0 - nums[start]
      val result = mutableSetOf<List<Int>>()
      for (i in start + 1 until nums.size) {
        val complement = target - nums[i]
        if (map.containsKey(complement) && map[complement]!! > i) {
          result.add(listOf(nums[start], nums[i], complement).sorted())
        }
      }
      return result
    }

    val result = mutableSetOf<List<Int>>()
    for (i in 0 until nums.size - 2) {
      result.addAll(twoSum(nums, i))
    }
    return result.toList().sortedWith { list0, list1 ->
      for (i in list0.indices) {
        if (list0[i] != list1[i]) {
          return@sortedWith list0[i] - list1[i]
        }
      }
      return@sortedWith 0
    }
  }

  fun threeSum2(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)

    val map = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
      map[nums[i]] = i
    }

    fun twoSum(nums: IntArray, start: Int): Set<List<Int>> {
      val target = 0 - nums[start]
      val result = linkedSetOf<List<Int>>()
      for (i in start + 1 until nums.size) {
        val complement = target - nums[i]
        if (map.containsKey(complement) && map[complement]!! > i) {
          result.add(listOf(nums[start], nums[i], complement))
        }
      }
      return result
    }

    val result = linkedSetOf<List<Int>>()
    for (i in 0 until nums.size - 2) {
      result.addAll(twoSum(nums, i))
    }
    return result.toList()
  }

  fun threeSum3(nums: IntArray): List<List<Int>> {
    // sorted array for later comparison and match the expected sorted output
    nums.sort()

    val result = ArrayList<List<Int>>()

    val max = nums[nums.size - 2] + nums[nums.size - 1]

    for (i in 0..nums.size - 3) {
      val curr = nums[i]
      // skip same num
      if (i > 0 && curr == nums[i - 1]) continue
      // skip too small num
      if (curr + max < 0) continue
      // skip too large num
      if (curr + nums[i + 1] + nums[i + 2] > 0) break

      // two sum question
      val need = -curr

      var l = i + 1
      var r = nums.size - 1

      while (l < r) {
        val sum = nums[l] + nums[r]
        when {
          sum < need -> l++
          sum > need -> r--
          else -> {
            result += listOf(nums[i], nums[l++], nums[r--])
            // skip same left num
            while (l < r && nums[l] == nums[l - 1]) l++
            // skip same right num
            while (l < r && nums[r] == nums[r + 1]) r--
          }
        }
      }
    }

    return result
  }

  /**
   * worse than [threeSum3] on big data
   */
  fun threeSum4(nums: IntArray): List<List<Int>> {
    // sorted array for later comparison and match the expected sorted output
    nums.sort()
    val map = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
      map[nums[i]] = i
    }

    val result = ArrayList<List<Int>>()

    val max = nums[nums.size - 2] + nums[nums.size - 1]

    for (i in 0..nums.size - 3) {
      val curr = nums[i]
      // skip same num
      if (i > 0 && curr == nums[i - 1]) continue
      // skip too small num
      if (curr + max < 0) continue
      // skip too large num
      if (curr + nums[i + 1] + nums[i + 2] > 0) break

      // two sum question
      val need = -curr

      for (j in i + 1 until nums.size) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue
        val complement = need - nums[j]
        if (map.containsKey(complement) && map[complement]!! > j) {
          result.add(listOf(nums[i], nums[j], complement))
        }
      }
    }

    return result
  }
}
