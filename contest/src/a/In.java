package a;

import org.junit.jupiter.api.Test;
import utils.Utils;

/**
 * @author yueqiuhong
 * @date 2020/10/16
 */
public class In {
    //1000000000 1000000000 1000000000
//        2 1000000000 1000000000
//        1000000000 1 1000000000
//        2 1 1000000000
//        1000000000 1000000000 1
//        2 1000000000 1
//        1000000000 1 1
//        2 1 1

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2500; i++) {
            sb.append(String.format("%s %s %s\n", 1000000000, 1000000000 - i, 1000000000))
                    .append(String.format("%s %s %s\n", 2, 1000000000, 1000000000 - i))
                    .append(String.format("%s %s %s\n", 1000000000 - i, 1, 1000000000))
                    .append(String.format("%s %s %s\n", 2, 1 + i, 1000000000))
                    .append(String.format("%s %s %s\n", 1000000000, 1000000000, 1 + i))
                    .append(String.format("%s %s %s\n", 2, 1000000000, 1))
                    .append(String.format("%s %s %s\n", 1000000000, 1 + i, 1))
                    .append(String.format("%s %s %s\n", 2, 1 + i, 1));
        }
        Utils.writeIn(sb.toString(), "a", "2");
    }


}