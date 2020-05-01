package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * */
public class _139_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict){
        return helper(s, new HashSet<>(wordDict), 0);
    }

    private static boolean helper(String s, HashSet<String> wordDict, int index){
        if(index >= s.length()){
            return true;
        }
        for (int i = index + 1; i <= s.length(); i++) {
             if(wordDict.contains(s.substring(index, i)) && helper(s, wordDict, i)){
                 return true;
             }
        }
        return false;
    }

    public static boolean wordBreakMeomo(String s, List<String> wordDict){
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private static boolean helper(String s, HashSet<String> wordDict, int index, Boolean[] memo){
        if(index >= s.length()){
            return true;
        }
        if(memo[index] != null){
            return memo[index];
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(index, i)) && helper(s, wordDict, i, memo)){
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreakMeomo(s, wordDict));
    }
}
