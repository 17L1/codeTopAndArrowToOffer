package com.guang.top65寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
