package Amazon;

import java.util.*;
/**
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * */
public class _819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0) return "";
        //paragraph.toLowerCase();
        String[] strs = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        // String res = "";
        for(String str : strs){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> banList = new ArrayList<>();
        for(String ban : banned){
            banList.add(ban);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(!banList.contains(entry.getKey())){
                queue.offer(entry);
            }
        }

        Map.Entry<String, Integer> entry = queue.poll();
        return entry.getKey();

    }

}
