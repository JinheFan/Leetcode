package Google;

import java.util.HashMap;

public class _205_IsomorphicStrings {
    /**
     * 205. Isomorphic Strings
     * For example,
     Given "egg", "add", return true.

     Given "foo", "bar", return false.

     Given "paper", "title", return true.

     egg add

     */
    // time : O(n^2) space : O(1)
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) continue;
                else return false;
            } else {
                if (!map.containsValue(b)) {
                    map.put(a, b);
                } else return false;
            }
        }

        return true;
    }
}
