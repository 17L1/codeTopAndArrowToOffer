package com.guang.top72排序数组.堆排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: 17L1
 * @date: 2021年05月14日 6:47 下午
 * @method：堆排序
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return nums;
        }
        for (int i = (len-1) / 2; i >=0 ; i--) {
            sink(nums,i,len);
        }
        for (int i = len - 1; i >= 0 ; i--) {
            swap(nums,0,i--);
            sink(nums,0,i);
        }
        return nums;
    }

    private void sink(int[] nums, int k, int len) {
        while (2 * k + 1 < len){
            int j = 2 * k + 1;
            if (j + 1 < len && nums[j] < nums[j+1]){
                j = j+1;
            }
            if (nums[j] <= nums[k]){
                break;
            }
            swap(nums,k,j);
            k = j;
        }
    }

    private void swap(int[] nums, int k, int j) {
        int tmp = nums[k];
        nums[k] = nums[j];
        nums[j] = tmp;
    }
}
