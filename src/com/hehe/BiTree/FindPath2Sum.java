package com.hehe.BiTree;

import com.sun.source.tree.Tree;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 二叉树中和为某一值的路径
 * <p>
 * 路径：从根节点到叶子结点
 * 路段：路径上某一段
 */
public class FindPath2Sum {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(10);
//        head.left = new TreeNode(5);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(7);
//        head.right = new TreeNode(12);
//        head.right.right = new TreeNode(1);
        TreeNode head01 = new TreeNode(1);
        head01.left = new TreeNode(1);
        head01.right = new TreeNode(2);
        head01.left.left = new TreeNode(1);
        head01.left.right = new TreeNode(1);
//        head.right.left = new TreeNode(1);
//        head.right.right = new TreeNode(1);

        List list = new ArrayList();
        Method(head01, list, 3);
//        findPath(head, 22);  //错误的
        System.out.println("+++++++++++++++++++++++++");

        LinkedList<List<Integer>> res = findPath01(head01, 3);
        System.out.println(res.toString());


        System.out.println("==================");

        ArrayList<ArrayList<Integer>> res01 = FindPath(head01, 3);
        System.out.println(res01.toString());


    }

    /**
     * fei 2022.4.21
     *
     * @param node
     * @param list
     * @param number
     */
    public static void Method(TreeNode node, List<Integer> list, int number) {
        if (null == node)
            return;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            int sum = 0;

            for (int i = 0; i < list.size(); i++) {
                sum = sum + list.get(i);
            }
            if (sum == number) {
                System.out.println(list);
            }
            return;
        }
        Method(node.left, list, number);
        list.remove(list.size() - 1);

        Method(node.right, list, number);
        list.remove(list.size() - 1);

    }


    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static LinkedList<List<Integer>> findPath01(TreeNode head, int target) {
        if (head == null)
            return res;

        path.add(head.val);
        target -= head.val;
        if (target == 0 && head.left == null && head.right == null)
            res.add(new LinkedList<>(path));   //需要new 一个LinkedList结点 将path转型放进去

        findPath01(head.left, target);
        findPath01(head.right, target);
        path.removeLast();   // !
//        list.remove(list.size()-1); //同上
        return res;
    }


    //==========================================hhh==============================================
    private static ArrayList<ArrayList<Integer>> res01 = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return res01;
        list.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null)
            res01.add(new ArrayList<>(list));  // !!!

        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res01;
    }
//=============================================hhh===========================================

}
