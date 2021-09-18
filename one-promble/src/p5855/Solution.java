package p5855;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author yueqiuhong
 * @date 2021/8/29
 */
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return 0;
            }
            return o1.compareTo(o2);
        });
        Collections.addAll(queue, nums);
        String value = null;
        for (int i = 0; i < k; i++) {
            value = queue.poll();
        }
        return value;
    }

    public static void main(String[] args) {

    }

}
