package com.hehe.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 *
 * 路径：从根节点到叶子结点
 * 路段：路径上某一段
 */
public class FindPath2Sum {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(5);
        head.left.left = new Node(4);
        head.left.right = new Node(7);
        head.right = new Node(12);
        head.right.right = new Node(1);
//        findPath(head, 22);  //错误的

        LinkedList<List<Integer>> res = findPath01(head, 22);
        System.out.println(res.toString());


        System.out.println("==================");

        ArrayList<ArrayList<Integer>> res01 = FindPath(head,22);
        System.out.println(res01.toString());


    }

    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static LinkedList<List<Integer>> findPath01(Node head, int target) {
        if (head == null) return res;
        path.add(head.value);
        target -= head.value;
        if (target == 0 && head.left == null && head.right == null)
            res.add(new LinkedList<>(path));   //需要new 一个LinkedList结点 将path转型放进去

        findPath01(head.left, target);
        findPath01(head.right, target);
        path.removeLast();   // !
        return res;
    }


//==========================================hhh==============================================
    private static ArrayList<ArrayList<Integer>> res01 = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<ArrayList<Integer>> FindPath(Node root,int target) {
        if(root == null)
            return res01;
        list.add(root.value);
        target -= root.value;
        if(target == 0 && root.left == null && root.right == null)
            res01.add(new ArrayList<>(list));  // !!!
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return res01;
    }
//=============================================hhh===========================================

    // Node 结构体
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
