package DP;
/**
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * 先画图
 * 找规律
 * */
public class _72_MinDistance {
    public static int minDistance(String word1, String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
             for(int j = 0; j <= word2.length(); j++){
                 if(i == 0 && j == 0){
                     dp[i][j] = 0;
                 }else if(i == 0){
                     dp[i][j] = dp[i][j - 1] + 1;
                 }else if(j == 0){
                     dp[i][j] = dp[i - 1][j] + 1;
                 }else{
                     if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                         dp[i][j] = dp[i - 1][j - 1];
                     }else{
                         dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                                                        // delete      insert         replace
                     }
                 }
             }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
