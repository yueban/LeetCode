package com.yueban.tree

interface ImplementTrie {
  fun insert(word: String)
  fun search(word: String): Boolean
  fun startsWith(prefix: String): Boolean

  class ImplementTrie1 : ImplementTrie {
    private class TrieNode(val next: MutableMap<Char, TrieNode>, var isEnd: Boolean)

    private val root = TrieNode(mutableMapOf(), false)

    override fun insert(word: String) {
      var node = root
      word.forEach { c ->
        node = node.next.getOrPut(c) { TrieNode(mutableMapOf(), false) }
      }
      node.isEnd = true
    }

    override fun search(word: String): Boolean {
      var node = root
      word.forEach { c ->
        node = node.next[c] ?: return false
      }
      return node.isEnd
    }

    override fun startsWith(prefix: String): Boolean {
      var node = root
      prefix.forEach { c ->
        node = node.next[c] ?: return false
      }
      return true
    }
  }
}
