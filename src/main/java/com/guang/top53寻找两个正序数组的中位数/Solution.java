package com.guang.top53寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] helpArray = new int[len1+len2];
        mergeTwoArray(nums1,nums2,helpArray);
//        int left = 0;
//        int right = helpArray.length;
        if (helpArray.length % 2 == 0){
            return (helpArray[helpArray.length / 2] + helpArray[helpArray.length / 2 -1])/2.0;
        }else{
            return (double) helpArray[helpArray.length / 2];
        }
    }

    private void mergeTwoArray(int[] nums1, int[] nums2, int[] helpArray) {
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                helpArray[index++] = nums1[i++];
            }else {
                helpArray[index++] = nums2[j++];
            }
        }
        while (i < nums1.length){
            helpArray[index++] = nums1[i++];
        }
        while (j < nums2.length){
            helpArray[index++] = nums2[j++];
        }
    }
}
