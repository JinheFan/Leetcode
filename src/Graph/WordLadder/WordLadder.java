package Graph.WordLadder;

import java.util.*;

public class WordLadder {
    public static int wordLadder(List<String> lists, String beignWord, String endWord){
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.offer(beignWord);
        set.add(beignWord);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                     StringBuilder sb = new StringBuilder(cur);
                     for(char c = 'a'; c <= 'z'; c++){
                         sb.setCharAt(j, c);
                         String newString = sb.toString();
                         if(newString.equals(endWord)){
                             return res + 1;
                         }
                         if(lists.contains(newString) && set.add(newString)){
                             queue.offer(newString);
                         }
                     }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> lists = new ArrayList<>();
        for(String str : strings){
            lists.add(str);
        }
        String beignWord = "hit";
        String endWord = "cog";

        System.out.println(wordLadder(lists, beignWord, endWord));
    }
}
