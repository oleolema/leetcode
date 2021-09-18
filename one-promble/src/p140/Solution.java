package p140;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yueqiuhong
 * @date 2020/11/1
 */
public class Solution {

    HashSet<String> set;
    String s;
    HashMap<String, Boolean> cache = new HashMap<>();
    List<List<String>> list = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        set = new HashSet<>(wordDict);
        f(0, 1, new ArrayList<>());
        return list.stream().map(it -> it.stream().reduce((o1, o2) -> o1 + " " + o2).get()).collect(Collectors.toList());
    }

    public boolean f(int i, int j, List<String> li0) {
        if (i == s.length()) {
            System.out.println(li0);
            list.add(li0);
            return true;
        }
        if (j > s.length()) {
            return false;
        }
        Boolean val = cache.get(i + " " + j);
        if (val != null) {
            return val;
        }
        for (int k = j; k <= s.length(); k++) {
            List<String> li = li0;
            if (i == 0) {
                li = new ArrayList<>();
            }
            String subStr = s.substring(i, k);
            if (set.contains(subStr)) {
                if (f(k, k + 1, li)) {
                    li.add(subStr);
                    cache.put(k + " " + (k + 1), true);
                }
            }
        }
        cache.put(i + " " + j, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> b = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(b);
    }

}