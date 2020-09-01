package com.hehe.BiTree;

import java.util.*;

/**
 * 二叉树遍历：递归和非递归版本的代码
 */

public class TraversalBinaryTree {

    //=========================层序遍历================================

    /**
     * 层序遍历 用队列
     *
     * @param head
     */
    public static void levelOrder(TreeNode head) {
        Queue<TreeNode> queue = new ArrayDeque<>(); //new LinkedList<>();
//        queue.

        if (head != null)
            queue.add(head);
        while (!queue.isEmpty()) {  //注意栈空的判断 不能用queue != null 判断
            TreeNode peek = queue.poll();
            System.out.print(peek.val + " ");
            if (peek.left != null)
                queue.add(peek.left);
            if (peek.right != null)
                queue.add(peek.right);
        }
    }

    /**
     * 层序遍历 用队列
     * 每一层打印一行（本方法返回数组，每个元素时每一层的结点）
     *
     * @param head
     * @return
     */
    public static List<List<Integer>> levelOrder01(TreeNode head) {
        Queue<TreeNode> queue = new ArrayDeque<>(); //new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (head != null)
            queue.add(head);
        while (!queue.isEmpty()) {  //注意栈空的判断 不能用queue != null 判断
            int size = queue.size();  //当前层的结点数目
            ArrayList<Integer> tmp = new ArrayList<>();  //非双端队列 数组列表即可
            for (int i = 0; i < size; i++) { //遍历一层的结点 并将下一层全部入队列
                TreeNode peek = queue.poll();
                tmp.add(peek.val);
                if (peek.left != null)
                    queue.add(peek.left);
                if (peek.right != null)
                    queue.add(peek.right);
            }
            list.add(tmp);
        }
        return list;
    }

    /**
     * 之字形打印树
     * 与牛客保持一致 返回结果是ArrayList<ArrayList<Integer>> 类型
     *
     * @param head
     * @return hehe
     */
    public static ArrayList<ArrayList<Integer>> levelOrder02(TreeNode head) {
        Queue<TreeNode> queue = new ArrayDeque<>(); //new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head != null)
            queue.add(head);
        int n = 0;  //判断奇偶层标志变量
        while (!queue.isEmpty()) {  //注意栈空的判断 不能用queue != null 判断
            int size = queue.size();  //当前层的结点数目
            LinkedList<Integer> tmp = new LinkedList<>();  //双端队列

            for (int i = 0; i < size; i++) { //遍历一层的结点 并将下一层全部入队列
                TreeNode peek = queue.poll();
                if (n == 0)  //也可以用结果数组的size ：if(res.size % 2 == 0)
                    tmp.addLast(peek.val);
                else
                    tmp.addFirst(peek.val);
                if (peek.left != null)
                    queue.add(peek.left);
                if (peek.right != null)
                    queue.add(peek.right);
            }
            ArrayList<Integer> res_tmp = new ArrayList<>();
            while (tmp.peekFirst() != null) {
                res_tmp.add(tmp.pollFirst());
            }
            res.add(res_tmp);
            n = (n == 0) ? 1 : 0;
        }
        return res;
    }


    /**
     * 之字形打印树
     *
     * @param head
     * @return 网友答案
     */
    public static List<List<Integer>> levelOrder03(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (head != null)
            queue.add(head);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


    //=========================前 中 后序的 递归实现================================
    public static void preOrderRecur(TreeNode head) {
        if (head != null) {
            System.out.println(head.val + " ");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }

    }

    public static void inOrderRecur(TreeNode head) {
        if (head != null) {
            inOrderRecur(head.left);
            System.out.println(head.val + " ");
            inOrderRecur(head.right);
        }

    }

    public static void posOrderRecur(TreeNode head) {
        if (head != null) {
            inOrderRecur(head.left);
            inOrderRecur(head.right);
            System.out.println(head.val + " ");
        }

    }


    // =========================前 中 后序的非递归实现================================

    /**
     * 先序
     * ！！！！！！！
     *
     * @param head
     */
    public static void preOrderUnRecur(TreeNode head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) { // 需要循环  错写成了if

                head = stack.pop();  //使用了head变量
                System.out.print(head.val + " ");

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
     * 套模板非递归前序遍历代码 --Stack
     *
     * @param head
     */
    public static void preOrderUnRecur01(TreeNode head) {
        System.out.print("pre-order01: ");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                System.out.print(head.val + " ");
                stack.push(head); //push
                head = head.left;
            } else {
                head = stack.pop(); //pop
                head = head.right;
            }
        }
        System.out.println();
    }

    /**
     * 套模板非递归前序遍历代码 --ArrayDeque
     *
     * @param head
     */
    public static void preOrderUnRecur02(TreeNode head) {
        System.out.print("pre-order02: ");
        Queue<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                System.out.print(head.val + " ");
                stack.add(head);  //add 队满异常 offer 队满返回false
                head = head.left;
            } else {
                head = stack.poll(); //poll
                head = head.right;
            }
        }
        System.out.println();
    }

    /**
     * 中序
     *
     * @param head
     */
    public static void inOrderUnRecur(TreeNode head) {
        System.out.print("in-order: ");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
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
    public static void posOrderUnRecur01(TreeNode head) {
        System.out.println("posOrderUnRecur01: ");
        Stack<TreeNode> s3 = new Stack<>();
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
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
            System.out.print(s3.pop().val + " ");
        }
        System.out.println();
    }

    /**
     * 后序 双栈
     * 根右左:进栈顺序是根右左（前序是根左右：进栈顺序是根右左） ———> 左右根
     *
     * @param head
     */
    public static void pos_doubleStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {   //还有个 empty() 方法

                head = s1.pop();
                s2.push(head);

                if (head.left != null)
                    s1.push(head.left);
                if (head.right != null)
                    s1.push(head.right);
            }
            System.out.println("pos_doubleStack:");
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
    }


    /**
     * 后序遍历 单栈
     *
     * @param root
     */
    public static void pos_singleStack(TreeNode root) {
        System.out.println("pos_singleStack:");
        TreeNode r = null;
//        List<Integer> ans = new ArrayList();  //可作为返回的集合元素
        Deque<TreeNode> stack = new ArrayDeque();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (root.right == null || root.right == r) { //右节点为空 或者右节点遍历过了 才输出当前的根节点
//                    ans.add(root.val);
                    System.out.print(root.val + " ");
                    r = root;  //用于存储上一个遍历的节点（左右根）
                    stack.pop();
                    root = null;
                } else
                    root = root.right;
            }
        }
    }

    /**
     * can not understand 后序遍历 炫技版
     *
     * @param head
     */
    public static void posOrderUnRecur02(TreeNode head) {
        System.out.println("posOrderUnRecur02: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            TreeNode c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    head = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

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
//        preOrderUnRecur01(head);
//        preOrderUnRecur02(head);
//        inOrderUnRecur(head);

        posOrderUnRecur01(head);
//        1 2 4 3 6 7 9 11 10 8 5
        pos_doubleStack(head);
        System.out.println();
        pos_singleStack(head);
        System.out.println();

        posOrderUnRecur02(head);

        System.out.println("=====================层序遍历================");
//        levelOrder(head);
        List<List<Integer>> list = levelOrder01(head);
        System.out.println(list.toString());
        ArrayList<ArrayList<Integer>> list1 = levelOrder02(head);
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

