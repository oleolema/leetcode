package a5808;

import java.util.Arrays;

/**
 * @author yueqiuhong
 * @date 2021/7/11
 */
public class Main {

    static class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] a = new int[nums.length * 2];
            System.arraycopy(nums, 0, a, 0, nums.length);
            System.arraycopy(nums, 0, a, nums.length, nums.length);
            return a;
        }
    }

    public static void main(String[] args) {
        int[] result = new Solution().getConcatenation(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }

}