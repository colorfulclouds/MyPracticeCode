package com.hehe.BitTree;

public class min_depth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
     *
     * 若只有根结点和右结点，则最小深度是根结点到最近的叶子结点 ：右结点的 最短路径上结点的数量
     * @param root
     * @return
     */
    public static int min_depth(TreeNode root) {
        if (root == null) {  //无根
            return 0;
        } else if (root.left == null && root.right == null) {   //单根
            return 1;
        } else if (root.left == null) {   //左空 右不空
            return min_depth(root.right) + 1;
        } else if (root.right == null) {  //右空 左不空
            return min_depth(root.left) + 1;
        }
        return Math.min(min_depth(root.left), min_depth(root.right))+1;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(3);
        head.left.right.left = new TreeNode(5);
        head.left.right.right = new TreeNode(4);

        int res = min_depth(head);
        System.out.println(res);

    }


}


/*
 * 快捷键：
 * psv  主函数
 *
 * */