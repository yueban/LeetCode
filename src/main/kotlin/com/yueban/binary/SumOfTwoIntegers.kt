package com.yueban.binary

object SumOfTwoIntegers {
  fun sumOfTwoIntegers1(a: Int, b: Int): Int {
    var xor = a
    var carry = b
    while (carry != 0) {
      val temp = xor xor carry
      carry = (xor and carry) shl 1
      xor = temp
    }
    return xor
  }
}
