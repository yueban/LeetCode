package com.yueban.linkedlist

import java.util.*

object MergeKSortedLists {
  fun mergeKSortedLists1(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty() || lists.all { it == null }) return null

    val map = lists.withIndex().associate { it.index to it.value }.toMutableMap()
    val dummy = ListNode(0)
    var cur = dummy

    while (map.any { it.value != null }) {
      val min = map.minBy { it.value?.`val` ?: Int.MAX_VALUE }
      cur.next = min.value
      cur = cur.next!!
      if (min.value?.next == null) {
        map.remove(min.key)
      } else {
        map[min.key] = min.value?.next
      }
    }

    return dummy.next
  }

  fun mergeKSortedLists2(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty() || lists.all { it == null }) return null

    val minHeap = PriorityQueue<ListNode>(compareBy { it.`val` })
    lists.forEach {
      if (it != null) minHeap.add(it)
    }

    val dummy = ListNode(0)
    var cur = dummy

    while (minHeap.isNotEmpty()) {
      val minNode = minHeap.poll()

      cur.next = minNode
      cur = cur.next!!

      if (minNode.next != null) {
        minHeap.add(minNode.next)
      }
    }

    return dummy.next
  }
}
