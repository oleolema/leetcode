package p5854;

import java.util.Arrays;

/**
 * @author yueqiuhong
 * @date 2021/8/29
 */
public class Solution {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }
        return min;
    }

}