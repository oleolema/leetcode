package f;

/**
 * @author yueqiuhong
 * @date 2020/10/18
 */
public class Main {

    static int[] pre = new int[100001];

    public static void main(String[] args) {

    }

    public static int find(int a) {
        int p = a;
        while (p != pre[p]) {
            p = pre[p];
        }
        while (a != p) {
            int next = pre[a];
            pre[a] = p;
            a = next;
        }
        return p;
    }

    //    a --> b
    public static void join(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            pre[fa] = fb;
        }
    }


}