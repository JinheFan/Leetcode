package HashMap;

import java.util.HashMap;

public class validAnagram {
    public boolean isValid(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int num : count) {
            if(num != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                int count = map.get(c);
                if(count == 1) {
                    map.remove(c);
                }else {
                    map.put(c, map.get(c) - 1);
                }
            }else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        validAnagram valid = new validAnagram();
        System.out.println(valid.isValid2("abc", "bac"));
    }
}
