package com.yueban.linkedlist

import com.yueban.linkedlist.RemoveNthNodeFromEndOfList.removeNthNodeFromEndOfList1
import com.yueban.linkedlist.RemoveNthNodeFromEndOfList.removeNthNodeFromEndOfList2
import kotlin.test.Test
import kotlin.test.assertTrue

class RemoveNthNodeFromEndOfListTest {
  class TestCase(
    val head: ListNode?,
    val n: Int,
    val result: ListNode?,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 4, 5).toLinkedList(), 2, intArrayOf(1, 2, 3, 5).toLinkedList()),
    TestCase(intArrayOf(1).toLinkedList(), 1, null),
    TestCase(intArrayOf(1, 2).toLinkedList(), 1, intArrayOf(1).toLinkedList()),
  )

  @Test
  fun removeNthNodeFromEndOfList1Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, removeNthNodeFromEndOfList1(case.head, case.n)))
    }
  }

  @Test
  fun removeNthNodeFromEndOfList2Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, removeNthNodeFromEndOfList2(case.head, case.n)))
    }
  }
}
