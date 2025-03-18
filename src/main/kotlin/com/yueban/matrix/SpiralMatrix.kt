package com.yueban.matrix

object SpiralMatrix {
  /**
   * brutal way to simulate pointer moving
   */
  fun spiralMatrix1(matrix: Array<IntArray>): List<Int> {
    var left = -1
    var right = matrix[0].size
    var top = -1
    var bottom = matrix.size

    var curX = 0
    var curY = 0
    // 0:right 1:bottom 2:left 3:top
    var direction = 0
    var repeat = false

    val result = mutableListOf<Int>()
    result.add(matrix[curX][curY])

    while (left < right - 1 && top < bottom - 1) {
      if (repeat) {
        when (direction) {
          0 -> { // 0:right
            left++
            curY++
          }
          1 -> { // 1:bottom
            top++
            curX++
          }
          2 -> { // 2:left
            right--
            curY--
          }
          3 -> { // 3:top
            bottom--
            curX--
          }
        }
      } else {
        when (direction) {
          0 -> { // 0:right
            if (curY == right - 1) {
              top++
              direction++
              repeat = right - left == 2
              continue
            } else {
              curY++
            }
          }
          1 -> { // 1:bottom
            if (curX == bottom - 1) {
              right--
              direction++
              repeat = bottom - top == 2
              continue
            } else {
              curX++
            }
          }
          2 -> { // 2:left
            if (curY == left + 1) {
              bottom--
              direction++
              repeat = right - left == 2
              continue
            } else {
              curY--
            }
          }
          3 -> { // 3:top
            if (curX == top + 1) {
              left++
              direction = 0
              repeat = bottom - top == 2
              continue
            } else {
              curX--
            }
          }
        }
      }

      result.add(matrix[curX][curY])
    }

    return result
  }

  /**
   * basically same as [spiralMatrix1] but a bit more readable
   */
  fun spiralMatrix2(matrix: Array<IntArray>): List<Int> {
    val verticalSize = matrix.size
    val horizontalSize = matrix[0].size
    val size = verticalSize * horizontalSize

    var x = 0
    var y = 0

    // 0:ltr 1:ttb 2:rtl 3:btt
    val linesCount = IntArray(4)

    // 0:ltr 1:ttb 2:rtl 3:btt
    var currentOrder = 0
    val result = mutableListOf<Int>()
    result.add(matrix[x][y])

    while (result.size < size) {
      when (currentOrder) {
        0 -> {
          // last point of this horizontal line
          val newY = horizontalSize - 1 - linesCount[1]
          for (col in y + 1..newY) {
            result.add(matrix[x][col])
          }
          y = newY
          currentOrder = 1
          linesCount[0]++
        }

        1 -> {
          // last point of this vertical line
          val newX = verticalSize - 1 - linesCount[2]
          for (row in x + 1..newX) {
            result.add(matrix[row][y])
          }
          x = newX
          currentOrder = 2
          linesCount[1]++
        }

        2 -> {
          // first point of this horizontal line
          val newY = linesCount[3]
          for (col in y - 1 downTo newY) {
            result.add(matrix[x][col])
          }
          y = newY
          currentOrder = 3
          linesCount[2]++
        }

        else -> {
          // first point of this vertical line
          val newX = linesCount[0]
          for (row in x - 1 downTo newX) {
            result.add(matrix[row][y])
          }
          x = newX
          currentOrder = 0
          linesCount[3]++
        }
      }
    }
    return result
  }
}
