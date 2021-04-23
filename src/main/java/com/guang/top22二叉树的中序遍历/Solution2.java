package com.guang.top22二叉树的中序遍历;

import java.util.*;

public class Solution2 {
    class colorNode{
        int color;
        TreeNode node;

        public colorNode(int color, TreeNode node) {
            this.color = color;
            this.node = node;
        }

        public int getColor() {
            return color;
        }

        public TreeNode getNode() {
            return node;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<colorNode> stack = new Stack<>();
        stack.push(new colorNode(0,root));
        while (!stack.isEmpty()){
            colorNode c = stack.pop();
            int color = c.getColor();
            TreeNode node = c.getNode();
            if (node == null){
                continue;
            }
            if (color == 0){
                stack.push(new colorNode(0,node.right));
                stack.push(new colorNode(1,node));
                stack.push(new colorNode(0,node.left));
            }else {
                res.add(node.val);
            }
        }
        return res;
    }
}
