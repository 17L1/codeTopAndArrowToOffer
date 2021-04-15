package com.guang.top3lengthOflongestSubString;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 1 || len == 0){
            return len;
        }
        int[] nums = new int[128];
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < len){
            nums[s.charAt(right)]++;
            while (nums[s.charAt(right)] == 2 && left <= right && right < len){
                nums[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res,right - left + 1);
            right++;
        }
        return res;
    }
}
