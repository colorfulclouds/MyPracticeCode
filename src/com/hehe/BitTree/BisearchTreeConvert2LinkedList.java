package com.hehe.BitTree;

/**
 * 递归解决 二叉树转换为双向循环链表
 * jz_36题 参考动画比较好理解
 *
 * 中序遍历的变型应用
 * 在递归语句中间写逻辑
 *
 */
public class BisearchTreeConvert2LinkedList {
    private static Node head, pre;

    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(6);
        head.left.left = new Node(4);
        head.left.right = new Node(8);
        head.right = new Node(14);
        head.right.left = new Node(12);
        head.right.right = new Node(16);

        Node head01 = tree2LinkedList(head);
        for (int i = 0; i < 7; ) {
            while (head01 != null && i < 7) {
                System.out.println(head01.val);
                head01 = head01.right;
                i++;
            }
        }


    }




    public static Node tree2LinkedList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    static void dfs(Node cur) {
        if(cur == null) //self
            return;
        dfs(cur.left);

        if(pre == null)
            head = cur;
        else
            pre.right = cur;
        cur.left = pre;
        pre = cur;

        dfs(cur.right);


//        if (cur == null) return; //原
//        dfs(cur.left);
//
//        if (pre != null)
//            pre.right = cur;
//        else
//            head = cur;
//        cur.left = pre;
//        pre = cur;
//
//        dfs(cur.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int _val) {
            this.val = _val;
        }
    }
}
