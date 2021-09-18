package p5851;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yueqiuhong
 * @date 2021/8/22
 */
class Solution {
    int len;
    Map<String, Boolean> numsMap = new HashMap<>();
    String result;

    public String findDifferentBinaryString(String[] nums) {
        len = nums.length;
        for (String num : nums) {
            numsMap.put(num, true);
        }
        dfs(0, "");
        return result;
    }

    boolean dfs(int i, String s) {
        if (i == len) {
            boolean b = !numsMap.containsKey(s);
            if (b) {
                result = s;
            }
            return b;
        }
        if (dfs(i + 1, s + "0")) {
            return true;
        }
        return dfs(i + 1, s + "1");
    }

    public static void main(String[] args) {
        String result = new Solution().findDifferentBinaryString(new String[]{"00", "01"});
        System.out.println(result);
    }
}