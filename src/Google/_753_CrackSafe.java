package Google;

import java.util.HashSet;
import java.util.Set;
/**
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * */
public class _753_CrackSafe {
    int n;
    int k;

    // DFS+Backtracking
    public String crackSafe(int n, int k) {
        this.n = n;
        this.k = k;

        long total = (long)Math.pow(k, n);
        // Stores the final result
        StringBuilder sb = new StringBuilder();
        // Keeps track of all the visited pwds
        Set<String> visited = new HashSet<>();
        // Starting with the pwd 0...0
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        visited.add(sb.toString());

        dfs(sb, visited, total);

        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, Set<String> visited, long total) {
        if (visited.size() == total) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            sb.append(i);
            String newPwd = sb.toString().substring(sb.length()-n, sb.length());
            if (!visited.contains(newPwd)) {
                visited.add(newPwd);
                if (dfs(sb, visited, total)) {
                    return true;
                }
                visited.remove(newPwd);
            }
            sb.delete(sb.length()-1, sb.length());
        }
        return false;
    }

}
