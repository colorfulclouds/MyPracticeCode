package com.hehe.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//双百解法

/**
 * 1、给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * 2、反转链表
 */
public class OperateListNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        //删除链表 测试用例
        ListNode node = deleteNode(head.next, 4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        //反转链表 测试用例
        ListNode reverseHead = reverseList(head);
        ListNode reverseHead01 = reverseList(null);
        ListNode reverseHead02 = reverseList(new ListNode(2));
        while(reverseHead != null){
            System.out.print(reverseHead.val + " ");
            reverseHead = reverseHead.next;
        }
        while(reverseHead01 != null){
            System.out.print(reverseHead01.val + " ");
            reverseHead01 = reverseHead01.next;
        }
        while(reverseHead02 != null){
            System.out.print(reverseHead02.val + " ");
            reverseHead02 = reverseHead02.next;
        }

    }

    /**
     * 删除链表中指定值的节点
     * @param head
     * @param val
     * @return
     */
    static ListNode deleteNode(ListNode head, int val) {
        if (head == null) //1 、头结点为空
            return null;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        if (p1.val == val) {// 2、第一个结点为要删除的节点（包含只有一个结点的情况）
            return head.next;
        }

        while (p2 != null && p2.val != val) { //3、要删除的结点不存在 或者 在第一个之后
            p1 = p1.next;
            p2 = p1.next;
        }
        if (p2.val == val) {
            p1.next = p2.next;
            p2 = p1.next;
            return head;
        } else
            return head;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    static ListNode reverseList(ListNode head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = cur.next;

        while(tmp!=null){
            cur.next = pre;
            pre = cur;
            cur = tmp;
            tmp = tmp.next;
        }
        cur.next = pre;
        return cur;

    }
}
