package com.hehe.BitTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //前序的序列化
    public static String serializeByPre01(Node head) {
        if (head == null) {
            return "#!";
        } else {
            String str = head.value + "!";
            str += serializeByPre01(head.left);
            str += serializeByPre01(head.right);
            return str;
        }

    }

    /**
     * (X) 无法用栈实现二叉树的序列化
     */
    public static String serializeByPre02(Node head) {
        String str = "";
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                str += head.value+"!";
                if(head.left==null && head.right==null)
                    str+="#!#!";
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }else
                    str+="#!";
            }
        }else{
            return "#!";
        }
        return str;

    }

    //前序的反序列  队列
    public static Node reconstructByPreString(String str) {
        if(str == null) {
            return null;
        }
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconstructTree(queue);

    }


    public static Node reconstructTree(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("#"))
            return null;
        Node head =new Node(Integer.valueOf(value));
        head.left = reconstructTree(queue);  //一直传参为queue
        head.right = reconstructTree(queue);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);

        //前序序列化
        String str = serializeByPre01(head);
        System.out.println(str);
        //反序列化成树
        Node head2 = reconstructByPreString(str);
        //检验反序列化是否和之前一致
        String str1 = serializeByPre01(head2);
        System.out.println(str1);
    }
}

/**
 * offer 方法可插入一个元素，否则返回 false 在队列为空时：remove() 方法抛出一个异常，而 poll() 方法则返回 null。
 * element() 和 peek() 返回，但不移除，队列的头。
 */
