package com.yueban.matrix

import com.yueban.matrix.WordSearch.wordSearch1

object WordSearch {
  /**
   * brutal way to solve the problem, time complexity is O(m * n * 4^k)
   */
  fun wordSearch1(board: Array<CharArray>, word: String): Boolean {
    val m = board.size
    val n = board[0].size

    fun wordSearch(x: Int, y: Int, index: Int, visited: MutableSet<Pair<Int, Int>>): Boolean {
      if (index == word.length) return true
      if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x to y) || board[x][y] != word[index]) return false

      visited.add(x to y)

      val result = wordSearch(x + 1, y, index + 1, visited) ||
        wordSearch(x - 1, y, index + 1, visited) ||
        wordSearch(x, y + 1, index + 1, visited) ||
        wordSearch(x, y - 1, index + 1, visited)

      visited.remove(x to y)
      return result
    }

    val visited = mutableSetOf<Pair<Int, Int>>()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (wordSearch(i, j, 0, visited)) {
          return true
        }
      }
    }
    return false
  }

  /**
   * basically same as [wordSearch1], but marking the visited grid by `board[x][y] = '0'`
   */
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
