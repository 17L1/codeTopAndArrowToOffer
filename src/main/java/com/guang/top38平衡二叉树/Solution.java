package com.guang.top38平衡二叉树;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(theDepthofTreeNode(root.left) - theDepthofTreeNode(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int theDepthofTreeNode(TreeNode node) {
        if (node == null){
            return 0;
        }
        return Math.max(theDepthofTreeNode(node.left),theDepthofTreeNode(node.right)) + 1;

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
