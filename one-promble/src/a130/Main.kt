package a130

import java.util.*
import javax.swing.border.Border

/**
 * @author yueqiuhong
 * @date 2020-08-11 23:45
 */

class Solution {

    val P = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
    private lateinit var board: Array<CharArray>
    private var h = 0
    private var w = 0

    fun solve(board: Array<CharArray>): Unit {
        this.board = board
        h = board.size
        if (h == 0) {
            return
        }
        w = board[0].size
        for (i in 0 until w) {
            dfs(0, i)
            dfs(h - 1, i)
        }
        for (i in 0 until h) {
            dfs(i, 0)
            dfs(i, w - 1)
        }
        for (j in 0 until w) {
            for (i in 0 until h) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O'
                } else {
                    board[i][j] = 'X'
                }
            }
        }
    }

    fun dfs(y: Int, x: Int) {
        if (y < 0 || y >= h || x < 0 || x >= w || board[y][x] == 'X' || board[y][x] == 'Y') {
            return
        }
        board[y][x] = 'Y'
        for (p in P) {
            dfs(y + p[0], x + p[1])
        }
    }
}

fun main() {
    val array = arrayOf(charArrayOf('X', 'O', 'X', 'X'), charArrayOf('X', 'O', 'X', 'X'), charArrayOf('X', 'X', 'O', 'X'), charArrayOf('X', 'O', 'X', 'X'));

    Solution().solve(array)

    println(array.forEach { println(it.contentToString()) })

}