package DP;

        import java.util.Arrays;

public class Knapsack {
    public static int knapsack(int[] value, int[] weight, int N, int C){
        int[][] dp = new int[N][C + 1];
        for(int i = 0; i <= C; i++){
            dp[0][i] = (i >= weight[0]) ? value[0] : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[N - 1][C];
    }

    public static int knapsackOptimize(int[] value, int[] weight, int N, int C){    // 有问题
        int[][] dp = new int[2][C + 1];
        for(int i = 0; i <= C; i++){
            dp[0][i] = (i >= weight[0]) ? value[0] : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j < weight[i]){
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }else{
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], value[i] + dp[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return dp[(N - 1) % 2][C];
    }

    public static void knapsackPrint(int[] value, int[] weight, int N, int C){
        int[][] dp = new int[N][C + 1];
        String[][] strings = new String[N][C + 1];
        for(int i = 0; i <= C; i++){
            dp[0][i] = (i >= weight[0]) ? value[0] : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                    if(strings[i - 1][j] != null){
                        strings[i][j] = strings[i - 1][j];
                    }
                }else{
                    if(dp[i - 1][j] >  value[i] + dp[i - 1][j - weight[i]]){
                        dp[i][j] = dp[i - 1][j];
                        if(strings[i - 1][j] != null){
                            strings[i][j] = strings[i - 1][j];
                        }
                    }else{
                        dp[i][j] = value[i] + dp[i - 1][j - weight[i]];
                        if(strings[i - 1][j - weight[i]] != null){
                            strings[i][j] = strings[i - 1][j - weight[i]] + " " + i;
                        }else{
                            strings[i][j] = i + " ";
                        }
                    }
                }
            }
        }
        for(String[] s : strings){
            System.out.println(Arrays.toString(s));
        }
    }

    public static void main(String[] args) {
        int[] value = new int[]{5, 10, 12, 16};
        int[] weight = new int[]{5, 2, 4, 4};
        int N = 4;
        int C = 10;
        //System.out.println(knapsack(value, weight, N, C));
        //System.out.println(knapsackOptimize(value, weight, N, C));
        knapsackPrint(value, weight, N, C);
    }
}
