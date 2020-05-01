package Amazon;

        import java.util.*;

public class WordLadder {
    public static boolean wordLadder(String start, String end, List<String> list) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    for(char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String newString = sb.toString();
                        if(newString.equals(end)) {
                            return true;
                        }
                        if(list.contains(newString) && visited.add(newString)) {
                            queue.offer(newString);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String start = "hot";
        String end = "cag";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("hat");
        list.add("cat");
        list.add("cag");

        System.out.print(wordLadder(start, end, list));
    }
}
