package com.hehe.GreedAlgrithom;

import java.util.Comparator;
import java.util.PriorityQueue;

/**贪心策略 实现项目受益最大
 * 给定初始资金 多个项目 最多做 k 个项目 求能获得的最大利润 W
 */
public class IPO_zs {

    public static class Node {
        public int p; //收益
        public int c; //代价

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    /**
     * 代价 最小在堆顶
     */
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    /**
     *收益 最大在堆顶
     */
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());   //默认就是小根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            //花费小根堆不空 解锁 花费小根堆 里面的所有可解锁的项目添加到利润大根堆里面
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {  //没有可解锁的就返回
                return W;
            }
            W += maxProfitQ.poll().p;  //计算完成一个解锁项目后的收益
        }

        return W;
    }

    public static void main(String[] args) {
        int[] Profits = {3,4,2,9};
        int[] Capital = {5,6,10,20};
        int W = findMaximizedCapital(3,7,Profits,Capital);
        System.out.println(W);
    }
}
