package com.yueban.string

object ValidPalindrome {
  /**
   * filter non-alphanumeric characters, convert uppercase characters to lowercase. and then check if the converted string is palindrome.
   */
  fun validPalindrome1(s: String): Boolean {
    val converted = buildString {
      s.forEach {
        when (it) {
          in 'A'..'Z' -> append(it + 32)

          in 'a'..'z',
          in '0'..'9',
          -> append(it)

          else -> {}
        }
      }
    }

    for (i in 0 until converted.length / 2) {
      if (converted[i] != converted[converted.length - 1 - i]) {
        return false
      }
    }

    return true
  }

  /**
   * use two pointers, every time in the loop, try to get a valid left char and a valid right char, check if they are same.
   */
  fun validPalindrome2(s: String): Boolean {
    var l = 0
    var r = s.length - 1

    while (l < r) {
      val leftChar = when (s[l]) {
        in 'a'..'z',
        in '0'..'9',
        -> s[l]

        in 'A'..'Z' -> s[l] + 32

        else -> {
          l++
          continue
        }
      }

      val rightChar = when (s[r]) {
        in 'a'..'z',
        in '0'..'9',
        -> s[r]

        in 'A'..'Z' -> s[r] + 32

        else -> {
          r--
          continue
        }
      }

      if (leftChar != rightChar) return false

      l++
      r--
    }

    return true
  }
}
