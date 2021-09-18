package com.nobug

/**
 * @author yueqiuhong
 * @create 2020-06-10 14:24
 */

class Solution {
    private val cache = mutableMapOf<Int, Int>()
    fun translateNum(num: Int): Int {
        if (num == 0) {
            return 1;
        }
        val cacheNum = cache[num]
        if (cacheNum != null) {
            return cacheNum
        }
        if (num % 100 in 10..25) {
            cache[num] = translateNum(num / 10) + translateNum(num / 100)
        } else {
            cache[num] = translateNum(num / 10)
        }
        return cache[num]!!
    }
}

fun main() {
    val translateNum = Solution().translateNum(100000)
    println(translateNum)
}