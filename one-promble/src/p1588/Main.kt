package p1588

/**
 * @author yueqiuhong
 * @date 2021-08-29 10:20
 */
class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var sum = 0
        var middle = arr.size / 2
        var isOdd = arr.size % 2
        for (i in arr.indices) {
            println("i: ${arr[i]}\tk: ${middle - Math.abs(middle - i) + (arr.size + 1) / 2}")
            sum += (middle - Math.abs(middle - i) + (arr.size + 1) / 2) * arr[i]
        }

        return sum
    }

    fun sumOddLengthSubarrays1(arr: IntArray): Int {
        var sum = 0
        var k = 1
        while (k <= arr.size) {
            for (i in arr.indices) {
                if (arr.size - i < k) {
                    break
                }
                var j = i
                while (j < k + i && j < arr.size) {
                    sum += arr[j]
                    j++
                }
            }
            k += 2
        }
        return sum
    }
}

fun main() {
    println(Solution().sumOddLengthSubarrays1(intArrayOf(10, 11, 12)))
}