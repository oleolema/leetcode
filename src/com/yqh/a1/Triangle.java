/**
 * FileName:   Triangle
 * Author:     O����
 * Date:       2020/3/31 14:48
 * Description:
 * History:
 * author:     oleolema
 */
package com.yqh.a1;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ����
 *
 * @author O����
 * @create 2020/3/31
 * @since 1.0.0
 */

enum TriangleType {
    noTriangle(0, "��������"),
    equilateralTriangle(1, "�ȱ�������"),
    isoscelesTriangle(3, "����������"),
    generalTriangle(4, "һ��������");

    private int type;
    private String desc;

    TriangleType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

public class Triangle {

    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TriangleType check() {
        TriangleType triangleType = TriangleType.noTriangle;
        if ((a + b > c) && (b + c > a) && (c + a > b)) {
            triangleType = TriangleType.generalTriangle;
            int ac = a - c;
            int ab = a - b;
            int bc = b - c;
            if (ac == 0 || ab == 0 || bc == 0) {
                triangleType = TriangleType.isoscelesTriangle;
                if (ac == 0 && ab == 0) {
                    triangleType = TriangleType.equilateralTriangle;
                }
            }
        }
        return triangleType;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            try {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                if (a <= 0 || a > 100 || b <= 0 || b > 100 || c <= 0 || c > 100) {
                    System.out.println("ֻ������1-100������");
                    continue;
                }

                Triangle t = new Triangle(a, b, c);
                System.out.println(t.check().getDesc());
            } catch (InputMismatchException e) {
                System.out.println("����������");
            }
        }

    }


}