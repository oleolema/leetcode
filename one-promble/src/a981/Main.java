package a981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yueqiuhong
 * @date 2021/7/10
 */
public class Main {

    static class TimeMap {

        HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            System.out.print("null ");
        }

        public void set(String key, String value, int timestamp) {
            System.out.print("null ");
            map.computeIfAbsent(key, it -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.get(key);
            if (treeMap == null) {
                return "";
            }
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            if (entry == null) {
                return "";
            }
            System.out.print(entry.getValue() + " ");
            return entry.getValue();
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        timeMap.get("foo", 1);
        timeMap.get("foo", 3);
        timeMap.set("foo", "bar2", 4);
        timeMap.get("foo", 4);
        timeMap.get("foo", 5);
    }

}