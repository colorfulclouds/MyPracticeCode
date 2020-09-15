package com.hehe.BiTree;

import java.util.Stack;

/**
 * 递归解决 二叉树转换为双向循环链表
 * jz_36题 参考动画比较好理解
 *
 * 中序遍历的变型应用
 * 在递归语句中间写逻辑
 *
 */
public class BisearchTreeConvert2LinkedList {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(6);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(8);
        head.right = new TreeNode(14);
        head.right.left = new TreeNode(12);
        head.right.right = new TreeNode(16);

        TreeNode head01 = tree2LinkedList(head);
        for (int i = 0; i < 7; ) {
            while (head01 != null && i < 7) {
                System.out.println(head01.val);
                head01 = head01.right;
                i++;
            }
        }


    }


    /**
     * 二叉树转换为双向循环链表 （递归)
     */
    private static TreeNode head, pre;
    public static TreeNode tree2LinkedList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    static void dfs(TreeNode cur) {
        if(cur == null) //self
            return;
        dfs(cur.left);

        if(pre == null)  //找到头结点
            head = cur;
        else
            pre.right = cur;
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }


    /**
     * 二叉树转换为双向循环链表 （非递归)
     * @param head
     * @return
     */
    public static TreeNode Convert(TreeNode head) {
        if (head == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = head;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre == null)
                // 将中序遍历序列中的第一个节点记为root
                head = cur;
            else
                pre.right = cur;

            cur.left = pre;
            pre = cur;
            cur = cur.right;
        }
        return head;
    }
}
