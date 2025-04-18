package com.yueban.matrix

import com.yueban.matrix.SpiralMatrix.Direction.*
import com.yueban.matrix.SpiralMatrix.spiralMatrix1

object SpiralMatrix {
  enum class Direction {
    LEFT_TO_RIGHT,
    TOP_TO_BOTTOM,
    RIGHT_TO_LEFT,
    BOTTOM_TO_TOP,
  }

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

    var direction: Direction = LEFT_TO_RIGHT
    var repeat = false

    val result = mutableListOf<Int>()
    result.add(matrix[curX][curY])

    while (left < right - 1 && top < bottom - 1) {
      if (repeat) {
        when (direction) {
          LEFT_TO_RIGHT -> {
            left++
            curY++
          }
          TOP_TO_BOTTOM -> {
            top++
            curX++
          }
          RIGHT_TO_LEFT -> {
            right--
            curY--
          }
          BOTTOM_TO_TOP -> {
            bottom--
            curX--
          }
        }
      } else {
        when (direction) {
          LEFT_TO_RIGHT -> {
            if (curY == right - 1) {
              top++
              direction = TOP_TO_BOTTOM
              repeat = right - left == 2
              continue
            } else {
              curY++
            }
          }
          TOP_TO_BOTTOM -> {
            if (curX == bottom - 1) {
              right--
              direction = RIGHT_TO_LEFT
              repeat = bottom - top == 2
              continue
            } else {
              curX++
            }
          }
          RIGHT_TO_LEFT -> {
            if (curY == left + 1) {
              bottom--
              direction = BOTTOM_TO_TOP
              repeat = right - left == 2
              continue
            } else {
              curY--
            }
          }
          BOTTOM_TO_TOP -> {
            if (curX == top + 1) {
              left++
              direction = LEFT_TO_RIGHT
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
    val m = matrix.size
    val n = matrix[0].size
    val size = m * n

    var x = 0
    var y = 0

    // cache lines count consumed (iterated) on all directions
    val linesCount = mutableMapOf(
      LEFT_TO_RIGHT to 0,
      TOP_TO_BOTTOM to 0,
      RIGHT_TO_LEFT to 0,
      BOTTOM_TO_TOP to 0,
    )

    var direction = LEFT_TO_RIGHT
    val result = mutableListOf<Int>()
    result.add(matrix[x][y])

    while (result.size < size) {
      when (direction) {
        LEFT_TO_RIGHT -> {
          // last point of this horizontal line
          val newY = n - 1 - linesCount[TOP_TO_BOTTOM]!!
          for (col in y + 1..newY) {
            result.add(matrix[x][col])
          }
          y = newY
          direction = TOP_TO_BOTTOM
          linesCount[LEFT_TO_RIGHT] = linesCount[LEFT_TO_RIGHT]!! + 1
        }

        TOP_TO_BOTTOM -> {
          // last point of this vertical line
          val newX = m - 1 - linesCount[RIGHT_TO_LEFT]!!
          for (row in x + 1..newX) {
            result.add(matrix[row][y])
          }
          x = newX
          direction = RIGHT_TO_LEFT
          linesCount[TOP_TO_BOTTOM] = linesCount[TOP_TO_BOTTOM]!! + 1
        }

        RIGHT_TO_LEFT -> {
          // first point of this horizontal line
          val newY = linesCount[BOTTOM_TO_TOP]!!
          for (col in y - 1 downTo newY) {
            result.add(matrix[x][col])
          }
          y = newY
          direction = BOTTOM_TO_TOP
          linesCount[RIGHT_TO_LEFT] = linesCount[RIGHT_TO_LEFT]!! + 1
        }

        BOTTOM_TO_TOP -> {
          // first point of this vertical line
          val newX = linesCount[LEFT_TO_RIGHT]!!
          for (row in x - 1 downTo newX) {
            result.add(matrix[row][y])
          }
          x = newX
          direction = LEFT_TO_RIGHT
          linesCount[BOTTOM_TO_TOP] = linesCount[BOTTOM_TO_TOP]!! + 1
        }
      }
    }
    return result
  }
}
