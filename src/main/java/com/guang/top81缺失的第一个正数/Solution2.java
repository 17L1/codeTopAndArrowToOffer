package com.guang.top81缺失的第一个正数;


/**
 * @author: 17L1
 * @date: 2021年05月18日 11:21 上午
 * @method：
 */
public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i] ){
                //满足在指定范围内，并且没有放在正确的索引下，才交换
                //例如：数值3应该放在索引2的位置
                swap(nums,i,nums[i] - 1);
            }

        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
