package com.guang.top10最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len < 1){
            return 0;
        }
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i],pre + nums[i]);
            res = Math.max(pre,res);
        }
        return res;
    }
}
