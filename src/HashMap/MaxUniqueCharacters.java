package HashMap;

import java.util.HashMap;

public class MaxUniqueCharacters {
    public static int maxCharacters(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))) + 1;
                res = Math.max(res, i - j + 1);
            }
            map.put(s.charAt(i), i);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcdabcbb";
        System.out.println(maxCharacters(s));  // 5
    }
}
