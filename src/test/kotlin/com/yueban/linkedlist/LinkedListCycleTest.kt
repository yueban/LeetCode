package com.yueban.linkedlist

import com.yueban.linkedlist.LinkedListCycle.linkedListCycle1
import com.yueban.linkedlist.LinkedListCycle.linkedListCycle2
import kotlin.test.Test
import kotlin.test.assertEquals

class LinkedListCycleTest {
  class TestCase(
    val head: ListNode?,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(toLinkedList(intArrayOf(3, 2, 0, -4), 1), true),
    TestCase(toLinkedList(intArrayOf(1, 2), 0), true),
    TestCase(toLinkedList(intArrayOf(1), -1), false),
  )

  private fun toLinkedList(head: IntArray, pos: Int): ListNode? {
    if (head.isEmpty()) return null

    val list = head.map { ListNode(it) }
    for (i in 0 until list.size - 1) {
      list[i].next = list[i + 1]
    }
    if (pos >= 0) {
      list[head.size - 1].next = list[pos]
    }

    return list[0]
  }

  @Test
  fun linkedListCycle1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, linkedListCycle1(case.head))
    }
  }

  @Test
  fun linkedListCycle2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, linkedListCycle2(case.head))
    }
  }
}
