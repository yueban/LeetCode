package com.yueban.linkedlist

import com.yueban.linkedlist.ReverseLinkedList.reverseLinkedList1
import com.yueban.linkedlist.ReverseLinkedList.reverseLinkedList2
import kotlin.test.Test
import kotlin.test.assertTrue

class ReverseLinkedListTest {
  private class TestCase(
    val head: ListNode?,
    val result: ListNode?,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 4, 5).toLinkedList(), intArrayOf(5, 4, 3, 2, 1).toLinkedList()),
    TestCase(intArrayOf(1, 2).toLinkedList(), intArrayOf(2, 1).toLinkedList()),
    TestCase(intArrayOf().toLinkedList(), intArrayOf().toLinkedList()),
  )

  @Test
  fun reverseLinkedList1Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, reverseLinkedList1(case.head)))
    }
  }

  @Test
  fun reverseLinkedList2Test() {
    testCases.forEach { case ->
      assertTrue(areLinkedListsEqual(case.result, reverseLinkedList2(case.head)))
    }
  }
}
