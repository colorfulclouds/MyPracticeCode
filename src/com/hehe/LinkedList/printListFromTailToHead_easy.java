package com.hehe.LinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 从尾到头打印链表
 */
public class printListFromTailToHead_easy {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(8);
        listNode.next = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode));

    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
        while(listNode!=null){
            stk.addLast(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!stk.isEmpty()){
            arrayList.add(stk.pollLast());
        }
        return arrayList;

    }
}
