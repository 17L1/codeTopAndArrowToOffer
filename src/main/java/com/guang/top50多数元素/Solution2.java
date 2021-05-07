package com.guang.top50多数元素;

public class Solution2 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res){
                num++;
            }else if(--num == 0){
                res = nums[i];
                num = 1;
            }
        }
        return res;
    }
}
