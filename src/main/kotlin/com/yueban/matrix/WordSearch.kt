package com.yueban.matrix

object WordSearch {
  /**
   * brutal way to solve the problem, time complexity is O(m * n * 4^k)
   */
  fun wordSearch1(board: Array<CharArray>, word: String): Boolean {
    val m = board.size
    val n = board[0].size

    fun wordSearch(x: Int, y: Int, wordCharIndex: Int, visited: MutableSet<Pair<Int, Int>>): Boolean {
      if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x to y)) return false

      val wordChar = word[wordCharIndex]
      if (board[x][y] == wordChar) {
        visited.add(x to y)
        if (wordCharIndex == word.length - 1) {
          return true
        } else {
          val nextCharIndex = wordCharIndex + 1
          if (wordSearch(x + 1, y, nextCharIndex, visited) ||
            wordSearch(x - 1, y, nextCharIndex, visited) ||
            wordSearch(x, y + 1, nextCharIndex, visited) ||
            wordSearch(x, y - 1, nextCharIndex, visited)
          ) {
            return true
          }
        }
        visited.remove(x to y)
      }
      return false
    }

    val visited = mutableSetOf<Pair<Int, Int>>()
    for (i in 0 until m) {
      for (j in 0 until n) {
        visited.clear()
        if (wordSearch(i, j, 0, visited)) {
          return true
        }
      }
    }
    return false
  }

  fun wordSearch2(board: Array<CharArray>, word: String): Boolean {
    val m = board.size
    val n = board[0].size

    fun wordSearch(x: Int, y: Int, index: Int): Boolean {
      if (index == word.length) return true
      if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != word[index]) return false

      val temp = board[x][y]
      // mark as visited
      board[x][y] = '0'

      val result = wordSearch(x + 1, y, index + 1) ||
        wordSearch(x - 1, y, index + 1) ||
        wordSearch(x, y + 1, index + 1) ||
        wordSearch(x, y - 1, index + 1)

      board[x][y] = temp
      return result
    }

    for (i in 0 until m) {
      for (j in 0 until n) {
        if (board[i][j] == word[0] && wordSearch(i, j, 0)) {
          return true
        }
      }
    }
    return false
  }
}
