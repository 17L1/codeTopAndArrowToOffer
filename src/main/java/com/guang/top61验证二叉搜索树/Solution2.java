package com.guang.top61验证二叉搜索树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
