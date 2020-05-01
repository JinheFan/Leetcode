package Amazon;

import java.util.*;
/**
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * */
public class WordLadderPath {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordList);

        buildGraph(beginWord, endWord, map, dict);
        dfs(beginWord, endWord, res, new ArrayList<>(), map);
        return res;
    }

    public void buildGraph(String beginWord, String endWord, HashMap<String, List<String>> map, HashSet<String> dict){
        HashSet<String> visited = new HashSet<>();
        HashSet<String> toVisit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        toVisit.add(beginWord);
        boolean foundEnd = false;

        while(!queue.isEmpty()){
            visited.addAll(toVisit);
            toVisit.clear();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                List<String> children = getNextLevel(word, dict);
                for(String child : children){
                    if(child.equals(endWord)){
                        foundEnd = true;
                    }
                    if(!visited.contains(child)){
                        if(!map.containsKey(word)){
                            map.put(word, new ArrayList<>());
                        }
                        map.get(word).add(child);
                    }
                    if(!visited.contains(child) && !toVisit.contains(child)){
                        queue.offer(child);
                        toVisit.add(child);
                    }
                }
            }
            if(foundEnd){
                break;
            }
        }
    }

    public List<String> getNextLevel(String word, HashSet<String> dict){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            StringBuilder sb = new StringBuilder(word);
            for(char c = 'a'; c <= 'z'; c++){
                sb.setCharAt(i, c);
                String newString = sb.toString();
                if(dict.contains(newString)){
                    list.add(newString);
                }
            }
        }
        return list;
    }

    public void dfs(String curWord, String endWord, List<List<String>> res, List<String> list, HashMap<String, List<String>> map){
        list.add(curWord);
        if(curWord.equals(endWord)){
            res.add(new ArrayList<>(list));
        }else if(map.containsKey(curWord)){
            for(String str : map.get(curWord)){
                dfs(str, endWord, res, list, map);
            }
        }
        list.remove(list.size() - 1);
    }

}
