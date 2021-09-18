package p5857;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yueqiuhong
 * @date 2021/8/29
 */
class Solution {

    String binary;
    int[] cache;
    Set<String> set;

    public int numberOfUniqueGoodSubsequences(String binary) {
        this.binary = binary;
        cache = new int[binary.length() + 1];
        set = new HashSet<>(binary.length());
        Arrays.fill(cache, -1);
        dfs(0, new StringBuilder());
        return set.size();
    }

    public void dfs(int i, StringBuilder sb) {
        if (i == binary.length()) {
            return;
        }
        sb.append(binary.charAt(i));
        if (!set.contains(sb.toString())) {
            if (sb.length() == 1 || sb.charAt(0) == '1') {
                System.out.println(sb);
                set.add(sb.toString());
            }
        }
        dfs(i + 1, sb);
        if (cache[i] != -1) {
            return;
        }
//        if (i + 1 < binary.length() && binary.charAt(i + 1) == '1') {
            dfs(i + 1, new StringBuilder());
//        }
        cache[i] = 1;
        sb.setLength(sb.length() - 1);
    }

    public static void main(String[] args) {
        int i = new Solution().numberOfUniqueGoodSubsequences("101");
        System.out.println(i);
    }
}
