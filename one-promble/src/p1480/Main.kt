package p1480

/**
 * @author yueqiuhong
 * @date 2021-08-28 10:09
 */
class Solution {
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            nums[i] = nums[i - 1] + nums[i]
        }
        return nums
    }
}

fun main() {

}