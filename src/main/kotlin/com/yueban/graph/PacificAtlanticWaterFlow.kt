package com.yueban.graph

object PacificAtlanticWaterFlow {
  /**
   * wrong solution. this solution can only detect points that flow to pacific only along the left-top directions or flow to atlantic only along the right-bottom directions.
   *
   * for example like below:
   *    1, 2, 3
   *    8, 9, 4
   *    7, 6, 5
   * [2,1] (number 6) can flow to pacific from 6->5->4->3, which flows to right-bottom and then left-top into pacific.
   */
//  fun pacificAtlanticWater1(heights: Array<IntArray>): List<List<Int>> {
//    val pacificArray = Array(heights.size) { BooleanArray(heights[0].size) }
//    val atlanticArray = Array(heights.size) { BooleanArray(heights[0].size) }
//
//    for (i in 0 until heights.size) {
//      for (j in 0 until heights[0].size) {
//        if (i == 0 || j == 0 || (heights[i][j] >= heights[i - 1][j] && pacificArray[i - 1][j]) || (heights[i][j] >= heights[i][j - 1] && pacificArray[i][j - 1])) {
//          pacificArray[i][j] = true
//        }
//      }
//    }
//
//    for (i in heights.size - 1 downTo 0) {
//      for (j in heights[0].size - 1 downTo 0) {
//        if (i == heights.size - 1 || j == heights[0].size - 1 || (heights[i][j] >= heights[i + 1][j] && atlanticArray[i + 1][j]) || (heights[i][j] >= heights[i][j + 1] && atlanticArray[i][j + 1])) {
//          atlanticArray[i][j] = true
//        }
//      }
//    }
//
//    val result = mutableListOf<List<Int>>()
//
//    for (i in 0 until heights.size) {
//      for (j in 0 until heights[0].size) {
//        if (pacificArray[i][j] && atlanticArray[i][j]) {
//          result.add(listOf(i, j))
//        }
//      }
//    }
//
//    return result
//  }

  fun pacificAtlanticWater1(heights: Array<IntArray>): List<List<Int>> {
    if (heights.isEmpty() || heights[0].isEmpty()) return emptyList()

    val m = heights.size
    val n = heights[0].size
    val pacific = Array(m) { BooleanArray(n) }
    val atlantic = Array(m) { BooleanArray(n) }

    // search for points that can flow into ocean from lower points to higher points
    fun dfs(x: Int, y: Int, ocean: Array<BooleanArray>, prevHeight: Int) {
      if (x < 0 || y < 0 || x >= m || y >= n || ocean[x][y] || heights[x][y] < prevHeight) return
      ocean[x][y] = true
      dfs(x - 1, y, ocean, heights[x][y])
      dfs(x + 1, y, ocean, heights[x][y])
      dfs(x, y - 1, ocean, heights[x][y])
      dfs(x, y + 1, ocean, heights[x][y])
    }

    for (i in 0 until m) {
      // from top side for pacific
      dfs(i, 0, pacific, heights[i][0])
      // from bottom side for atlantic
      dfs(i, n - 1, atlantic, heights[i][n - 1])
    }

    for (i in 0 until n) {
      // from left side for pacific
      dfs(0, i, pacific, heights[0][i])
      // from right side for atlantic
      dfs(m - 1, i, atlantic, heights[m - 1][i])
    }

    val result = mutableListOf<List<Int>>()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(listOf(i, j))
        }
      }
    }
    return result
  }
}
