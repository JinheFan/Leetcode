package Amazon;
/**
 * String p = "abc", String q = "abcd"
 * return true
 * */
public class Subsequence {
    public static boolean isSubsequence(String p, String q){
        int[] count = new int[26];
        for(char c : q.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : p.toCharArray()){
            if(count[c - 'a'] == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String p = "abc";
        String q = "abcd";
        System.out.println(isSubsequence(p, q));
    }
}
