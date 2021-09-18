package w258.p5868;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author yueqiuhong
 * @date 2021/9/12
 */
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>(rectangles.length);
        for (int[] rectangle : rectangles) {
            Double key = (double) rectangle[0] / rectangle[1];
            Integer orDefault = map.getOrDefault(key, 0);
            map.put(key, orDefault + 1);
        }
        int count = 0;
        for (Integer value : map.values()) {
            count += value * (value - 1) / 2;
        }
        System.out.println(map);
        return count;
    }

    public static void main(String[] args) {
        long l = new Solution().interchangeableRectangles(new int[][]{
                new int[]{4, 8},
                new int[]{3, 6},
                new int[]{10, 20},
                new int[]{15, 30},
                new int[]{14, 30},
                new int[]{13, 30},
                new int[]{10, 3},
                new int[]{20, 6}
        });
        System.out.println(l);
    }
}