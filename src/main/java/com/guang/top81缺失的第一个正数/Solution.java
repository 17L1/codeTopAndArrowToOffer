package com.guang.top81缺失的第一个正数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: 17L1
 * @date: 2021年05月18日 11:10 上午
 * @method：
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        int res = 1;
        while (true){
            if (!set.contains(res)){
                break;
            }
            res++;
        }
        return res;
    }
}
