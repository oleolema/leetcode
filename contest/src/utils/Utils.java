package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author yueqiuhong
 * @date 2020/10/16
 */
public class Utils {

    public static Scanner readIn(String problem, String num) {
        try {
            System.out.println(new File(new File("").getAbsolutePath(), String.format("\\contest\\test\\%s\\%s.in", problem, num)).getAbsolutePath());
            return new Scanner(new FileInputStream(new File(new File("").getAbsolutePath(), String.format("\\contest\\test\\%s\\%s.in", problem, num)).getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeIn(String s, String problem, String num) {
        try {
            FileUtils.write(new File(new File("").getAbsolutePath(), String.format("\\contest\\test\\%s\\%s.in", problem, num)), s, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOut(String s, String problem, String num) {
        try {
            FileUtils.write(new File(new File("").getAbsolutePath(), String.format("\\contest\\test\\%s\\%s.out", problem, num)), s, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int randInt(int a, int b) {
        return (int) (Math.random() * (b - a) + a);
    }
}