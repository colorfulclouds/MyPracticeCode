package com.hehe.LinkedList;

import java.util.*;

public class MergeKLists {

    public static void main(String[] args) {
        ListNode one = new ListNode(-1);
        one.next = new ListNode(1);
        one.next.next = new ListNode(2);

        ListNode two = new ListNode(7);
        two.next = new ListNode(8);
        two.next.next = new ListNode(9);

        ListNode[] lists = new ListNode[2];
        lists[0] = one;
        lists[1] = two;

        System.out.println("=============== 通过 ===================");
        ListNode res1 = mergeKLists(lists);
        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.next;
        }

        System.out.println("===============超时的做法！====================");

        ListNode res = mergeKListNode(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    /**
     * 通过！
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {  //if只放了多个链表的头节点指针
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }

    /**
     * 超时！while
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKListNode(ListNode[] lists) {
//        Queue<ListNode> queue = new PriorityQueue<>(new FirstComparator());
        Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val); //更简单的比较器
        for (ListNode node : lists) {
            while (node != null) { //while 循环 把每个节点放进去
                queue.offer(node);
                node = node.next;
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }

    public static class FirstComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }


}
