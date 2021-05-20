package com.guang.top73路径总和3;

import java.util.*;

/**
 * @author: 17L1
 * @date: 2021年05月15日 4:34 下午
 * @method：回溯
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(root,targetSum,res,path);
        return res;
    }

    private void backTrack(TreeNode root, int targetSum, List<List<Integer>> res, LinkedList<Integer> path) {
        if (root == null){
            return;
        }
        if (targetSum - root.val == 0 && root.left == null && root.right == null){
            path.addLast(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        targetSum -= root.val;
        path.addLast(root.val);
        backTrack(root.left,targetSum,res,path);
        backTrack(root.right,targetSum,res,path);
        path.removeLast();
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
