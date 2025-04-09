package com.yueban.binary

object ReverseBits {
  fun reverseBits1(n: Int): Int {
    return n.toUInt().toString(2).reversed().padEnd(32, '0').toUInt(2).toInt()
  }

  fun reverseBits2(n: Int): Int {
    tailrec fun reverseBitsTail(n: Int, bitsLength: Int, counter: Int, result: Int): Int = when (counter) {
      bitsLength -> result
      else -> reverseBitsTail(n ushr 1, bitsLength, counter + 1, (result shl 1) or (n and 1))
    }

    return reverseBitsTail(n, 32, 0, 0)
  }
}
