package com.hehe.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;
//import LinkedList.Node;

public class SortList_1 {

    /**
     * 链表从小到大排序
     * @param head
     * @return
     */
    public static Node sortList(Node head){
        if(head == null ||  head.next == null)
            return head;
        Node p1 = head;
        Node p2 = head.next;
        while(p1.next != null){
            while(p2 != null){   //首轮循环结束，只排好第一个位置上的数字，为最小值
                if (p2.value < p1.value) {
                    int tmp = p2.value;
                    p2.value = p1.value;
                    p1.value = tmp;
                }
                p2 = p2.next;
            }
            p1 = p1.next;  //开始排第二个位置
            p2 = p1.next;
        }
        return head;
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

        //链表排序
        sortList(head.next);
        //打印链表
        printList(head.next);

    }
}

//1 3 4 2 6 8 7
//1 2 3 4 6 7 8
