package a696

import java.util.*
import kotlin.collections.LinkedHashSet

/**
 * @author yueqiuhong
 * @date 2020-08-10 22:52
 */


class Solution {
    fun countBinarySubstrings(s: String): Int {
        val stack0 = LinkedList<Char>()
        val stack1 = LinkedList<Char>()
        var count = 0
        var p = -1
        for (c in s) {
            if (c == '0') {
                if (p == 1) {
                    stack0.clear()
                }
                stack0.add(c)
                if (stack1.isNotEmpty()) {
                    stack1.pop()
                    count++
                }
                p = 0
            } else {
                if (p == 0) {
                    stack1.clear()
                }
                stack1.add(c)
                if (stack0.isNotEmpty()) {
                    stack0.pop()
                    count++
                }
                p = 1
            }
        }
        return count
    }
}

fun main() {
    val countBinarySubstrings = Solution().countBinarySubstrings("11101000")
    println(countBinarySubstrings)
}