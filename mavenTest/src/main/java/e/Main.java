package e;

import utils.Utils;

import java.util.Scanner;

/**
 * @author yueqiuhong
 * @date 2020/10/17
 */
public class Main {

    //    static Scanner in = new Scanner(System.in);
    static Scanner in = Utils.readIn("e", "2");

    static int[] a;

    public static void main(String[] args) {
        int n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(f(0, 0) ? "YES" : "NO");
    }

    public static boolean f(int degree, int m) {
        if (degree % 360 == 0 && m == a.length) {
            return true;
        }
        if (m >= a.length) {
            return false;
        }
        return f(degree + a[m], m + 1) || f(degree - a[m], m + 1);
    }

}