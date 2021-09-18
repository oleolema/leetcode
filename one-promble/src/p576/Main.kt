package p576

/**
 * @author yueqiuhong
 * @date 2021-08-15 11:43
 */
class Solution {

    private var w: Int = 0
    private var maxMove: Int = 0
    private var h: Int = 0
    private lateinit var cache: Array<Array<IntArray>>


    companion object {
        private val P = arrayListOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0))
        private const val MAX_NUM = 1000000007
    }

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        this.h = m
        this.w = n
        this.maxMove = maxMove
        cache = Array(this.h) { Array(this.w) { IntArray(maxMove) { -1 } } }
        return f(startRow, startColumn, 0)
    }

    fun f(y: Int, x: Int, moveCount: Int): Int {
        if (y < 0 || y >= h || x < 0 || x >= w) {
            return 1
        }
        if (moveCount == maxMove) {
            return 0
        }
        if (cache[y][x][moveCount] != -1) {
            return cache[y][x][moveCount]
        }
        var sum = 0
        P.forEach {
            sum = (sum % MAX_NUM + f(y + it[0], x + it[1], moveCount + 1) % MAX_NUM) % MAX_NUM
        }
        cache[y][x][moveCount] = sum
        return cache[y][x][moveCount]
    }
}

fun main() {
    val result = Solution().findPaths(m = 50, n = 50, maxMove = 50, startRow = 0, startColumn = 0)
    println(result)
}