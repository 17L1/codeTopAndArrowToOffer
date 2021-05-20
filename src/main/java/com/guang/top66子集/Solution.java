package com.guang.top66子集;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 1){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res,path,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, int begin) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(res,path,nums,i+1);
            path.removeLast();
        }
    }
}
