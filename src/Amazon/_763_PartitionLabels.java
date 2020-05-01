package Amazon;
/**
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * */
import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0) return res;
        int len = S.length();
        int[] last = new int[26];
        for(int i = 0; i < len; i++){
            last[S.charAt(i) - 'a'] = i;
        }

        int start = -1;
        int end = -1;
        for(int i = 0; i < len; i++){
            if(start == -1) start = i;
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end){
                res.add(end - start + 1);
                start = -1;
            }
        }
        return res;
    }
}
