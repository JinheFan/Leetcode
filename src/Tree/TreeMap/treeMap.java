package Tree.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 5);
        map.put(7, 5);
        map.put(6, 5);
        map.put(9, 5);
        map.put(3, 5);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}
// result ： 1 3 6 7 9
