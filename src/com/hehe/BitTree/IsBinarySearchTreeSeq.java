package com.hehe.BitTree;

public class IsBinarySearchTreeSeq {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{5,7,6,9,11,10,8}));
        System.out.println(verifyPostorder(new int[]{7,4,6,5}));
    }

    /**
     * len做参数不对 （剑指offer 181页）疑问！！！
     * @param order
     * @param len
     * @return
     */
//    public static boolean verifySequence(int[] order,int len){
//        if(order == null || len<=0)
//            return false;
//        int root = order[len-1];
//        int i = 0;
//        while(order[i] < root) i++;
//        int m = i;
//        while (order[i] > root) i++;
//        return i == len && verifySequence(order,m-1) && verifySequence(order,len);
//
//    }

    /**
     * 判断 给定序列 是否是 二叉搜索树的后序遍历序列
     *
     * @param order
     * @return
     */
    public static boolean verifyPostorder(int[] order) {
        return recur(order, 0, order.length - 1);
    }

    static boolean recur(int[] order, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (order[p] < order[j]) p++;
        int m = p;
        while (order[p] > order[j]) p++;
        return p == j && recur(order, i, m - 1)
                && recur(order, m, j - 1);
    }

}
