package com.guang.top14买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int pre = 0;
        int cur = -prices[0];
        for(int i = 1; i < len; i++){
            pre = Math.max(pre,cur + prices[i]);
            cur = Math.max(cur,-prices[i]);
        }
        return pre;
    }
}
