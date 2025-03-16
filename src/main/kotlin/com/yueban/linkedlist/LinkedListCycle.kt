package com.yueban.linkedlist

object LinkedListCycle {
  fun linkedListCycle1(head: ListNode?): Boolean {
    if (head?.next == null) return false

    val set = mutableSetOf<ListNode>()
    var cur = head

    while (cur != null) {
      if (set.contains(cur)) {
        return true
      }
      set.add(cur)
      cur = cur.next
    }

    return false
  }

  fun linkedListCycle2(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next?.next

    while (slow != null && fast != null) {
      if (slow == fast) return true
      slow = slow.next
      fast = fast.next?.next
    }

    return false
  }
}
