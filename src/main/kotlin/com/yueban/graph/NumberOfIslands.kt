package com.yueban.graph

object NumberOfIslands {
  fun numberOfIslands1(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val m = grid.size
    val n = grid[0].size
    val lands = mutableSetOf<Pair<Int, Int>>()

    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == '1') {
          lands.add(i to j)
        }
      }
    }

    val visited = Array(m) { BooleanArray(n) }

    fun dfs(x: Int, y: Int) {
      if (x < 0 || y < 0 || x >= m || y >= n) return
      if (visited[x][y]) return
      if (grid[x][y] == '0') return

      lands.remove(x to y)
      visited[x][y] = true

      dfs(x - 1, y)
      dfs(x + 1, y)
      dfs(x, y - 1)
      dfs(x, y + 1)
    }

    var result = 0
    while (lands.isNotEmpty()) {
      val land = lands.first()
      dfs(land.first, land.second)
      result++
    }
    return result
  }

  /**
   * Optimize from [numberOfIslands1], we don't need lands and visited to track data within dfs,
   * Simply mark `grid[i][j]` as a char different from '1' like '2', which means this grid has been visited.
   * By this way, we can simply iterate all grids, every time we dfs a "land" grid, we will mark all the adjacent lands to '2'.
   * So the lands marked as '2' will be skipped both in iterating and dfs function.
   */
  fun numberOfIslands2(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size

    fun dfs(x: Int, y: Int) {
      if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != '1') return

      grid[x][y] = '2'

      dfs(x - 1, y)
      dfs(x + 1, y)
      dfs(x, y - 1)
      dfs(x, y + 1)
    }

    var result = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == '1') {
          result++
          dfs(i, j)
        }
      }
    }
    return result
  }
}
