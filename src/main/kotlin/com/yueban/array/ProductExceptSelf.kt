package com.yueban.array

object ProductExceptSelf {
  fun productExceptSelf1(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 1 }
    nums.forEachIndexed { index, num ->
      for (resultIndex in result.indices) {
        if (resultIndex != index) {
          result[resultIndex] = result[resultIndex] * num
        }
      }
    }
    return result
  }

  fun productExceptSelf2(nums: IntArray): IntArray {
    val forthProducts = IntArray(nums.size)
    nums.forEachIndexed { index, num ->
      if (index == 0) {
        forthProducts[index] = 1 * num
      } else {
        forthProducts[index] = forthProducts[index - 1] * num
      }
    }

    val backProducts = IntArray(nums.size)
    for (index in nums.size - 1 downTo 0) {
      if (index == nums.size - 1) {
        backProducts[index] = 1 * nums[index]
      } else {
        backProducts[index] = backProducts[index + 1] * nums[index]
      }
    }

    val result = IntArray(nums.size)
    result.indices.forEach { index ->
      result[index] = when (index) {
        0 -> backProducts[1]
        nums.size - 1 -> forthProducts[nums.size - 2]
        else -> forthProducts[index - 1] * backProducts[index + 1]
      }
    }
    return result
  }

  fun productExceptSelf3(nums: IntArray): IntArray {
    var pre = 1
    var post = 1

    val result = IntArray(nums.size) { 1 }
    for (i in 0 until nums.size) {
      result[i] = pre
      pre *= nums[i]
    }

    for (i in nums.size - 1 downTo 0) {
      result[i] *= post
      post *= nums[i]
    }
    return result
  }
}
