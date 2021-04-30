package com.guang.top39二叉树中的最大路径和;

public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;

    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0,dfs(root.right));
        max = Math.max(max,root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax,rightMax);
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
