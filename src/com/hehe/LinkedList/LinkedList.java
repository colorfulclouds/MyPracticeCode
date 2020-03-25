package com.hehe.LinkedList;

class LinkedList {
    public int size;// 链表节点的个数
    public  ListNode head;// 头节点

    public LinkedList() {
        size = 0;
        head = null;
    }

    // 链表的每个节点类
    public static class ListNode {
        public int data;// 每个节点的数据
        public ListNode next;// 每个节点指向下一个节点的连接

        public ListNode(int data) {
            this.data = data;
        }
    }
}
