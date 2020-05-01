package DP;
/**
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * */
public class _509_Fib {
    public static int fibBackTracking(int N){
        if(N <= 1){
            return N;
        }
        return fibBackTracking(N - 1) + fibBackTracking(N - 2);
    }

    static int[] memo = new int[10];
    public static int fibBackTrackingMemo(int N){
        if(N <= 1){
            return N;
        }
        if(memo[N] == 0){
            memo[N] = fibBackTrackingMemo(N - 1) + fibBackTrackingMemo(N - 2);
        }
        return memo[N];
    }

    public static int dp(int N){
        if(N <= 1){
            return N;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(fibBackTracking(3));
        System.out.println(fibBackTrackingMemo(3));
        System.out.println(dp(3));
    }
}
