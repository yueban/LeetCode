package com.yueban.array

import kotlin.math.max
import kotlin.math.min

object ContainerWithMostWater {
  fun containerWithMostWater1(height: IntArray): Int {
    var max = 0
    for (i in 0 until height.size) {
      for (j in i + 1 until height.size) {
        max = max(max, (j - i) * min(height[i], height[j]))
      }
    }
    return max
  }

  fun containerWithMostWater2(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var max = 0
    while (l < r) {
      if (height[l] <= height[r]) {
        max = max(max, (r - l) * height[l])
        l++
      } else {
        max = max(max, (r - l) * height[r])
        r--
      }
    }
    return max
  }

  fun containerWithMostWater3(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var max = r * min(height[l], height[r])
    while (l < r) {
      if (height[l] <= height[r]) {
        val previousL = height[l]
        while (height[l] <= previousL && l < r) {
          l++
        }
      } else {
        val previousR = height[r]
        while (height[r] <= previousR && l < r) {
          r--
        }
      }
      if (l < r) {
        max = max(max, (r - l) * min(height[l], height[r]))
      }
    }
    return max
  }
}
