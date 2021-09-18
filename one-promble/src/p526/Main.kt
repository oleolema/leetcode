package p526

/**
 * @author yueqiuhong
 * @date 2021-08-16 11:20
 */
class Solution {

    private var maxNum: Int = 0
    private lateinit var used: IntArray

    fun countArrangement(n: Int): Int {
        this.maxNum = n
        this.used = IntArray(this.maxNum + 1) { 0 }
        var sum = 0
        var j = 1
        while (j < used.size) {
            this.used[j] = 1
            sum += f(1, j)
            this.used[j] = 0
            j++
        }
        return sum
    }

    fun f(i: Int, num: Int): Int {
        if (num % i != 0 && i % num != 0) {
            return 0
        }
        if (i == maxNum) {
            return 1
        }
        var j = 1
        var sum = 0
        while (j < used.size) {
            if (used[j] == 0) {
                used[j] = 1
                sum += f(i + 1, j)
                used[j] = 0
            }
            j++
        }
        return sum
    }
}

fun main() {
    val result = Solution().countArrangement(15)
    println(result)
}