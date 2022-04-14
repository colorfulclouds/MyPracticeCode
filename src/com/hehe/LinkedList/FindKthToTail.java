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
 * <p>
 * 还可作为：已知链表有环且环中的节点数为 k ,求链表环的入口节点。
 * p1指针先走 k 步，p2从头和p1一起走 p1和p2相遇时 即入口节点
 * 见 findLoop
 * 追加：求环中节点数
 * 根据上面知道了入口节点 ，开始计数，再次回到这个节点时，计时完毕
 */
public class FindKthToTail {

    public static void main(String[] args) {
        /**
         * 创建带环的链表
         */
        ListNode01 head = new ListNode01(1);
        head.next = new ListNode01(2);
        head.next.next = new ListNode01(3);
        head.next.next.next = new ListNode01(4);
        head.next.next.next.next = new ListNode01(5);
        head.next.next.next.next.next = new ListNode01(6);
        head.next.next.next.next.next.next = head.next.next ;

        System.out.println(findLoop(head,4).val);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
//        ListNode01 head = new ListNode01(1);
//        head.next = new ListNode01(2);
//        head.next.next = new ListNode01(3);
//        head.next.next.next = new ListNode01(4);
//        head.next.next.next.next = new ListNode01(5);
//        head.next.next.next.next.next = new ListNode01(6);
//        System.out.println(find(head, 3));
    }

    /**
     * 找 链表倒数第K个节点
     *
     * @param head
     * @param k
     * @return
     */
    static int find(ListNode01 head, int k) {
        if (head == null || k == 0) {
            return -1;
        }
        ListNode01 p1 = head;
        for (int i = 0; i < k - 1; i++) {
            p1 = p1.next;
            if (p1 == null)
                return -1;
        }
        ListNode01 p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.val;
    }


    /**
     * 找到链表中的环的入口节点 ，已知环中节点个数
     *
     * @param head
     * @param n
     * @return
     */
    static ListNode01 findLoop(ListNode01 head, int n) {
        if (head == null || n == 0)
            return null;
        ListNode01 p1 = head;
        ListNode01 p2 = head;

        while (n != 0) {
            p1 = p1.next;
            n--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;


    }

}
