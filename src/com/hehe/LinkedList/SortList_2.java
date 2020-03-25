package com.hehe.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

//同SortList_1 文件
public class SortList_2 {

    public static Node sortList(Node head){
        if(head == null ||  head.next == null)
            return head;
        Node p1 = head;
        Node p2 = head.next;
        while(p1.next != null){
            while(p2 != null){
                if (p2.value < p1.value) {
                    int tmp = p2.value;
                    p2.value = p1.value;
                    p1.value = tmp;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
            p2 = p1.next;
        }
        return head;
    }

    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            array.add(Integer.valueOf(s1[i]));
        }
        Node head = new Node();
        Node p = head;

        for (int i = 0; i < array.size(); i++) {
            Node node = new Node();
            node.value = array.get(i);
            node.next = null;
            p.next = node;
            p = node;
        }
        sortList(head.next);
        printList(head.next);
    }
}