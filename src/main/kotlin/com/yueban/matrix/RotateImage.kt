package com.yueban.matrix

object RotateImage {
  /**
   * think of matrix as an image. when you want to rotate a image for 90 degrees, you can reverse the matrix by the
   * line from (0,0) to (n-1,n-1), and then reverse every single row.
   */
  fun rotateImage1(matrix: Array<IntArray>) {
    // reverse matrix by the line from (0,0) to (n-1, n-1)
    val n = matrix.size

    for (i in 0 until n) {
      for (j in i until n) {
        val temp = matrix[i][j]
        matrix[i][j] = matrix[j][i]
        matrix[j][i] = temp
      }
    }

    // reverse every single row
    for (i in 0 until n) {
      matrix[i].reverse()
    }
  }
}
