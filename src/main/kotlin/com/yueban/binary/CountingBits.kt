package com.yueban.binary

import com.yueban.binary.NumberOf1Bits.numberOf1Bits1

object CountingBits {
  fun countingBits1(n: Int): IntArray {
    val result = IntArray(n + 1)
    for (i in 0 until result.size) {
      result[i] = numberOf1Bits1(i)
    }
    return result
  }

  fun countingBits2(n: Int): IntArray {
    val result = IntArray(n + 1)
    for (i in 0 until result.size) {
      result[i] = result[i / 2] + (i and 1)
    }
    return result
  }
}
