package com.yueban.array

import kotlin.math.max

object BestTimeToBuyAndSellStock {
  fun bestTimeToBuyAndSellStock1(prices: IntArray): Int {
    var result = 0
    prices.forEachIndexed { buyIndex, buyPrice ->
      for (sellIndex in buyIndex + 1 until prices.size) {
        result = max(result, prices[sellIndex] - buyPrice)
      }
    }
    return result
  }

  fun bestTimeToBuyAndSellStock2(prices: IntArray): Int {
    if (prices.size < 2) return 0

    var result = 0
    var buyPrice = Int.MAX_VALUE

    prices.forEach { price ->
      if (price < buyPrice) {
        buyPrice = price
      } else if (result < price - buyPrice) {
        result = price - buyPrice
      }
    }
    return result
  }
}
