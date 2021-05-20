package com.guang.top62二叉树的遍历.前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @method：递归
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        dfs(root.left,res);
        dfs(root.right,res);
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
