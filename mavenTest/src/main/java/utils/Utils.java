package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author yueqiuhong
 * @date 2020/10/16
 */
public class Utils {


    public static final String READ_IN = "\\mavenTest\\src\\main\\test\\%s\\%s.in";
    public static final String WRITE_IN = "\\src\\main\\test\\%s\\%s.in";
    public static final String OUT = "\\mavenTest\\src\\main\\test\\%s\\%s.out";

    static Long start;

    public static Scanner readIn(String problem, String num) {
        try {
            File file = new File(new File("").getAbsolutePath(), String.format(READ_IN, problem, num));
            System.out.println(file.getAbsolutePath());
            start = System.currentTimeMillis();
            return new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeIn(String s, String problem, String num) {
        try {
            File file = new File(new File("").getAbsolutePath(), String.format(WRITE_IN, problem, num));
            System.out.println(file.getAbsolutePath());
            FileUtils.write(file, s, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOut(String s, String problem, String num) {
        try {
            System.out.println("ºÄÊ±: " + (System.currentTimeMillis() - start));
            File file = new File(new File("").getAbsolutePath(), String.format(OUT, problem, num));
            System.out.println(file.getAbsolutePath());
            FileUtils.write(file, s, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int randInt(int a, int b) {
        return (int) (Math.random() * (b - a) + a);
    }
}