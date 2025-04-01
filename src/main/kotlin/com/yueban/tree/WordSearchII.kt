package com.yueban.tree

object WordSearchII {
  private class TrieNode(val next: MutableMap<Char, TrieNode>, var isEnd: Boolean)

  private class Trie {
    val root = TrieNode(mutableMapOf(), false)

    fun insert(word: String) {
      var node = root
      word.forEach { c ->
        node = node.next.getOrPut(c) { TrieNode(mutableMapOf(), false) }
      }
      node.isEnd = true
    }

    fun search(word: String): Boolean {
      var node = root
      word.forEach { c ->
        node = node.next[c] ?: return false
      }
      return node.isEnd
    }
  }

  /**
   * dfs all possible words and insert them all into a trie. search the built trie for [words].
   * dfs may cost a huge time when board is large.
   */
  fun wordSearchII1(board: Array<CharArray>, words: Array<String>): List<String> {
    val trie = Trie()

    // insert all words from board
    val m = board.size
    val n = board[0].size

    fun dfs(x: Int, y: Int, currentWord: StringBuilder) {
      if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '#') return

      val c = board[x][y]
      currentWord.append(c)
      trie.insert(currentWord.toString())
      board[x][y] = '#'

      dfs(x + 1, y, currentWord)
      dfs(x - 1, y, currentWord)
      dfs(x, y + 1, currentWord)
      dfs(x, y - 1, currentWord)

      board[x][y] = c
      currentWord.setLength(currentWord.length - 1)
    }

    for (i in 0 until m) {
      for (j in 0 until n) {
        dfs(i, j, StringBuilder())
      }
    }

    return words.filter { trie.search(it) }
  }

  /**
   * insert all words into a trie. dfs the board to find all words that can be found in trie.
   */
  fun wordSearchII2(board: Array<CharArray>, words: Array<String>): List<String> {
    val trie = Trie()
    words.forEach { trie.insert(it) }
    val foundWords = mutableSetOf<String>()

    val m = board.size
    val n = board[0].size
    fun dfs(x: Int, y: Int, currentWord: StringBuilder, node: TrieNode) {
      if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '#') return

      val c = board[x][y]
      val nextNode = node.next[c] ?: return
      currentWord.append(c)
      board[x][y] = '#'

      if (nextNode.isEnd) {
        foundWords.add(currentWord.toString())
      }

      dfs(x + 1, y, currentWord, nextNode)
      dfs(x - 1, y, currentWord, nextNode)
      dfs(x, y + 1, currentWord, nextNode)
      dfs(x, y - 1, currentWord, nextNode)

      board[x][y] = c
      currentWord.setLength(currentWord.length - 1)
    }


    for (i in 0 until m) {
      for (j in 0 until n) {
        dfs(i, j, StringBuilder(), trie.root)
      }
    }

    return foundWords.toList()
  }
}
