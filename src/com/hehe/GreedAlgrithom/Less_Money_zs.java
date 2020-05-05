package com.hehe.GreedAlgrithom;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 贪心策略实现切金条
 */
public class Less_Money_zs {
    /**
     * 切金条问题：
     * 每次切金条需要花费和金条长度一样的铜板数，问如何切能使代价最小
     * 【10,20,30】
     * 【30,30】->【10,20,30】 代价60+30 = 90  --代价最小
     * 【10,50】-》【10,20,30】 代价60+50 = 110
     */

    /**
     * 哈夫曼编码解决切金条等问题
     * 每次取两个最小的拿出来 相加后再放入队列 最后获得代价累加和
     * @param arr
     * @return
     */
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(); //优先级队列 默认小根堆
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; // < 0  o1 < o2  负数
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // <   o2 < o1
        }

    }

    public static void main(String[] args) {
        // solution
        int[] arr = {6, 7, 8, 9};
        System.out.println(lessMoney(arr));

        int[] arrForHeap = {3, 5, 2, 7, 0, 1, 6, 4};

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }

    }

}
