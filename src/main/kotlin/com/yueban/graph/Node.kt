package com.yueban.graph

class Node(var `val`: Int) {
  var neighbors: ArrayList<Node?> = ArrayList()

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Node

    if (`val` != other.`val`) return false
    if (neighbors.map { it!!.`val` } != other.neighbors.map { it!!.`val` }) return false

    return true
  }

  override fun hashCode(): Int {
    var result = `val`
    result = 31 * result + neighbors.map { it!!.`val` }.hashCode()
    return result
  }
}
