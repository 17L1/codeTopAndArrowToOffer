package com.guang.top67子集2;

import java.util.*;

/**
 * @author: 17L1
 * @date: 2021年05月12日 12:22 下午
 * @method：
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 1){
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res,path,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, int begin) {
        res.add(new ArrayList<>(path));
        for (int j = begin; j < nums.length; j++) {
            if (j > begin && nums[j-1] == nums[j]){
                continue;
            }
            path.addLast(nums[j]);
            dfs(res,path,nums,j+1);
            path.removeLast();

        }
    }
}
