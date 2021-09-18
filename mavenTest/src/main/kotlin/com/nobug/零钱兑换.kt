package com.nobug

/**Six
 * @author yueqiuhong
 * @create 2020-06-10 14:49
 */


class Solution1 {
    private lateinit var coins: IntArray;
    private val cache = Array(5001) { IntArray(5001) { -1 } }

    fun change(amount: Int, coins: IntArray): Int {
        this.coins = coins
        return f(coins.size - 1, amount)
    }

    private fun f(i: Int, amount: Int): Int {
        if (amount == 0) {
            return 1
        }
        if (i == -1 || amount < 0) {
            return 0
        }
        if (cache[i][amount] != -1) {
            return cache[i][amount]
        }
        cache[i][amount] = if (amount - coins[i] >= 0) {
            f(i - 1, amount) + f(i, amount - coins[i])
        } else {
            f(i - 1, amount)
        }
        return cache[i][amount]
    }
}

fun main() {
    val change = Solution1().change(5, intArrayOf(1, 2, 5))
    println(change)
}