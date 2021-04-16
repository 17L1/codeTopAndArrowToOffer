package com.guang.top7QuickSort;

public class QuickSort {
    public int[] quickSort(int[] nums){
        int len = nums.length;
        if (len < 2){
            return nums;
        }
        sortArray(nums,0,len-1);
        return nums;
    }

    private void sortArray(int[] nums,int left, int right) {
        if (left < right){
            int patrition = getPatrition(nums,left,right);
            sortArray(nums,left,patrition - 1);
            sortArray(nums,patrition + 1, right);
        }
    }

    private int getPatrition(int[] nums, int left, int right) {
        int start = left;
        while (left < right){
            while (left < right && nums[right] >= nums[start]){
                right--;
            }
            while (left < right && nums[left] <= nums[start]){
                left++;
            }
            if (nums[left] <= nums[right]){
                break;
            }
            swap(nums,left,right);
        }
        swap(nums,left,start);
        return left;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
