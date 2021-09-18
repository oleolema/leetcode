package p443

import java.util.*

/**
 * @author yueqiuhong
 * @date 2021-08-21 10:36
 */
class Solution {

    lateinit var chars: CharArray
    var index: Int = 0

    fun compress(chars: CharArray): Int {

        var sum = 1
        var i = 1
        this.chars = chars
        var preChar: Char = chars[0]
        while (i < chars.size) {
            if (preChar == chars[i]) {
                sum++
            } else {
                chars[index++] = preChar
                if (sum > 1) getNumsCount(sum)
                preChar = chars[i]
                sum = 1
            }
            i++
        }
        if (sum != 0) {
            chars[index++] = preChar
            if (sum > 1) getNumsCount(sum)
        }
        return index
    }

    private fun getNumsCount(n: Int): Int {
        var num = n
        val list = LinkedList<Char>()
        while (num != 0) {
            list.addFirst((num % 10 + 48).toChar())
            num /= 10
        }
        list.forEach { chars[index++] = it }
        return list.size
    }
}

fun main() {
    val chars = "aaaaaaaaaaaaaaaaaaaaaaaaaaaabbbcccddefg".toCharArray()
    val result = Solution().compress(chars)
    println(chars.take(result))
    println(result)
}