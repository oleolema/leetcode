package e;

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
        StringBuilder sb = new StringBuilder("20000\n");
        for (int i = 0; i < 20000; i++) {
            sb.append("10").append("\n");
        }
        Utils.writeIn(sb.toString(), "e", "2");
    }

}