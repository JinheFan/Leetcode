package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SameKey {
    public static void sameKey(String[] strs) {
        if(strs == null || strs.length == 0) {
            return;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            String key = "";
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if(count[i] != 0) {
                    key += String.valueOf(count[i]) + (i + 'a');
                }
            }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        for(List<String> list : map.values()) {
            print(list);
        }
    }

    private static void print(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        sameKey(strs);
    }
}
// result :
// eat
//tea
//ate
//
//bat
//
//tan
//nat