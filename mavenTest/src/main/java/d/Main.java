package d;

import java.util.Scanner;

/**
 * @author leqiuhong@xiaomi.com
 * @date 2020/10/17
 */
public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i + i, k = 8; j <= n; j += i, k += 4) {
                sum += k;
            }
        }
        System.out.println(sum);
    }

}