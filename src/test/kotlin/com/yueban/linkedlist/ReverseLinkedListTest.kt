package com.yueban.linkedlist

import com.yueban.linkedlist.ReverseLinkedList.reverseLinkedList1
import com.yueban.linkedlist.ReverseLinkedList.reverseLinkedList2
import kotlin.test.Test
import kotlin.test.assertTrue

class ReverseLinkedListTest {
  class TestCase(
    val head: ListNode?,
    val result: ListNode?,
  )

  private val testCases = listOf(
    TestCase(intArrayOf(1, 2, 3, 4, 5).toLinkedList(), intArrayOf(5, 4, 3, 2, 1).toLinkedList()),
    TestCase(intArrayOf(1, 2).toLinkedList(), intArrayOf(2, 1).toLinkedList()),
    TestCase(intArrayOf().toLinkedList(), intArrayOf().toLinkedList()),
  )

  private fun IntArray.toLinkedList(): ListNode? {
    if (isEmpty()) return null

    val list = map { ListNode(it) }
    for (i in 0 until list.size - 1) {
      list[i].next = list[i + 1]
    }

    return list[0]
  }

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

  private fun areLinkedListsEqual(expected: ListNode?, actual: ListNode?): Boolean {
    var current1 = expected
    var current2 = actual

    while (current1 != null && current2 != null) {
      if (current1.`val` != current2.`val`) {
        return false // Values are different
      }
      current1 = current1.next
      current2 = current2.next
    }

    // Check if both are null (end of lists)
    return current1 == null && current2 == null
  }
}
