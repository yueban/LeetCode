package com.yueban.linkedlist

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun IntArray.toLinkedList(): ListNode? {
  if (isEmpty()) return null

  val list = map { ListNode(it) }
  for (i in 0 until list.size - 1) {
    list[i].next = list[i + 1]
  }

  return list[0]
}

fun areLinkedListsEqual(expected: ListNode?, actual: ListNode?): Boolean {
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
