package c;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import utils.Utils;

/**
 * @author yueqiuhong
 * @date 2020/10/16
 */
public class In {
    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9259; i++) {
            sb.append("mmamaxxmaxmaxammmamaxxmaxmaxamamaxmmaxaxmamaxmaxxxxmamaxxmaxmaxamamaxmmaxaxmamaxmaxxxxmamaxmmaxaxmamaxmaxxxx");
        }
        Utils.writeIn(sb.toString(), "c", "2");
    }

    @Test
    public void test3() {
        Utils.writeIn(RandomStringUtils.random(1_000_000, "max"), "c", "3");
    }

    @Test
    public void test4() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 333333; i++) {
            sb.append("ma");
        }
        for (int i = 0; i < 333333; i++) {
            sb.append("x");
        }
        Utils.writeIn(sb.toString(), "c", "4");
    }

    @Test
    public void test5() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 333333; i++) {
            sb.append("m");
        }
        for (int i = 0; i < 333333; i++) {
            sb.append("ax");
        }
        Utils.writeIn(sb.toString(), "c", "5");
    }
}