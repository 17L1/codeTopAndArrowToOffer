package com.guang.top31爬楼梯;

public class Solution {
    public int climbStairs(int n){
        if (n < 2){
            return n;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n ; i++) {
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;

        }
        return cur;

    }
}
