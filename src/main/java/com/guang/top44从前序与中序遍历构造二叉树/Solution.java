package com.guang.top44从前序与中序遍历构造二叉树;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;//root节点在中序遍历中的索引
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,preStart+1,preStart + leftSize,inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
