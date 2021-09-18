/**
 * FileName:   Main
 * Author:     OÁËÂð
 * Date:       2020/4/7 14:39
 * Description:
 * History:
 * author:     oleolema
 */
package com.yqh.a2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ¡´¡µ
 *
 * @author OÁËÂð
 * @create 2020/4/7
 * @since 1.0.0
 */
public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] products = new String[]{"", "Ñ©±Ì", "¿ÉÀÖ", "ÆßÏ²"};

        while (true) {
            System.out.print("1.5 or 2 : ");
            Double money = in.nextDouble();
            if (money.equals(1.5) || money.equals(2.0)) {
                for (int i = 1; i < products.length; i++) {
                    System.out.print(i + ". " + products[i] + "\t");
                }
                System.out.print(": ");
                int num = in.nextInt();
                System.out.print("ËÍ³ö: " + products[num]);
                if (money.equals(2.0)) {
                    System.out.print("\t ÕÒÁã: 0.5");
                }
                System.out.println("\n");
            }
        }


    }


}