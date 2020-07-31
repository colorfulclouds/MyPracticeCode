package com.hehe.BiTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndReconstructTree {



    //前序的序列化
    public static String serializeByPre01(TreeNode head) {
        if (head == null) {
            return "#!";
        } else {
            String str = head.val + "!";
            str += serializeByPre01(head.left);
            str += serializeByPre01(head.right);
            return str;
        }

    }

    /**
     * 用栈实现二叉树的序列化(怎么有点麻烦呢？？)
     */
    public static String serializeByPre02(TreeNode head) {
        String str = "";
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                if (head.val == -1) {
                    str += "#" + "!";
                    continue;
                } else
                    str += head.val + "!";
                if (head.val != -1 && head.left == null && head.right == null) {
                    str += "#!#!";
                    continue;
                }
                if (head.right != null) {
                    stack.push(head.right);
                } else
                    stack.push(new TreeNode(-1));
                if (head.left != null)
                    stack.push(head.left);
                else
                    stack.push(new TreeNode(-1));
            }
        } else {
            return "#!";
        }
        return str;

    }


    /**
     * 前序的反序列化 队列
     * queue的增加元素方法add和offer的区别在于，add方法在队列满的情况下将选择抛异常的方法来表示队列已经满了，而offer方法通过返回false表示队列已经满了；
     * 在有限队列的情况，使用offer方法优于add方法
     * @param str
     * @return
     */
    public static TreeNode reconstructByPreString(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconstructTree(queue);

    }


    public static TreeNode reconstructTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconstructTree(queue);  //一直传参为queue
        head.right = reconstructTree(queue);
        return head;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);

        //前序序列化
        System.out.println("==============前序序列化===============");
        String str = serializeByPre01(head);
        System.out.println(str);

        String strx = serializeByPre02(head);
        System.out.println(strx);
        String stry = serializeByPre02(null);
        System.out.println(stry);
        System.out.println("=============================");


        //反序列化成树
        System.out.println("=============反序列化成树================");
        TreeNode head2 = reconstructByPreString(str);
        //检验反序列化是否和之前一致
        String str1 = serializeByPre01(head2);
        System.out.println(str1);
    }
}

/**
 * offer 方法可插入一个元素，否则返回 false 在队列为空时：remove() 方法抛出一个异常，而 poll() 方法则返回 null。
 * element() 和 peek() 返回，但不移除，队列的头。
 */
