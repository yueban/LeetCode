package com.yueban.linkedlist

object MergeTwoSortedLists {
  fun mergeTwoSortedLists1(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    var result: ListNode? = null
    var cur: ListNode? = null
    var cur1 = list1
    var cur2 = list2

    while (cur1 != null || cur2 != null) {
      when {
        cur1 == null -> {
          cur?.next = cur2
          cur2 = null
        }
        cur2 == null -> {
          cur?.next = cur1
          cur1 = null
        }
        cur1.`val` < cur2.`val` -> {
          if (cur == null) {
            ListNode(cur1.`val`).also {
              cur = it
              result = it
            }
          } else {
            cur?.next = ListNode(cur1.`val`)
            cur = cur?.next
          }
          cur1 = cur1.next
        }
        else -> {
          if (cur == null) {
            ListNode(cur2.`val`).also {
              cur = it
              result = it
            }
          } else {
            cur?.next = ListNode(cur2.`val`)
            cur = cur?.next
          }
          cur2 = cur2.next
        }
      }
    }

    return result
  }

  fun mergeTwoSortedLists2(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var cur = dummy
    var cur1 = list1
    var cur2 = list2

    while (cur1 != null && cur2 != null) {
      if (cur1.`val` < cur2.`val`) {
        cur.next = cur1
        cur1 = cur1.next
      } else {
        cur.next = cur2
        cur2 = cur2.next
      }
      cur = cur.next!!
    }

    if (cur1 == null) {
      cur.next = cur2
    } else {
      cur.next = cur1
    }

    return dummy.next
  }
}
