package a5811;

import java.util.Arrays;

/**
 * @author yueqiuhong
 * @date 2021/7/11
 */
public class Main {

    static class Solution {
        int w, h;
        int[][] map;

        public int colorTheGrid(int m, int n) {
            w = n;
            h = m;
            map = new int[h][w];
            for (int[] ints : map) {
                Arrays.fill(ints, -1);
            }
            return dfs(0, 0) * 3;
        }


        public int dfs(int x, int c) {
            if (x == w - 1) {
                return 1;
            }
            return dfs(x + 1, (c + 1) % 3) +
                    dfs(x + 1, (c + 2) % 3);
        }

    }

    public static void main(String[] args) {
        int result = new Solution().colorTheGrid(5, 5);
        System.out.println(result);
    }

}