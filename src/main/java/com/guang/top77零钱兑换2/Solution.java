package com.guang.top77零钱兑换2;

/**
 * @author: 17L1
 * @date: 2021年05月15日 6:42 下午
 * @method：
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int i = 1; i <= amount ; i++) {
                if (i < coin){
                    continue;
                }
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
