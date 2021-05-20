package com.guang.top76零钱兑换1;

import java.util.Arrays;

/**
 * @author: 17L1
 * @date: 2021年05月15日 6:35 下午
 * @method：
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount + 1];
        //给其每个位置上赋予一个不可能产生但大于所有结果的值
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int coin : coins){
                if (i - coin >= 0 && dp[i-1] != amount + 1){
                    dp[i] = Math.min(dp[i],dp[i-coin] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1){
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
