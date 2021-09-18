package a845

import kotlin.math.max

/**
 * @author yueqiuhong
 * @date 2020-10-25 13:45
 */
class Solution {
    fun longestMountain(a: IntArray): Int {
        var max = 0
        if (a.size < 3) {
            return max
        }
        var pre = a[0]
        var preDirection = 0
        var ascend = 0
        var decline = 0
        for (i in 1 until a.size) {
            val it = a[i]
            if (pre < it) {
                if (preDirection != 0) {
                    ascend = 0
                }
                ascend++
                preDirection = 0
            } else if (pre > it) {
                if (preDirection != 1) {
                    decline = 0
                }
                decline++
                preDirection = 1
            } else {
                preDirection = 2
                ascend = 0
                decline = 0
            }
            if (ascend != 0 && decline != 0 && preDirection == 1) {
                max = max(max, ascend + decline)
            }
            pre = it
        }
        return if (max == 0) max else max + 1
    }
}

fun main() {
    val longestMountain = Solution().longestMountain(intArrayOf(7, 4, 8))
    println(longestMountain)

}