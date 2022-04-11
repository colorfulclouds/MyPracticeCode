package com.hehe.BiTree;

//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
//辅助单调栈解法？？？
//二叉查找树 :在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。

public class IsBinarySearchTreeSeq {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(verifyPostorder(new int[]{7, 4, 6, 5}));
    }


    /**
     * 判断 给定序列 是否是 二叉搜索树的后序遍历序列
     * <p>
     *
     * @param order
     * @return
     */
    public static boolean verifyPostorder(int[] order) {
        if (order != null && order.length > 0)
            return recur(order, 0, order.length - 1);
        else
            return false;
//        return recur(order, 0, order.length - 1);
    }

    static boolean recur(int[] order, int i, int j) {
        if (i >= j)
            return true;
        int p = i;
        while (order[p] < order[j])
            p++;
        int m = p;
        while (order[p] > order[j])
            p++;
        return p == j
                && recur(order, i, m - 1)
                && recur(order, m, j - 1);
    }

}
