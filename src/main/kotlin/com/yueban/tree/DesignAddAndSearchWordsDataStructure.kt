package com.yueban.tree

interface DesignAddAndSearchWordsDataStructure {
  fun addWord(word: String)
  fun search(word: String): Boolean

  class DesignAddAndSearchWordsDataStructure1 : DesignAddAndSearchWordsDataStructure {
    private class TrieNode(val next: MutableMap<Char, TrieNode>, var isEnd: Boolean)

    private val root = TrieNode(mutableMapOf(), false)

    override fun addWord(word: String) {
      var node = root
      word.forEach { c ->
        node = node.next.getOrPut(c) { TrieNode(mutableMapOf(), false) }
      }
      node.isEnd = true
    }

    override fun search(word: String): Boolean {
      var nodeList = listOf(root)
      word.forEach { c ->
        if (nodeList.isEmpty()) return false
        nodeList = if (c == '.') {
          nodeList.flatMap { it.next.values }
        } else {
          nodeList.mapNotNull { it.next[c] }
        }
      }
      return nodeList.any { it.isEnd }
    }
  }

  class DesignAddAndSearchWordsDataStructure2 : DesignAddAndSearchWordsDataStructure {
    private class TrieNode(val next: MutableMap<Char, TrieNode>, var isEnd: Boolean)

    private val root = TrieNode(mutableMapOf(), false)

    override fun addWord(word: String) {
      var node = root
      word.forEach { c ->
        node = node.next.getOrPut(c) { TrieNode(mutableMapOf(), false) }
      }
      node.isEnd = true
    }

    override fun search(word: String): Boolean {
      fun dfs(index: Int, node: TrieNode): Boolean {
        if (index >= word.length) return node.isEnd
        val c = word[index]
        return if (c == '.') {
          node.next.values.any { dfs(index + 1, it) }
        } else {
          node.next[c]?.let { dfs(index + 1, it) } ?: false
        }
      }

      return dfs(0, root)
    }
  }
}
