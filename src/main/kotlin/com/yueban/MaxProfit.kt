package com.yueban

import kotlin.math.max

object MaxProfit {
  fun maxProfit1(prices: IntArray): Int {
    var maxProfit = 0
    prices.forEachIndexed { buyIndex, buyPrice ->
      for (sellIndex in buyIndex + 1 until prices.size) {
        maxProfit = max(maxProfit, prices[sellIndex] - buyPrice)
      }
    }
    return maxProfit
  }

  fun maxProfit2(prices: IntArray): Int {
    if (prices.size < 2) return 0

    var maxProfit = 0
    var buyPrice = Int.MAX_VALUE

    prices.forEach { price ->
      if (price < buyPrice) {
        buyPrice = price
      } else if (maxProfit < price - buyPrice) {
        maxProfit = price - buyPrice
      }
    }
    return maxProfit
  }
}
