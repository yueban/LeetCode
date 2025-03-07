package com.yueban.dynamic

object CoinChange {
  fun coinChange1(coins: IntArray, amount: Int): Int {
    if (amount < 1) return 0

    // Initialize the dp array with a value greater than the maximum possible coins needed.
    // `amount + 1` is used as a placeholder for "infinity" or "impossible".
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0

    for (i in 1..amount) {
      for (coin in coins) {
        if (i - coin >= 0) {
          // the default value of dp[i] and dp[i - coin] is `amount + 1` which means "impossible"
          // only when dp[i - coin] has a "possible" value < `amount + 1` can make dp[i] have a new "possible" value < `amount + 1`
          dp[i] = minOf(dp[i], dp[i - coin] + 1)
        }
      }
    }

    return if (dp[amount] > amount) -1 else dp[amount]
  }
}
