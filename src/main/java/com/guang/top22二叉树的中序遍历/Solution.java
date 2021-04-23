package com.guang.top22二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        dfs(root,list);
        return list;

    }
    private void dfs(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
