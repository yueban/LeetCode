package com.yueban.linkedlist

object RemoveNthNodeFromEndOfList {
  fun removeNthNodeFromEndOfList1(head: ListNode?, n: Int): ListNode? {
    val map = mutableMapOf<Int, ListNode>()

    var i = 0
    var cur = head
    while (cur != null) {
      map[i] = cur
      cur = cur.next
      i++
    }

    val indexToRemove = i - n
    if (indexToRemove == 0) {
      return head?.next
    } else {
      val node = map[indexToRemove - 1]
      node!!.next = node.next?.next
      return head
    }
  }

  fun removeNthNodeFromEndOfList2(head: ListNode?, n: Int): ListNode? {
    val start = ListNode(0)
    start.next = head

    var h = head
    var t = start
    // we assume the size of ListNodes is sz
    // the h pointer is advanced n nodes into the list
    for (i in 0..<n) {
      h = h!!.next
    }

    // now h pointer has n nodes, t pointer has 0 node, so we advance h pointer until the end
    // in the while loop, there will be (sz - n) nodes advanced into h pointer, as well as t pointer will be advanced (sz - n) nodes
    // which means t pointer doesn't have exactly the last n nodes
    while (h != null) {
      h = h.next
      t = t.next!!
    }

    val z = t.next ?: return null
    t.next = z.next
    return start.next
  }
}
