package c;

import utils.Utils;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author yueqiuhong
 * @date 2020/10/16
 */
public class Main {

        static Scanner in = new Scanner(System.in);
//    static Scanner in = Utils.readIn("c", "1");

    public static void main(String[] args) {

        char[] chars = in.nextLine().toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == 'm') {
                stack.push(c);
            } else if (c == 'a' && !stack.isEmpty()) {
                if (stack.peek() == 'm') {
                    stack.push(c);
                } else {
                    stack.push(c);
                    sb.append(getAndClear(stack));
                    stack.clear();
                }
            } else if (c == 'x' && !stack.isEmpty()) {
                if (stack.peek() == 'a') {
                    stack.pop();
                    stack.pop();
                } else {
                    stack.push(c);
                    sb.append(getAndClear(stack));
                    stack.clear();
                }
            } else {
                if (!stack.isEmpty()) {
                    sb.append(getAndClear(stack));
                }
                sb.append(c);
            }
        }
        sb.append(getAndClear(stack));
        System.out.println(sb);

    }

    private static String getAndClear(LinkedList<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

}