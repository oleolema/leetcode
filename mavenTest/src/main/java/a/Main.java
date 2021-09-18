package a;

import utils.Utils;

import java.util.Scanner;

/**
 * @author leqiuhong@xiaomi.com
 * @date 2020/10/14 10:49
 **/

public class Main {

    //    static Scanner in = new Scanner(System.in);
    static Scanner in = Utils.readIn("a", "2");

    public static void main(String[] args) {
        long n = in.nextInt();
        while (n-- != 0) {
            long x = in.nextInt();
            long y = in.nextInt();
            long k = in.nextInt();
            long l = k + y * k - 1;
            long z = l % (x - 1) == 0 ? 0 : 1;
            System.out.println((y * k + k - 1) / (x - 1) + k + z);
        }
    }
}
