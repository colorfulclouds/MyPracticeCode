package com.hehe.Heap;
import java.util.*;

//PriorityQueue  默认小根堆
//需要大根堆，需要加比较器


public class Top_K {
    /**
     * 前 k 大的数字
     * Top_K 复杂度为O(n*logk)----k<<n时--->O(n)
     * @param input
     * @param k
     * @return
     */
    public static List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<Integer>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    /**前 k 小的数字
     * 维护一个大根堆 存当前前 k 小的数字，下一个元素小于堆顶的最大值，堆顶出堆，新元素进堆
     * @param input
     * @param k
     * @return
     */
    public static List<Integer> solutionByHeap02(int[] input, int k) {
        List<Integer> list = new ArrayList<Integer>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {1,2,4,5,6,8,3};
        List<Integer> list = solutionByHeap(input,2);
        List<Integer> list01 = solutionByHeap02(input,2);
        for(int l:list){
            System.out.println(l);
        }
        for(int l:list01){
            System.out.println(l);
        }
    }

}
