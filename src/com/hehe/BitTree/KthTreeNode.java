package com.hehe.BitTree;

import java.util.Stack;

/**
 * 中序遍历的应用：二叉搜索树的第K大节点(从小到大 或者 从大到小)
 */
class Node01 {
    int value;
    Node01 left;
    Node01 right;

    Node01(int data) {
        this.value = data;
    }
}

public class KthTreeNode {
    public static void main(String[] args) {
        Node01 root = new Node01(5);
        root.left = new Node01(3);
        root.left.left = new Node01(2);
        root.left.right = new Node01(4);
        root.right = new Node01(7);
        root.right.left = new Node01(6);
        root.right.right = new Node01(8);

//        System.out.println(KthNodeCore(root, 3).value);  // X

        System.out.println(Kth01(root, 3)); //从小到大数
        System.out.println(Kth02(root, 3)); //从大到小数



//        System.out.println();

    }


    public static int Kth01(Node01 head, int k) {
        int res = 0;
        System.out.println("中序遍历的第 " + k + " 个数字是: ");
        if (head != null) {
            Stack<Node01> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
//                    System.out.print(head.value + " ");
                    if (k == 1)
                        res = head.value;
                    k--;
                    head = head.right;
                }
            }
        }
//        System.out.println();
        return res;
    }

    public static int Kth02(Node01 head, int k) {
        int res = 0;
        System.out.println("中序遍历的第 " + k + " 大的数字是: ");
        if (head != null) {
            Stack<Node01> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.right;
                } else {
                    head = stack.pop();
//                    System.out.print(head.value + " ");
                    if (k == 1)
                        res = head.value;
                    k--;
                    head = head.left;
                }
            }
        }
//        System.out.println();
        return res;
    }


    /**
     *what's this????
     */
    int res, k = 3;

    public int Kth(Node01 root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(Node01 root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.value;
        dfs(root.left);
    }

    /**
     *what's this????
     */

    /**
     * 错误的!!!!
     *
     * @param root
     * @param k
     * @return
     */
    public static Node01 KthNode(Node01 root, int k) {

//        if(root == null || k == 0){
//            return null;
//        }
        return KthNodeCore(root, k);
    }

    public static Node01 KthNodeCore(Node01 root, int k) {
        Node01 target = null;

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


