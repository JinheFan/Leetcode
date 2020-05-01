package Tree.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class treeMapFuction {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 5);
        map.put(7, 5);
        map.put(6, 5);
        map.put(9, 5);
        map.put(3, 5);

        System.out.println(map.ceilingKey(5)); // result : 6
        System.out.println(map.floorKey(5));  // result : 3

        System.out.println(map.higherKey(3)); // result : 6
        System.out.println(map.lowerKey(3)); // retuult : 1

        Map.Entry<Integer, Integer> entry = map.ceilingEntry(3);
        System.out.println(entry.getValue());   // result : 5
    }
}
