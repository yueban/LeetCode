package com.yueban.binary

object MissingNumber {
  fun missingNumber1(nums: IntArray): Int {
    val temp = BooleanArray(nums.size + 1)
    nums.forEach { num ->
      temp[num] = true
    }
    for (i in 0 until temp.size) {
      if (!temp[i]) {
        return i
      }
    }
    return -1
  }

  fun missingNumber2(nums: IntArray): Int {
    var sum = 0
    var expectedSum = 0
    for (i in 0 until nums.size) {
      expectedSum += i
      sum += nums[i]
    }
    expectedSum += nums.size
    return expectedSum - sum
  }
}
