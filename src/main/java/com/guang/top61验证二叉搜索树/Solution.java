package com.guang.top61验证二叉搜索树;

/**
 * @Method:递归
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return help(root,null,null);
    }

    private boolean help(TreeNode root, Integer lower, Integer upper) {
        if (root == null){
            return true;
        }
        if (lower != null && root.val <= lower){
            return false;
        }
        if (upper != null && root.val >= upper){
            return false;
        }
        if (!help(root.left,lower,root.val)){
            return false;
        }
        if (!help(root.right,root.val,upper)){
            return false;
        }
        return true;
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
