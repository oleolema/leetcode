package p233

/**
 * @author yueqiuhong
 * @date 2021-08-13 21:51
 */
class Solution {
    fun countDigitOne(n: Int): Int {
        var k = 1
        var num = n
        var sum = 0
        while (num > 0) {
            val m = num % 10
            val b = getCount1(m, k)
            println("${m}, $k, $b")
            sum += b
            k *= 10
            num /= 10
        }
        return sum
    }

    fun getCount1(num: Int, k: Int): Int {
        if (num == 0) {
            return 0
        }
        if (k == 1) {
            return if (num == 1) 0 else 1
        } else {
            return if (num == 1) getCount1(9, k / 10) + getCount1(1, k / 10)
            else (getCount1(9, k / 10) + getCount1(1, k / 10)) * num + k
        }
    }


}

fun main() {
    val result = Solution().countDigitOne(13)
    println(result)
}