package com.guang.top55下一个排列;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int n = nums.length;
        int k = n-1;
        while (k-1 >= 0 && nums[k-1] >= nums[k]) {
            k--;
        }
        if (k==0){
            reverse(nums,k,n-1);
        }else {
            int u = k;
            while (u+1<n && nums[u+1] > nums[k-1]){
                u++;
            }
            swap(nums,k-1,u);
            reverse(nums,k,n-1);
        }
    }

    private void swap(int[] nums, int i, int u) {
        int tmp = nums[i];
        nums[i] = nums[u];
        nums[u] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
