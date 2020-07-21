package com.hehe.BitTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class DepthOfTree {

    public static int max_depth(TreeNode root) {
        if (root == null)
            return 0;
        int depth_left = max_depth(root.left);
        int depth_right = max_depth(root.right);
        return depth_left > depth_right ? depth_left + 1 : depth_right + 1;
    }


    /**
     * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
     * <p>
     * 若只有根结点和右结点，则最小深度是根结点到最近的叶子结点 ：右结点的 最短路径上结点的数量
     *
     * @param root
     * @return
     */
    public static int min_depth(TreeNode root) {
        if (root == null) {  //无根
            return 0;
        }
        int depth_left = min_depth(root.left);
        int depth_right = min_depth(root.right);

//        else if (root.left == null && root.right == null) {   //单根
//            return 1;
//        } else if (root.left == null) {   //左空 右不空
//            return min_depth(root.right) ;
//        } else if (root.right == null) {  //右空 左不空
//            return min_depth(root.left);
//        }
//        return Math.min(min_depth(root.left), min_depth(root.right)) + 1;

        return Math.min(depth_left, depth_right) + 1;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(3);
        head.left.right.left = new TreeNode(5);
        head.left.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println("min_depth1: " + min_depth(head));
        System.out.println("min_depth2: " + min_depth(root));

        System.out.println("max_depth2： " + max_depth(head));
        System.out.println("max_depth1： " + max_depth(root));


    }


}


/*
 * 快捷键：
 * psv  主函数
 *
 * */