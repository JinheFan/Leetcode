package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * */
public class _245_shortestWordDistance {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
        }
        int res1 = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            List<Integer> l = map.get(word1);
            for(int i = 1; i < l.size(); i++){
                for(int j = 0; j < i; j++){
                    res1 = Math.min(res1, Math.abs(l.get(i) - l.get(j)));
                }
            }
            return res1;
        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int a1 : l1){
            for(int a2 : l2){
                res = Math.min(res, Math.abs(a1 - a2));
            }
        }
        return res;
    }
}
