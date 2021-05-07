package com.guang.top50多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            if (map.get(nums[i]) > nums.length / 2){
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
