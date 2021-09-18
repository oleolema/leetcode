package a5809;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yueqiuhong
 * @date 2021/7/11
 */
public class Main {

    static class Solution {


        public int countPalindromicSubsequence(String s) {
            int count = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 'a'; i <= 'z'; i++) {
                int l = 0;
                while (l < s.length() - 1 && s.charAt(l) != i) {
                    l++;
                }
                int r = s.length() - 1;
                while (r >= 1 && s.charAt(r) != i) {
                    r--;
                }
                if (s.charAt(l) == i && s.charAt(r) == i && r - l >= 2) {
                    for (int j = l + 1; j < r; j++) {
                        set.add(s.charAt(j));
                    }
                }
                count += set.size();
                set.clear();
            }
            return count;
        }

    }

    public static void main(String[] args) {
        int result = new Solution().countPalindromicSubsequence("bbcbaba");
        System.out.println(result);
    }

}