package com.guang.top2FindKthLargest;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len < 1){
            return 0;
        }
        int n = len - 1;
        for (int i = n / 2; i >= 0 ; i++) {
            sink(nums,i,n);
        }
        for (int i = 0; i < k-1; i++) {
            swap(nums,0,n--);
            sink(nums,0,n);
        }
        return nums[0];
    }

    private void sink(int[] nums, int k, int len) {
        while (2 * k + 1 <= len){
            int j = 2 * k + 1;
            if (j + 1 <= len && nums[j] < nums[j+1]){
                j = j+1;
            }
            if (nums[k] < nums[j]){
                swap(nums,k,j);
            }else {
                break;
            }
            k = j;
        }
    }

    private void swap(int[] nums, int k, int j) {
        int tmp = nums[k];
        nums[k] = nums[j];
        nums[j] = tmp;
    }
}
