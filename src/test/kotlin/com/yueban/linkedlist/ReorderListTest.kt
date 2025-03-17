package com.yueban.linkedlist

import com.yueban.linkedlist.ReorderList.reorderList1
import kotlin.test.Test
import kotlin.test.assertTrue

class ReorderListTest {
  class TestCase(
    val head: ListNode?,
    val result: ListNode?,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 4).toLinkedList(), intArrayOf(1, 4, 2, 3).toLinkedList()),
    TestCase(intArrayOf(1, 2, 3, 4, 5).toLinkedList(), intArrayOf(1, 5, 2, 4, 3).toLinkedList())
  )

  @Test
  fun reorderList1Test() {
    testCases.forEach { case ->
      reorderList1(case.head)
      assertTrue(areLinkedListsEqual(case.result, case.head))
    }
  }
}
