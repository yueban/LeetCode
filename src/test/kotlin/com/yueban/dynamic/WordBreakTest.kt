package com.yueban.dynamic

import com.yueban.dynamic.WordBreak.wordBreak1
import com.yueban.dynamic.WordBreak.wordBreak2
import kotlin.test.Test
import kotlin.test.assertEquals

class WordBreakTest {
  private class TestCase(
    val s: String,
    val wordDict: List<String>,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase("leetcode", listOf("leet", "code"), true),
    TestCase("applepenapple", listOf("apple", "pen"), true),
    TestCase("catsandog", listOf("cats", "dog", "sand", "and", "cat"), false),
    TestCase("abcd", listOf("a", "abc", "b", "cd"), true),
    TestCase("dogs", listOf("dog", "s", "gs"), true),
    TestCase(
      "bccdbacdbdacddabbaaaadababadad",
      listOf(
        "cbc",
        "bcda",
        "adb",
        "ddca",
        "bad",
        "bbb",
        "dad",
        "dac",
        "ba",
        "aa",
        "bd",
        "abab",
        "bb",
        "dbda",
        "cb",
        "caccc",
        "d",
        "dd",
        "aadb",
        "cc",
        "b",
        "bcc",
        "bcd",
        "cd",
        "cbca",
        "bbd",
        "ddd",
        "dabb",
        "ab",
        "acd",
        "a",
        "bbcc",
        "cdcbd",
        "cada",
        "dbca",
        "ac",
        "abacd",
        "cba",
        "cdb",
        "dbac",
        "aada",
        "cdcda",
        "cdc",
        "dbc",
        "dbcb",
        "bdb",
        "ddbdd",
        "cadaa",
        "ddbc",
        "babb"
      ),
      true
    ),
  )

  @Test
  fun wordBreak1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, wordBreak1(case.s, case.wordDict))
    }
  }

  @Test
  fun wordBreak2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, wordBreak2(case.s, case.wordDict))
    }
  }
}
