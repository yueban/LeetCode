package com.yueban.binary

object NumberOf1Bits {
  fun numberOf1Bits1(n: Int): Int {
    var count = 0
    var temp = n
    while (temp != 0) {
      if (temp and 1 != 0) {
        count++
      }
      temp = temp shr 1
    }
    return count
  }
}
