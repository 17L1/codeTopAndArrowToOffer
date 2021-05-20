package com.guang.top56对称二叉树;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSameTree(reverseTree(root.left),root.right);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null){
            return true;
        }else if (node1 == null && node2 != null || node1 != null && node2 == null) {
            return false;
        }else {
            return node1.val == node2.val && isSameTree(node1.left,node2.left) && isSameTree(node1.right,node2.right);
        }
    }

    private TreeNode reverseTree(TreeNode root) {
        TreeNode temp = null;
        if (root == null || root.left == null && root.left == null){
            return root;
        }else if (root.left != null && root.right != null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }else if (root.left != null){
            root.right = root.left;
            root.left = null;
        }else{
            root.left = root.right;
            root.right = null;
        }
        reverseTree(root.left);
        reverseTree(root.right);
        return root;
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
