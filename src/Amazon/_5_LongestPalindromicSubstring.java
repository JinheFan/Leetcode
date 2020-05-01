package Amazon;
/**
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * */
public class _5_LongestPalindromicSubstring {
    public static String palindrome(String word){
        if(word == null || word.length() == 0){
            return "";
        }
        String res = "";
        boolean[][] dp = new boolean[word.length()][word.length()];
        int max = 0;
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j <= i; j++){
                dp[j][i] = word.charAt(j) == word.charAt(i) && ((i - j) <= 2 || dp[j + 1][i - 1]);
                if(dp[j][i]){
                    if(i - j + 1 > max){
                        max = i - j + 1;
                        res = word.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(palindrome("babad"));
    }
}
