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
//        删除链表 测试用例
        ListNode node = deleteNode(head.next, 4);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

        System.out.println("=======反转链表 测试====================");
        ListNode reverseHead = reverseList(head);
        ListNode reverseHead01 = reverseList(null);
        ListNode reverseHead02 = reverseList(new ListNode(2));
        while(reverseHead != null){
            System.out.print(reverseHead.val + " ");
            reverseHead = reverseHead.next;
        }
        System.out.println();

        System.out.println("===========空白链表反转================");
        while(reverseHead01 != null){
            System.out.print(reverseHead01.val + " ");
            reverseHead01 = reverseHead01.next;
        }
        System.out.println();

        System.out.println("===========================");
        while(reverseHead02 != null){
            System.out.print(reverseHead02.val + " ");
            reverseHead02 = reverseHead02.next;
        }
        System.out.println();


        System.out.println("==========链表元素去重 测试===============");
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(5);
        ListNode res = deleteDuplication(head1);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();

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

    /**
     * 链表去重
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null)
            return new ListNode(-1);
        else{
            ListNode p = new ListNode(pHead.val);
            ListNode cur = p;
            pHead = pHead.next;
            while(pHead != null){
                while(pHead != null && cur.val == pHead.val){   //pHead为空时 若cur.val == pHead.val 在&&前，会报错应先判断 pHead != null
                    pHead = pHead.next;
                }
                if(pHead != null){
                    cur.next = new ListNode(pHead.val);
                    cur = cur.next;
                    pHead = pHead.next;
                }
            }
            return p;
        }

    }
}
