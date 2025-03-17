package com.yueban.matrix

object SetMatrixZeroes {
  /**
   * use sets to filter same zero rows and columns to avoid redundant setting zeros in later steps.
   */
  fun setMatrixZeroes1(matrix: Array<IntArray>) {
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
   * compare to [setMatrixZeroes1], there could be same row and column values in Pair, which may lead to redundant setting zeros in later steps.
   */
  fun setMatrixZeroes2(matrix: Array<IntArray>) {
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
   * compare to [setMatrixZeroes1], this method have a better space complexity which is O(1).
   * it uses matrix itself to temporary mark zero values, so it doesn't need additional space to store zeros on the first iteration.
   */
  fun setMatrixZeroes3(matrix: Array<IntArray>) {
    // use row (index 1) to mark zeros for all columns
    // use column (index 0) to mark zeros for all rows
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

    // iterate from column 1 to end, if there is zero in the first row for current column, set the entire column to zero
    // except column 0 because it is used to mark zeros for all rows
    for (j in 1 until matrix[0].size) {
      if (matrix[0][j] == 0) {
        for (i in 0 until matrix.size) {
          matrix[i][j] = 0
        }
      }
    }

    // iterate from row 1 to end, if there is zero in the first column for current row, set the entire row to zero
    // except row 0 because it is used to mark zeros for all columns
    for (i in 1 until matrix.size) {
      if (matrix[i][0] == 0) {
        for (j in 0 until matrix[0].size) {
          matrix[i][j] = 0
        }
      }
    }

    // now all the columns and rows are set to zero if needed (except row 0 and column 0)
    // set column 0 to zeros if needed
    if (matrix[0][0] == 0) {
      for (i in 1 until matrix.size) {
        matrix[i][0] = 0
      }
    }

    // set row 0 to zeros if needed
    if (firstRow == 0) {
      for (j in 0 until matrix[0].size) {
        matrix[0][j] = 0
      }
    }
  }
}
