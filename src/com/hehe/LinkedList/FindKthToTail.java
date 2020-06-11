package com.hehe.LinkedList;


class ListNode01 {
    int val;
    ListNode01 next;

    ListNode01(int x) {
        val = x;
    }
}

/**
 * 链表倒数第K个节点
 * 注意：代码的鲁棒性
 */
public class FindKthToTail {
    static ListNode01 find(ListNode01 head,int k){
        if(head == null || k == 0){
            return null;
        }
        ListNode01 p1 = head;
        for (int i = 0; i < k-1; i++) {
            p1 = p1.next;
            if(p1 == null)
                return null;
        }
        ListNode01 p2 = head;
        while(p1.next !=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

}
