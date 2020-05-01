package Google;

import java.util.*;
/**
 * Example:
 * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 * The system have already tracked down the following sentences and their corresponding times:
 * "i love you" : 5 times
 * "island" : 3 times
 * "ironman" : 2 times
 * "i love leetcode" : 2 times
 * Now, the user begins another search:
 *
 * Operation: input('i')
 * Output: ["i love you", "island","i love leetcode"]
 * Explanation:
 * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
 * */
public class _642_AutocompleteSystem {
    HashMap<String, Integer> map;
    String data = "";
    public _642_AutocompleteSystem(String[] sentences, int[] times) {
        this.map = new HashMap<>();
        int size = sentences.length;
        for(int i = 0; i < size; i++){
            map.put(sentences[i], map.getOrDefault(sentences[i], 0) + times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#'){
            map.put(data, map.getOrDefault(data, 0) + 1);
            data = "";
            return new ArrayList<>();
        }
        data += c;
        List<String> res = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getKey().startsWith(data)){
                pq.offer(entry);
            }
        }
        while(!pq.isEmpty() && res.size() < 3){
            Map.Entry<String, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        while(!pq.isEmpty()){
            pq.poll();
        }
        return res;
    }
}
