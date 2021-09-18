package com.yqh.t1;

import java.util.Arrays;
import java.util.Scanner;

public class Six {

    static Scanner in = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int sum = 0;
        int len1 = n;
        int len2 = n;
        for (int i = 0; i < n; i++) {
            len1 = findBound(b, n - len1, a[i]);
            len2 = findBound(c, n - len2, b[i]);
            sum += len1 * len2;
        }
        System.out.println(sum);
    }

    public static int findBound(int[] a, int start, int num) {
        for (int i = start; i < n; i++) {
            if (a[i] > num) {
                return n - i;
            }
        }
        return 0;
    }

}

/*
3
1 1 2
2 2 2
3 3 3
 */