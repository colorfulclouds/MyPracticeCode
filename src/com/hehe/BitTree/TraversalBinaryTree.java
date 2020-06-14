package com.hehe.BitTree;

import javax.jnlp.IntegrationService;
import java.util.*;

/**
 * 二叉树遍历：递归和非递归版本的代码
 */

public class TraversalBinaryTree {

    // Node 结构体
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //=========================层序遍历================================

    /**
     * 层序遍历 用队列
     * @param head
     */
    public static void levelOrder(Node head) {
        Queue<Node> queue = new ArrayDeque<>(); //new LinkedList<>();
//        queue.

        if (head != null)
            queue.add(head);
        while (!queue.isEmpty()) {  //注意栈空的判断 不能用queue != null 判断
            Node peek = queue.poll();
            System.out.print(peek.value + " ");
            if(peek.left!=null)
                queue.add(peek.left);
            if(peek.right!=null)
                queue.add(peek.right);
        }
    }

    /**
     * 层序遍历 用队列
     * 每一层打印一行（本方法返回数组，每个元素时每一层的结点）
     * @param head
     * @return
     */
    public static List<List<Integer>> levelOrder01(Node head) {
        Queue<Node> queue = new ArrayDeque<>(); //new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (head != null)
            queue.add(head);
        while (!queue.isEmpty()) {  //注意栈空的判断 不能用queue != null 判断
            int size = queue.size();  //当前层的结点数目
            ArrayList<Integer> tmp = new ArrayList<>();  //非双端队列 数组列表即可
            for (int i = 0; i < size; i++) { //遍历一层的结点 并将下一层全部入队列
                Node peek = queue.poll();
                tmp.add(peek.value);
                if(peek.left!=null)
                    queue.add(peek.left);
                if(peek.right!=null)
                    queue.add(peek.right);
            }
            list.add(tmp);
        }
        return list;
    }

    /**
     * 之字形打印树
     * @param head
     * @return
     *
     * hehe
     */
    public static List<List<Integer>> levelOrder02(Node head) {
        Queue<Node> queue = new ArrayDeque<>(); //new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (head != null)
            queue.add(head);
        int n = 0;  //判断奇偶层标志变量
        while (!queue.isEmpty()) {  //注意栈空的判断 不能用queue != null 判断
            int size = queue.size();  //当前层的结点数目
            LinkedList<Integer> tmp = new LinkedList<>();  //双端队列

            for (int i = 0; i < size; i++) { //遍历一层的结点 并将下一层全部入队列
                Node peek = queue.poll();
                if(n==0)  //也可以用结果数组的size ：if(res.size % 2 == 0)
                    tmp.addLast(peek.value);
                else
                    tmp.addFirst(peek.value);
                if(peek.left!=null)
                    queue.add(peek.left);
                if(peek.right!=null)
                    queue.add(peek.right);
            }
            res.add(tmp);
            n = (n == 0)? 1:0;

        }
        return res;
    }


    /**
     * 之字形打印树
     * @param head
     * @return
     *
     *网友答案
     */
    public static List<List<Integer>> levelOrder03(Node head) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(head != null)
            queue.add(head);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                Node node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.value); // 偶数层 -> 队列头部
                else tmp.addFirst(node.value); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
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
     *
     * @param head
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
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
     *
     * @param head
     */
    public static void inOrderUnRecur(Node head) {
        System.out.println("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序
     * 思想：前序是根左右，后序是左右根，借鉴前序，根节点先暂存起来，左右完毕之后再打印根节点
     * 需要双栈，另一个栈暂存根节点
     * ！！最后需要反序一下！！  根右左---》左右根
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
        while (!s3.isEmpty()) {
            System.out.print(s3.pop().value + " ");
        }
        System.out.println();
    }

    /**
     * can not understand 后序遍历 炫技版
     *
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

        System.out.println("=====================层序遍历================");
//        levelOrder(head);
        List<List<Integer>> list = levelOrder01(head);
        System.out.println(list.toString());
        List<List<Integer>> list1 = levelOrder02(head);
        System.out.println(list1.toString());
        List<List<Integer>> list2 = levelOrder03(head);
        System.out.println(list2.toString());
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

