package DP;
/**
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * */
public class _63_UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else if(i == 0){
                    for(int k = 0; k < n; k++){
                        if(obstacleGrid[i][k] != 1){
                            dp[i][k] = 1;
                        }else{
                            dp[i][k] = 0;
                            break;
                        }
                    }
                }else if(j == 0){
                    for(int k = 0; k < m; k++){
                        if(obstacleGrid[k][j] != 1){
                            dp[k][j] = 1;
                        }else{
                            dp[k][j] = 0;
                            break;
                        }
                    }
                }else{
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
