package w258.p5869;

/**
 * @author yueqiuhong
 * @date 2021/9/12
 */
class Solution {

    int[] used = new int[15];
    int max = 1;
    String s;
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    public int maxProduct(String s) {
        this.s = s;
        f2(0);
        return max;
    }

    void f2(int index) {
        if (isP(s1) && isP(s2)) {
            max = Math.max(s1.length() * s2.length(), max);
        }
        if (index >= s.length()) {
            return;
        }
        // 不要这个值
        f2(index + 1);

        used[index] = 1;
        // s1要这个值
        s1.append(s.charAt(index));
        f2(index + 1);
        s1.setLength(s1.length() - 1);
        // s2要这个值
        s2.append(s.charAt(index));
        f2(index + 1);
        s2.setLength(s2.length() - 1);
        used[index] = 0;
    }


    boolean isP(StringBuilder s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int s = new Solution().maxProduct("pei");
        System.out.println(s);
//        StringBuilder s1 = new StringBuilder();
//        s1.append("1234321");
//        System.out.println(new Solution().isP(s1));
    }

}