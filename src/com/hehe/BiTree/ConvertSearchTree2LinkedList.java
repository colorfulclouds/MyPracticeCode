package com.hehe.BiTree;


import java.util.Stack;

/**
 * 二叉搜索树转化为双向链表
 */
public class ConvertSearchTree2LinkedList {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(8);
        node.right = new TreeNode(14);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(16);


    }

    public static TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }


}
