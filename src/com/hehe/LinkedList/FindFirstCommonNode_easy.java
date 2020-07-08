package com.hehe.LinkedList;

/**
 * 两链表的第一个公共结点
 */
public class FindFirstCommonNode_easy {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);


        ListNode l2 = new ListNode(7);
        l2.next = l1.next.next;

        System.out.println(findFirstCommonNode(l1,l2).val);
    }


    public static ListNode findFirstCommonNode(ListNode l1, ListNode l2) {
        int len1 = l1.getLen(l1);
        int len2 = l2.getLen(l2);
        int dif = len1 > len2 ? len1 - len2 : len2 - len1;

        if (len1 == 0 || len2 == 0)
            return null;
        ListNode Long = l1;
        ListNode Short = l2;
        if(len1<len2){
            Long = l2;
            Short = l1;
        }

        while(dif>0 && Long!=null){
            Long = Long.next;
            dif--;
        }

        while(Long!=null && Short !=null && Long.val != Short.val){
            Long = Long.next;
            Short = Short.next;
        }
        return Long;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        int getLen(ListNode l) {
            int len = 0;
            while (l != null) {
                len++;
                l = l.next;
            }
            return len;
        }
    }

}
