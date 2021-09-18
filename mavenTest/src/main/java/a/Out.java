package a;

import utils.Utils;

import java.util.Scanner;

/**
 * @author yueqiuhong
 * @date 2020/10/16
 */
public class Out {

    static Scanner in = Utils.readIn("a", "3");

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long n = in.nextInt();
        while (n-- != 0) {
            long x = in.nextInt();
            long y = in.nextInt();
            long k = in.nextInt();
            long l = k + y * k - 1;
            long z = l % (x - 1) == 0 ? 0 : 1;
            sb.append((y * k + k - 1) / (x - 1) + k + z).append('\n');
        }
        Utils.writeOut(sb.toString(), "a", "3");
    }
}