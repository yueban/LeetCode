package com.yueban.linkedlist

import com.yueban.linkedlist.MergeTwoSortedLists.mergeTwoSortedLists1
import com.yueban.linkedlist.MergeTwoSortedLists.mergeTwoSortedLists2
import kotlin.test.Test
import kotlin.test.assertTrue

class MergeTwoSortedListsTest {
  class TestCase(
    val list1: ListNode?,
    val list2: ListNode?,
    val result: ListNode?,
  )

  private val testCases = listOf(
    TestCase(
      intArrayOf(1, 2, 4).toLinkedList(),
      intArrayOf(1, 3, 4).toLinkedList(),
      intArrayOf(1, 1, 2, 3, 4, 4).toLinkedList()
    ),
    TestCase(
      intArrayOf().toLinkedList(),
      intArrayOf().toLinkedList(),
      intArrayOf().toLinkedList()
    ),
    TestCase(
      intArrayOf().toLinkedList(),
      intArrayOf(0).toLinkedList(),
      intArrayOf(0).toLinkedList()
    ),
  )

  @Test
  fun mergeTwoSortedLists1Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, mergeTwoSortedLists1(case.list1, case.list2)))
    }
  }

  @Test
  fun mergeTwoSortedLists2Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, mergeTwoSortedLists2(case.list1, case.list2)))
    }
  }
}
