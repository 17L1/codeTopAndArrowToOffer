package com.guang.top62二叉树的遍历.中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        DFS(root,res);
        return res;
    }

    private void DFS(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        DFS(root.left,res);
        res.add(root.val);
        DFS(root.right,res);
    }
}
