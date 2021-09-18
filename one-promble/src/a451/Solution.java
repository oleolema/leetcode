package a451;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    int[] a = new int[129];

    public String frequencySort(String s) {
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }
        TreeMap<Integer, String> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                continue;
            }
            map.putIfAbsent(a[i], "");
            map.put(a[i], map.get(a[i]) + ((char) i));
        }
        System.out.println(map);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                break;
            }
            String value = entry.getValue();
            for (int i1 = 0; i1 < value.length(); i1++) {
                for (int i = 0; i < entry.getKey(); i++) {
                    stringBuilder.append(value.charAt(i1));
                }
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String result = new Solution().frequencySort("hello");
        System.out.println(result);
    }
}