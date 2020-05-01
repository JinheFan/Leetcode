package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class _381_InsertDeleteGetRandomDuplicatesallowed {
    /**
     * 381. Insert Delete GetRandom O(1) - Duplicates allowed
     * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
     * collection.insert(1);
     *
     * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
     * collection.insert(1);
     *
     * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
     * collection.insert(2);
     *
     * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
     * collection.getRandom();
     *
     * // Removes 1 from the collection, returns true. Collection now contains [1,2].
     * collection.remove(1);
     * time : O(1)
     */

    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;
    Random rmd;

    public _381_InsertDeleteGetRandomDuplicatesallowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
