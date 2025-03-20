package com.yueban.string

object ValidParentheses {
  fun validParentheses1(s: String): Boolean {
    fun Char.mark() = when (this) {
      '(' -> 1
      ')' -> -1
      '[' -> 2
      ']' -> -2
      '{' -> 3
      '}' -> -3
      else -> error("invalid char")
    }

    val charStack = ArrayDeque<Int>()

    s.forEach {
      val mark = it.mark()
      if (mark > 0) {
        charStack.addLast(mark)
      } else {
        val last = charStack.removeLastOrNull() ?: return false
        if (last + mark != 0) return false
      }
    }

    return charStack.size == 0
  }

  /**
   * basically same as [validParentheses1], but with a better performance (no need for the mark conversion).
   */
  fun validParentheses2(s: String): Boolean {
    val charStack = ArrayDeque<Char>()

    s.forEach {
      if (it == '(' || it == '[' || it == '{') {
        charStack.addLast(it)
      } else {
        val lastChar = charStack.removeLastOrNull() ?: return false
        if ((it == ')' && lastChar != '(') || (it == ']' && lastChar != '[') || (it == '}' && lastChar != '{')) {
          return false
        }
      }
    }

    return charStack.isEmpty()
  }

  /**
   * basically same as [validParentheses2] with optimization for parentheses pair checking.
   */
  fun validParentheses3(s: String): Boolean {
    val charStack = ArrayDeque<Char>()

    s.forEach {
      when (it) {
        '(', '[', '{' -> charStack.addLast(it)

        else -> {
          val lastChar = charStack.removeLastOrNull() ?: return false
          if ((it - lastChar) !in 1..2) return false
        }
      }
    }

    return charStack.isEmpty()
  }

  /**
   * preoccupy charArray space to reduce stack space expansion time. (use space exchange for time)
   */
  fun validParentheses4(s: String): Boolean {
    val charStack = CharArray(s.length)
    var index = 0

    s.forEach {
      when (it) {
        '(', '[', '{' -> charStack[index++] = it

        ')' -> if (index == 0 || charStack[--index] != '(') return false
        ']' -> if (index == 0 || charStack[--index] != '[') return false
        '}' -> if (index == 0 || charStack[--index] != '{') return false
        else -> error("invalid char: $it")
      }
    }

    return index == 0
  }
}
