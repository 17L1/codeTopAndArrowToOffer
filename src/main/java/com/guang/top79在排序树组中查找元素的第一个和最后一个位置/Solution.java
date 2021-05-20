package com.guang.top79在排序树组中查找元素的第一个和最后一个位置;

/**
 * @author: 17L1
 * @date: 2021年05月18日 10:37 上午
 * @method：
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res= {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }

        if (nums[left] != target){
            return res;
        }
        res[0] = left;
        right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        res[1] = right;
        return res;
    }
}
