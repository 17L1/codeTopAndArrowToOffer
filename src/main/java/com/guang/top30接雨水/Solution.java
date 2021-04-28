package com.guang.top30接雨水;

public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 2){
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[len-1];
        int left = 1;
        int right = len - 2;
        int res = 0;
        while (left <= right){
            int minHeight = Math.min(leftMax,rightMax);
            if (minHeight == leftMax){
                if (minHeight > height[left]){
                    res += minHeight - height[left];
                    left++;
                    continue;
                }
                leftMax = height[left];
                left++;
            }else {
                if (minHeight > height[right]){
                    res += minHeight - height[right];
                    right--;
                    continue;
                }
                rightMax = height[right];
                right--;
            }
        }
        return res;
    }
}
