package com.hehe.LinkedList;

import com.hehe.LinkedList.LinkedList.ListNode;

public class AddTwoNum {
    /**
     * @param args
     */
    public static void main(String[] args) { // 243 564 807  342+465=708
        // 443 564 908  344+465=809
        ListNode one = new ListNode(4);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);
        PrintList(addTwoNumbers(one, two));
    }

    public static ListNode addTwoNumbers(ListNode one, ListNode two) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;  //进位
        while (one != null || two != null) {
            int x = one.data;
            int y = two.data;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;    //显示的和，在节点data域存储的数字
            cur.next = new ListNode(sum);
            cur = cur.next;  //cur指向新结点
            one = one.next;
            two = two.next;
        }
        //最高位需要进1
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void PrintList(ListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
