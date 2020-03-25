package com.hehe.BitTree;

import java.util.Stack;

/**二叉树遍历：递归和非递归版本的代码
 *
 */

public class TraversalBinaryTree {

    // Node 结构体
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node (int data){
            this.value = data;
        }
    }
    //=========================前 中 后序的 递归实现================================
    public static void preOrderRecur(Node head) {
        if (head != null) {
            System.out.println(head.value + " ");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }

    }

    public static void inOrderRecur(Node head) {
        if (head != null) {
            inOrderRecur(head.left);
            System.out.println(head.value + " ");
            inOrderRecur(head.right);
        }

    }

    public static void posOrderRecur(Node head) {
        if (head != null) {
            inOrderRecur(head.left);
            inOrderRecur(head.right);
            System.out.println(head.value + " ");
        }

    }


    // =========================前 中 后序的非递归实现================================

    /**
     * 先序
     * ！！！！！！！
     * @param head
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) { // 需要循环  错写成了if
                head = stack.pop();  //使用了head变量
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right); // 先右再左 保证是先序遍历
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序
     * @param head
     */
    public static void inOrderUnRecur(Node head) {
        System.out.println("in-order: ");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();

            while(!stack.isEmpty() || head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序
     * 思想：前序是根左右，后序是左右根，借鉴前序，根节点先暂存起来，左右完毕之后再打印根节点
     *       需要双栈，另一个栈暂存根节点
     *       ！！最后需要反序一下！！  根右左---》左右根
     *
     * @param head
     */
    public static void posOrderUnRecur01(Node head) {
        System.out.println("pos-order: ");
        Stack<Node> s3 = new Stack<Node>();
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
                while (!s2.isEmpty()) {
                      s3.push(s2.pop());
//                    System.out.print(s2.pop().value + " ");
                }
            }
        }
        //逆序输出才是正确答案
        while(!s3.isEmpty()){
            System.out.print(s3.pop().value + " ");
        }
        System.out.println();
    }

    /**
     * can not understand 后序遍历 炫技版
     * @param h
     */
    public static void posOrderUnRecur02(Node h) {
        System.out.println("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive  递归==============");
        System.out.print("pre-order: ");
//		preOrderRecur(head);
        System.out.println();

        System.out.print("in-order: ");
//		inOrderRecur(head);
        System.out.println();

        System.out.print("pos-order: ");
//		posOrderRecur(head);
        System.out.println();

        // un recursive
        System.out.println("============unrecursive=============");
//        preOrderUnRecur(head);

//		inOrderUnRecur(head);
		posOrderUnRecur01(head);
//        1 2 4 3 6 7 9 11 10 8 5

//		posOrderUnRecur02(head);
    }

}

/**
 * 知识点
 */
//add是继承自Vector的方法，且返回值类型是boolean。
//push是Stack自身的方法，返回值类型是参数类类型。
//
//peek()函数返回栈顶的元素，但不弹出该栈顶元素。
//pop()函数返回栈顶的元素，并且将该栈顶元素出栈。

