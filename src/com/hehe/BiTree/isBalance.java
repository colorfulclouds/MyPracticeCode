package com.hehe.BiTree;

public class isBalance {
    public static void main(String[] args) {
        Node root = new Node(3);
        System.out.println(IsBalance(root));

        root.left = new Node(3);
//        root.right = new Node(4);  //注释便不平衡的树
        root.left.left = new Node(4);
        System.out.println(IsBalance(root));

    }

    /**
     * 后序递归判断是否是平衡二叉树
     * @param root
     * @return
     */
    public static boolean IsBalance(Node root){
        return recur(root) != -1;
    }

    /**
     * 后序递归判断是否是平衡二叉树
     * 是返回二叉树的最大深度，否返回 -1
     * @param root
     * @return
     */
    public static int recur(Node root){
        if(root == null)
            return 0;

        int left = recur(root.left);
        if(left == -1)
            return -1;

        int right = recur(root.right);
        if(right == -1)
            return -1;

        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;

    }




//     Node 结构体
    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int data) {
            this.value = data;
        }
    }


}
