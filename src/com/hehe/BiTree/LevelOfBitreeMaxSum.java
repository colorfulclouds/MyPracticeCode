package com.hehe.BiTree;

import java.util.ArrayList;
import java.util.List;

public class LevelOfBitreeMaxSum {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.left.left.right = new TreeNode(1);
        List<List<Integer>> list = levelOrder(head);
        int sum = 0;
        int max = 0;
        for (List<Integer> li : list) {
            for (int i : li) {
                sum += i;
            }
            max = Math.max(sum, max);
            sum = 0;
        }
        System.out.println("max: " + max);
        System.out.println(list.size());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        dfs(1, root, list);
        return list;
    }

    private static void dfs(int index, TreeNode root, List<List<Integer>> list) {
        //到新的一层，需要新建list
        if (index > list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(index - 1).add(root.val);
        if (root.left != null) {
            dfs(index + 1, root.left, list);
        }

        if (root.right != null) {
            dfs(index + 1, root.right, list);
        }

    }
}
