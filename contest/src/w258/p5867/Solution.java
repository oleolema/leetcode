package w258.p5867;

import java.util.LinkedList;

/**
 * @author yueqiuhong
 * @date 2021/9/12
 */
class Solution {
    public String reversePrefix(String word, char ch) {
        LinkedList<Character> list = new LinkedList<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) == ch) {
                list.push(word.charAt(i));
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach(stringBuilder::append);
                for (int j = i + 1; j < length; j++) {
                    stringBuilder.append(word.charAt(j));
                }
                return stringBuilder.toString();
            }
            list.addFirst(word.charAt(i));
        }
        return word;
    }

    public static void main(String[] args) {
        String s = new Solution().reversePrefix("abcdefd", '1');
        System.out.println(s);
    }
}