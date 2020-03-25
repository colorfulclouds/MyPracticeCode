package com.hehe.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 非重点
 */
public class SolutionForInsertNode {

    public static void main(String[] args) {
        /*解决循环输入的方法
         * 输入的是不定长的字符串，一次接受，存入数组，在再一个个处理
         * */
        //========================接收字符串 生成链表=============================
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            array.add(Integer.valueOf(s1[i]));
        }
        Node head = new Node();
        Node p = head;   //工作指针
        //链表生成
        for (int i = 0; i < array.size(); i++) {
            Node node = new Node();
            node.value = array.get(i);
            node.next = null;
            p.next = node;   //头结点不存东西  从p.next开始
            p = node;
        }
        //========================接收字符串 生成链表=============================

        Node node = new Node();
        node.setValue(3);
        SolutionForInsertNode.insertNode(node,head);
        printList(head.next);
    }
    //0
    //0 1 2
    //0 0 1 2

    //9
    //1 2 3
    //1 2 3 9

    //3
    //1 2 3 5
    //1 2 3 3 5

    Node myHead;   // 为什么存在

    /**
     * 按顺序插入结点
     * @param head
     * @return
     */
    public Node insertionSortList(Node head) {
        Node cursor = head;
        myHead = head;
        while (cursor != null) {
            Node temp = cursor.next;
            if (temp != null && temp.value < cursor.value) { // 如果该结点的后一个结点比该节点小
                cutLink(cursor);          // 将cursor的后一个结点tmp从链表中取出  one(cursor) two(tmp) three
                insertNode(temp, head);   // 将后一个结点插入到适合的位置
            } else {
                cursor = cursor.next;
            }
        }
        return myHead;
    }

    /**
     * 将结点摘出来
     * @param one
     */
    public void cutLink(Node one) {
        Node two = one.next;
        Node three = two.next;
        one.next = three;
        two.next = null;
    }

    /**
     *将结点插入有序的链表中
     * 带头结点的链表，头结点不存数据
     * @param node
     * @param head
     */
    public static void insertNode(Node node, Node head) {
        Node temp = head.next;
        Node pre = head;
        // 小于头结点 的处理
        if(node.value < temp.value){
            node.next = temp;
            pre.next = node;
        }
        while((node.value > temp.value) && temp.next != null){  //跳出循环时，大小顺序是：pre node temp 或者temp.next为空
            pre = temp;
            temp = temp.next;
        }
        if(temp.next == null && node.value > temp.value){   //插入尾部
            node.next = temp.next;
            temp.next = node;
        }else{ //插入中间
            node.next = temp;
            pre.next = node;
        }
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }

    }

}
