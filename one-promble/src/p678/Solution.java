package p678;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yueqiuhong
 * @date 2021/9/12
 */
class Solution {

    public boolean checkValidString(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> starStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
            }
        }
        while (!stack.isEmpty() && !starStack.isEmpty()) {
            Integer a = stack.pop();
            Integer b = starStack.pop();
            if (a > b) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = new Solution().checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        System.out.println(b);
    }

}