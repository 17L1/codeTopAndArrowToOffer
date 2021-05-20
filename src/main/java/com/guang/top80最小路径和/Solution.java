package com.guang.top80最小路径和;

/**
 * @author: 17L1
 * @date: 2021年05月18日 10:55 上午
 * @method：
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int res = 0;
        int len1 = grid.length;
        int len2 = grid[0].length;
        if (len1 < 1 && len2 < 1){
            return 0;
        }
        int[][] dp = new int[len1][len2];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (i == 0 && j > 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0 && i > 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                if (i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[len1-1][len2-1];
    }
}
