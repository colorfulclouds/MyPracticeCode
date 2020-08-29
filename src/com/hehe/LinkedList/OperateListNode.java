package com.hehe.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
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
 * <p>
 * 2、反转链表
 */
public class OperateListNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
//
        System.out.println("=======删除链表 测试用例====================");
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
        while (reverseHead != null) {
            System.out.print(reverseHead.val + " ");
            reverseHead = reverseHead.next;
        }
        System.out.println();

        System.out.println("===========空白链表反转================");
        while (reverseHead01 != null) {
            System.out.print(reverseHead01.val + " ");
            reverseHead01 = reverseHead01.next;
        }
        System.out.println();

        System.out.println("===========================");
        while (reverseHead02 != null) {
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
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();

        System.out.println("==========链表中 将有重复的元素 全部去掉===============");
//        ListNode head2 = new ListNode(1);
//        head2.next = new ListNode(2);
//        head2.next.next = new ListNode(3);
//        head2.next.next.next = new ListNode(3);
//        head2.next.next.next.next = new ListNode(4);
//        head2.next.next.next.next.next = new ListNode(4);
//        head2.next.next.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(1);
        head2.next.next.next.next = new ListNode(1);
        head2.next.next.next.next.next = new ListNode(1);
        head2.next.next.next.next.next.next = new ListNode(1);
        //       ListNode resx = deleteDuplication01(head2);
//        if(resx != null){
//            while(resx != null){
//                System.out.println(resx.val + " ");
//                resx = resx.next;
//            }
//        }else{
//            System.out.println("null");
//        }


        ListNode resx1 = deleteDuplication02(head2);
        if (resx1 != null) {
            while (resx1 != null) {
                System.out.println(resx1.val + " ");
                resx1 = resx1.next;
            }
        } else {
            System.out.println("null");
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
        if (p2 != null && p2.val == val) {
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
    static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = cur.next;

        while (tmp != null) {
            cur.next = pre;
            pre = cur;
            cur = tmp;
            tmp = tmp.next;
        }
        cur.next = pre;
        return cur;

    }

    /**
     * 反转链表递归版
     * zf
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList01(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 链表去重
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return new ListNode(-1);
        else {
            ListNode p = new ListNode(pHead.val);
            ListNode cur = p;
            pHead = pHead.next;
            while (pHead != null) {
                while (pHead != null && cur.val == pHead.val) {   //pHead为空时 若cur.val == pHead.val 在&&前，会报错应先判断 pHead != null
                    pHead = pHead.next;
                }
                if (pHead != null) {
                    cur.next = new ListNode(pHead.val);
                    cur = cur.next;
                    pHead = pHead.next;
                }
            }
            return p;
        }

    }


    /**
     * 01、链表中 将有重复的元素 全部去掉
     * 1 2 2 3 3 4
     * 1 4
     *
     * hehe
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication01(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        HashMap<Integer, Integer> map = new HashMap<>(); //计数map

        while (pHead != null) {
            map.put(pHead.val, map.getOrDefault(pHead.val, 0) + 1);  // HashMap得更新值操作
//            if(!map.containsKey(pHead.val))
//                map.put(pHead.val,1);
//            else
//                map.put(pHead.val,map.get(pHead.val)+1);
            pHead = pHead.next;
        }

        ArrayList<Integer> res_arr = new ArrayList<>();  //动态结果数组
        for (Integer k : map.keySet()) {
            if (map.get(k) == 1)
                res_arr.add(k);
        }
        ListNode res_list = new ListNode(-1);  //！！！哑结点！！！
        ListNode p = res_list;
        for (int i = 0; i < res_arr.size(); i++) {
            p.next = new ListNode(res_arr.get(i));
            p = p.next;
        }
        return res_list.next;
    }

    /**
     * 02、链表中 将有重复的元素 全部去掉
     * 双指针 同起步 在原链表上操作
     *
     * zhangfan
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication02(ListNode pHead) {
        ListNode pre, last;
        ListNode H = new ListNode(-1);
        H.next = pHead;
        pre = H;
        last = H;

        while (last != null) {
            if (last.next == null || last.next.next == null || last.next.val != last.next.next.val) {
                pre.next = last.next;
                pre = pre.next;
//                last=last.next;
                last = pre;
                continue;
            }
            last = last.next;
            while (last.next != null && last.val == last.next.val) {
                last = last.next;
            }
        }
        return H.next;

    }

    /**
     * 03、链表中 将有重复的元素 全部去掉
     * 双指针 不同起步 在原链表上操作
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication0X(ListNode pHead) {
        if(pHead == null || pHead.next == null)
            return pHead;

        ListNode H = new ListNode(-1);
        H.next = pHead;
        ListNode pre = H;
        ListNode last = H.next;
        while(last != null){
            if(last.next != null && last.val == last.next.val){
                while(last.next != null && last.val == last.next.val)
                    last = last.next;
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return H.next;
    }

    /**
     * 合并两个有序链表
     * （有序链表的归并，递归）
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode res = null;
        if(list1.val <= list2.val){
            res = list1;
            res.next = Merge(list1.next,list2);
        }else{
            res = list2;
            res.next = Merge(list1,list2.next);
        }
        return res;
    }

    /**
     * 合并两个有序链表
     * （有序链表的归并，非递归）
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge01(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode p = head;
        while(list1 != null && list2 !=null){
            if(list1.val <= list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }else{
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            p.next = list1;
        }
        if(list2 !=null){
            p.next = list2;
        }
        return head.next;
    }


}
