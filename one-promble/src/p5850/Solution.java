package p5850;

/**
 * @author yueqiuhong
 * @date 2021/8/22
 */
public class Solution {


    public static int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public int findGCD(int[] nums) {
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        return getGCD(maxNum, minNum);
    }

    public static void main(String[] args) {
        int gcd = new Solution().findGCD(new int[]{2, 5, 6, 9, 10});
        System.out.println(gcd);
    }
}