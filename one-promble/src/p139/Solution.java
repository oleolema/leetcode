package p139;

import java.util.*;

/**
 * @author yueqiuhong
 * @date 2020/11/1
 */
class Solution {

    HashSet<String> set;
    String s;
    HashMap<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        set = new HashSet<>(wordDict);
        f(0, 1);
        return f(0, 1);
    }

    public boolean f(int i, int j) {
        if (i == s.length()) {
            return true;
        }
        if (j > s.length()) {
            return false;
        }
        Boolean val = cache.get(i + " " + j);
        if (val != null) {
            return val;
        }
        for (int k = j; k <= this.s.length(); k++) {
            if (set.contains(this.s.substring(i, k))) {
                if (f(k, k + 1)) {
                    cache.put(k + " " + (k + 1), true);
                    return true;
                }
            }
        }
        cache.put(i + " " + j, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(b);
    }
}