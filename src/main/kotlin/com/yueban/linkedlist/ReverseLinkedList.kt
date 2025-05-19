package com.yueban.linkedlist

import com.yueban.linkedlist.ReverseLinkedList.reverseLinkedList1

object ReverseLinkedList {
  fun reverseLinkedList1(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var prev = head
    var result = ListNode(prev.`val`)

    while (prev?.next != null) {
      ListNode(prev.next!!.`val`).also {
        it.next = result
        result = it
      }

      prev = prev.next
    }

    return result
  }

  /**
   * basically same as [reverseLinkedList1] but in a more readable way
   */
  fun reverseLinkedList2(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    var next: ListNode?
    while (cur != null) {
      // cache next node
      next = cur.next
      // reverse node: change current node next to prev
      cur.next = prev
      // cache prev, cur
      prev = cur
      cur = next
    }
    return prev
  }
}
