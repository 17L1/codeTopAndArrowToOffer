package com.guang.top17二叉树的锯齿形层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int index = 0;
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (index % 2 == 0){
                    list.add(cur.val);
                }else {
                    list.add(0,cur.val);
                }
                if (cur.left != null){
                    deque.offer(cur.left);
                }
                if (cur.right != null){
                    deque.offer(cur.right);
                }
            }
            index++;
            res.add(list);
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
