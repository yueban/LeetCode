package com.yueban.linkedlist

object ReorderList {
  fun reorderList1(head: ListNode?) {
    if (head?.next == null) return

    // find middle of the list which is slow and slow.next
    var slow: ListNode? = head
    var fast: ListNode? = head
    while (fast?.next != null && fast.next?.next != null) {
      slow = slow?.next
      fast = fast.next?.next
    }

    // reverse the last half list as second (starts by slow.next)
    // second is the reversed last half list
    var second = reverseLinkedList(slow?.next)
    // cut the first half list as first (ends by slow)
    slow?.next = null
    // first is the first half list
    var first = head

    // merge two lists
    while (second != null) {
      val temp1 = first?.next
      val temp2 = second.next

      first?.next = second
      second.next = temp1

      first = temp1
      second = temp2
    }
  }

  private fun reverseLinkedList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    var next: ListNode?
    while (cur != null) {
      next = cur.next
      cur.next = prev
      prev = cur
      cur = next
    }
    return prev
  }
}
