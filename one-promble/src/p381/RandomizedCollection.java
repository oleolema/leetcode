package p381;

import java.util.*;

/**
 * @author yueqiuhong
 * @date 2020/10/31
 */
public class RandomizedCollection {
    /**
     * value --> (index,index...)
     */
    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    List<Integer> list = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        if (map.containsKey(val)) {
            HashSet<Integer> set = map.get(val);
            set.add(list.size() - 1);
            return false;
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(list.size() - 1);
            map.put(val, set);
            return true;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        HashSet<Integer> set = map.get(val);
        if (set == null || set.isEmpty()) {
            return false;
        }
        int swapA = set.stream().findFirst().get();
        int swapB = list.size() - 1;
        set.remove(swapA);
        if (swapA != swapB) {
            HashSet<Integer> swapSetB = map.get(list.get(swapB));
            swapSetB.add(swapA);
            swapSetB.remove(swapB);
            Collections.swap(list, swapA, swapB);
        }
        list.remove(swapB);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}