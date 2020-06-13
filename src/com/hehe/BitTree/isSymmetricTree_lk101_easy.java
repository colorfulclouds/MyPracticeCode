package com.hehe.BitTree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class isSymmetricTree_lk101_easy {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetricTree(root));
    }

    public static boolean isSymmetricTree(TreeNode root) {
        if(root==null)
            return true;
        return Helper(root.left, root.right);
    }

    private static boolean Helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)  //均空   //！
            return true;
        if (left == null || right == null)  //一个为空
            return false;

        //镜像的判断（互为镜像的两个结点继续判断： A结点 的左子结点 和 B结点的右子结点
        //                                    A结点 的右子结点 和 B结点的左子结点）
        return left.val == right.val && Helper(left.left, right.right) && Helper(left.right, right.left);

//        if(left.val == right.val)
//            return Helper(left.left,right.right)
//                    && Helper(left.right,right.left);
//        else
//            return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
