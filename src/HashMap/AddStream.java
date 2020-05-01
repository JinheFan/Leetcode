package HashMap;

import java.util.HashMap;
import java.util.Map;

public class AddStream {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public static boolean find(int sum) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int num2 = sum - num;
            if((num == num2 && entry.getValue() > 1) || (num != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        add(2);
        add(3);
        System.out.println(find(5));
    }
}
