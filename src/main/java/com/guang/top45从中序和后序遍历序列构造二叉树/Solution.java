package com.guang.top45从中序和后序遍历序列构造二叉树;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd){
            return null;
        }
        int index = 0;
        int rootVal = postorder[postEnd];
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder,inStart,inStart + leftSize - 1,postorder,postStart,postStart+leftSize-1);
        root.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
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
