package com.guang.top62二叉树的遍历.前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.right != null){
                stack.push(curNode.right);
            }
            if (curNode.left != null){
                stack.push(curNode.left);
            }

        }
        return res;
    }
}
