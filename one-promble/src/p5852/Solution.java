package p5852;

/**
 * @author yueqiuhong
 * @date 2021/8/22
 */
class Solution {

    int[][] mat;
    int target;
    int w;
    int h;
    int minNum;
    int[][] cache;

    public int minimizeTheDifference(int[][] mat, int target) {
        this.mat = mat;
        this.target = target;
        this.h = mat.length;
        this.w = mat[0].length;
        minNum = Integer.MAX_VALUE;
        this.cache = new int[h][5000];
        for (int i = 0; i < h; i++) {
            this.cache[i] = new int[5000];
            for (int k = 0; k < 5000; k++) {
                this.cache[i][k] = -1;
            }
        }
        for (int i = 0; i < w; i++) {
            dfs(0, i, mat[0][i]);
        }
        return minNum;
    }

    void dfs(int j, int i, int num) {
        if (j == h - 1) {
            minNum = Math.min(Math.abs(target - num), minNum);
            return;
        }
        if (i == w) {
            return;
        }
        if (this.cache[j][num] != -1) {
            return;
        }
        this.cache[j][num] = 1;
        for (int i1 = 0; i1 < w; i1++) {
            if (j + 1 != h) {
                dfs(j + 1, i1, num + mat[j + 1][i1]);
            }
        }

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 5, 6, 7, 8, 9}, new int[]{7, 8, 9, 10, 11, 12}};
        int result = new Solution().minimizeTheDifference(a, 100);
        System.out.println(result);
    }

}