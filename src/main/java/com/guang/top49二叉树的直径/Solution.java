package com.guang.top49二叉树的直径;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res =  Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(res,lengthOfBinaryTree(root.left) + lengthOfBinaryTree(root.right));
    }

    private int lengthOfBinaryTree(TreeNode node) {
        if (node == null){
            return 0;
        }
        return Math.max(lengthOfBinaryTree(node.left),lengthOfBinaryTree(node.right)) + 1;
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
