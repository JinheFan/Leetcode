package HashMap;

import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class _243_ShortestDistance {
    public static int shortestDist(String[] strs, String s, String t) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.computeIfAbsent(strs[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> l1 = map.get(s);
        List<Integer> l2 = map.get(t);
        int res = Integer.MAX_VALUE;

        for(int num1 : l1) {
            for(int num2 : l2) {
                res = Math.min(res, Math.abs(num1 - num2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"ab", "ab", "cd", "ab", "ab", "ab", "cd"};
        System.out.println(shortestDist(strings, "ab", "cd"));  // 1
    }
}
