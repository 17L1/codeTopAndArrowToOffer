package com.guang.top78求根节点到叶节点数字之和;

/**
 * @author: 17L1
 * @date: 2021年05月18日 10:18 上午
 * @method：
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        int sum = 0;
        return help(root, sum);
    }

    private int help(TreeNode node, int sum) {
        if (node == null){
            return sum;
        }
        //return help(node.left,sum * 10 + node.val) + help(node.right,sum * 10 + node.val);
        if (node.left != null && node.right != null){
            return help(node.left,sum * 10 + node.val) + help(node.right,sum * 10 + node.val);
        }else if ((node.left != null)){
            return help(node.left,sum * 10 + node.val);
        }else if (node.right != null){
            return help(node.right,sum * 10 + node.val);
        }
        return sum * 10 + node.val;
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
