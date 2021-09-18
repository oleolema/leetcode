package a645;

import java.util.Arrays;

/**
 * @author yueqiuhong
 * @date 2021/7/4
 */
public class Solution {

    private static final int MAX_ = 100001;

    public int[] findErrorNums(int[] nums) {
        boolean[] a = new boolean[MAX_];
        int repeat = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a[nums[i]]) {
                repeat = nums[i];
            }
            a[nums[i]] = true;
        }
        int miss = 0;
        for (int i = 1; i < a.length; i++) {
            if (!a[i]) {
                miss = i;
                break;
            }
        }
        return new int[]{repeat, miss};
    }

    public static void main(String[] args) {
        int[] result = new Solution().findErrorNums(new int[]{1, 1});
        System.out.println(Arrays.toString(result));
    }

}