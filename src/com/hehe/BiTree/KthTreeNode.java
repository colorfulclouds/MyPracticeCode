package com.hehe.BiTree;

import java.util.Stack;

/**
 * 中序遍历的应用：二叉搜索树的第K大节点(从小到大 或者 从大到小)
 */


public class KthTreeNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

//        System.out.println(KthNodeCore(root, 3).value);  // X

        System.out.println(Kth01(root, 3)); //从小到大数
        System.out.println(Kth02(root, 3)); //从大到小数

    }


    /**
     * 中序遍历的第 k个数字是:
     * @param head
     * @param k
     * @return
     */
    public static int Kth01(TreeNode head, int k) {
        int res = 0;
        System.out.println("中序遍历的第 " + k + " 个数字是: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();

            /**
             *测试代码21
             */
//            if(stack == null)  //false
//                System.out.println();
//            if(stack.isEmpty())  //true
//                System.out.println();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
//                    System.out.print(head.value + " ");
                    if (k == 1)
                        res = head.val;
                    k--;
                    head = head.right;
                }
            }
        }
//        System.out.println();
        return res;
    }

    /**
     * 中序遍历的第k大的数字 (中序遍历的逆应用)
     * @param head
     * @param k
     * @return
     */
    public static int Kth02(TreeNode head, int k) {
        int res = 0;
        System.out.println("中序遍历的第 " + k + " 大的数字是: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.right;
                } else {
                    head = stack.pop();
//                    System.out.print(head.value + " ");
                    if (k == 1)
                        res = head.val;
                    k--;
                    head = head.left;
                }
            }
        }
//        System.out.println();
        return res;
    }


    public static TreeNode KthNodeCore(TreeNode root, int k) {
        TreeNode target = null;

        if (root.left != null)
            target = KthNodeCore(root.left, k);
        if (target == null) {
            if (k == 1)
                target = root;
            k--;
        }

        if (target == null && root.right != null) {
            target = KthNodeCore(root.right, k);
        }
        return target;
    }
}


