package com.guang.top29二叉树的右视图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        res.add(root.val);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left != null){
                    queue.add(node.left);

                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (!queue.isEmpty() && queue.peekLast() != root){
                res.add(queue.peekLast().val);
            }
        }
        return res;
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

