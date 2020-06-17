package com.hehe.BitTree;

/**
 * 动态规划求 树的 子路段的 最大和
 */
public class MaxPathSegmentValue_dtgh_hw {
    public static void main(String[] args) {
        Node node = new Node(-1);
//        node.left = new Node(3);
//        node.right = new Node(2);
//        node.right.left = new Node(0);
//        node.right.right = new Node(-1); //3
        node.left = new Node(3);
        node.right = new Node(2);
        node.right.right = new Node(-1);
        node.right.right.right = new Node(3);  //4

        System.out.println(findPathSegment(node));


    }

    /**
     * 最大路段和
     *  即从根节点到叶子节点上任意一段（包括单节点），最大的和
     * @param head
     * @return
     */
    public static int findPathSegment(Node head) {
        int cur_max = 0, res_max = 0;
        int max = recur(head, cur_max, res_max);
        return max;
    }

    static int recur(Node head, int cur_max, int res_max) {
        if (head == null) return 0;
        cur_max = Math.max(cur_max + head.value, head.value);
        res_max = Math.max(cur_max, res_max);

        if (head.left == null && head.right == null)
            return Math.max(cur_max,res_max);
        else{
            return Math.max(recur(head.left,cur_max,res_max), recur(head.right,cur_max,res_max));
        }
    }


    // Node 结构体
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
