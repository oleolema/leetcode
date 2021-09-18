package c;

import utils.Utils;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author yueqiuhong
 * @date 2020/10/17
 */
public class Warn {

//    static Scanner in = new Scanner(System.in);
    static Scanner in = Utils.readIn("c", "3");

    public static void main(String[] args) {

        String s = in.nextLine();
        while (true) {
            String a = s.replace("max", "");
            if (a.length() == s.length()) {
                break;
            }
            s = a;
        }
        System.out.println(s);
        Utils.writeOut(s, "c", "3.1");


    }

}