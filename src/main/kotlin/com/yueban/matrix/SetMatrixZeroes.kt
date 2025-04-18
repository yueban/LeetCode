package com.yueban.matrix

import com.yueban.matrix.SetMatrixZeroes.setMatrixZeroes1
import com.yueban.matrix.SetMatrixZeroes.setMatrixZeroes2

object SetMatrixZeroes {
  fun setMatrixZeroes1(matrix: Array<IntArray>) {
    val zeros = mutableListOf<Pair<Int, Int>>()

    val m = matrix.size
    val n = matrix[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (matrix[i][j] == 0) {
          zeros.add(i to j)
        }
      }
    }

    zeros.forEach { (i, j) ->
      matrix[i].fill(0)
      matrix.forEach { it[j] = 0 }
    }
  }

  /**
   * compare to [setMatrixZeroes1], filter same zero rows and columns by set to avoid redundant setting zeros in later steps.
   */
  fun setMatrixZeroes2(matrix: Array<IntArray>) {
    val rows = mutableSetOf<Int>()
    val columns = mutableSetOf<Int>()

    val m = matrix.size
    val n = matrix[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (matrix[i][j] == 0) {
          rows.add(i)
          columns.add(j)
        }
      }
    }

    rows.forEach { i ->
      matrix[i].fill(0)
    }

    columns.forEach { j ->
      matrix.forEach { it[j] = 0 }
    }
  }

  /**
   * compare to [setMatrixZeroes2], this method have a better space complexity which is O(1).
   * it uses matrix itself to temporary mark zero values, so it doesn't need additional space to store zeros on the first iteration.
   */
  fun setMatrixZeroes3(matrix: Array<IntArray>) {
    // use first row to mark all columns which need to be set to zeros
    // use first column to mark all rows which need to be set to zeros (except first row)
    // use firstRow to mark if first row itself needs to be set to zeros
    var firstRow = 1
    for (i in 0 until matrix.size) {
      for (j in 0 until matrix[i].size) {
        if (matrix[i][j] == 0) {
          if (i == 0) {
            firstRow = 0
          } else {
            matrix[i][0] = 0
          }
          matrix[0][j] = 0
        }
      }
    }

    // check first row, set columns to zeros if needed
    // except first column which is used to mark zeros for rows
    for (j in 1 until matrix[0].size) {
      if (matrix[0][j] == 0) {
        for (i in 0 until matrix.size) {
          matrix[i][j] = 0
        }
      }
    }

    // check first column, set rows to zeros if needed except first row, cause first row is
    // except row 0 because it is used to mark zeros for all columns
    for (i in 1 until matrix.size) {
      if (matrix[i][0] == 0) {
        for (j in 0 until matrix[0].size) {
          matrix[i][j] = 0
        }
      }
    }

    // now all the columns and rows are set to zero if needed (except first row and first column)
    // first column now can be set to zeros if needed
    if (matrix[0][0] == 0) {
      for (i in 1 until matrix.size) {
        matrix[i][0] = 0
      }
    }

    // first row can be set to zeros if needed
    if (firstRow == 0) {
      for (j in 0 until matrix[0].size) {
        matrix[0][j] = 0
      }
    }
  }
}
