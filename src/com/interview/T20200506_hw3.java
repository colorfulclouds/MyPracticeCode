package com.interview;

import com.hehe.BiTree.TreeNode;
/**
 * 动态规划求 树的 子路段的 最大和
 * 题目中是1（2,3（4,5））的给定树的形式，需要重建树才能用本方法
 */
public class T20200506_hw3 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(-1);
        node.right.right.right = new TreeNode(3); //4


//        node.left = new TreeNode(3);
//        node.left.left = new TreeNode(-2 );
//        node.left.right = new TreeNode(2);
//        node.right = new TreeNode(2);
//        node.right.right = new TreeNode(-1);
//        node.right.right.right = new TreeNode(3);
//        node.right.right.left = new TreeNode(5); //6

//        node.left = new TreeNode(4);
//        node.right = new TreeNode(2);
//        node.right.left = new TreeNode(1);
//        node.right.left.left = new TreeNode(7);
//        node.right.right = new TreeNode(-1);
//        node.right.right.right = new TreeNode(2);
//        node.right.right.left = new TreeNode(3); //10

        System.out.println(findPathSegment(node));


    }

    /**
     * 最大路段和
     *  即从根节点到叶子节点上任意一段（包括单节点），最大的和
     * @param head
     * @return
     */
    public static int findPathSegment(TreeNode head) {
        int cur_max = 0, res_max = 0;
        int max = recur(head, cur_max, res_max);
        return max;
    }

    static int recur(TreeNode head, int cur_max, int res_max) {
        if (head == null)
            return Math.max(cur_max,res_max);

        cur_max = Math.max(cur_max + head.val, head.val);
        res_max = Math.max(cur_max, res_max);

        return Math.max(recur(head.left,cur_max,res_max), recur(head.right,cur_max,res_max));
    }

}
