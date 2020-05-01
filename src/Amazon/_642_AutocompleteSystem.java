package Amazon;
import java.util.*;
/**
 * "i love you" : 5 times
 * "island" : 3 times
 * "ironman" : 2 times
 * "i love leetcode" : 2 times
 * Now, the user begins another search:
 *
 * Operation: input('i')
 * Output: ["i love you", "island","i love leetcode"]
 * */
public class _642_AutocompleteSystem {
    HashMap<String, Integer> map = new HashMap<>();
    String data = "";
    public _642_AutocompleteSystem(String[] sentences, int[] times) {
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
        while(!pq.isEmpty() && res.size() < 3){         // we only need to output top 3 hot sentences
            Map.Entry<String, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        while(!pq.isEmpty()){
            pq.poll();
        }
        return res;
    }
}
