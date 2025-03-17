package com.yueban.linkedlist

import com.yueban.linkedlist.MergeKSortedLists.mergeKSortedLists1
import com.yueban.linkedlist.MergeKSortedLists.mergeKSortedLists2
import kotlin.test.Test
import kotlin.test.assertTrue

class MergeKSortedListsTest {
  private class TestCase(
    val lists: Array<ListNode?>,
    val result: ListNode?,
  )

  private val testCases = listOf(
    TestCase(
      arrayOf(
        intArrayOf(1, 4, 5).toLinkedList(),
        intArrayOf(1, 3, 4).toLinkedList(),
        intArrayOf(2, 6).toLinkedList()
      ),
      intArrayOf(1, 1, 2, 3, 4, 4, 5, 6).toLinkedList()
    ),
    TestCase(
      arrayOf(),
      null
    ),
    TestCase(
      arrayOf(null),
      null,
    ),
  )

  @Test
  fun mergeKSortedLists1Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, mergeKSortedLists1(case.lists)))
    }
  }

  @Test
  fun mergeKSortedLists2Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, mergeKSortedLists2(case.lists)))
    }
  }
}
