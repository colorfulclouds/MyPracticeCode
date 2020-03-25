package com.hehe.Heap;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//PriorityQueue  默认小根堆
//需要大根堆，需要加比较器


public class Top_K {
    /**
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

    public static void main(String[] args) {
        int[] input = {1,2,4,5,6,8,3};
        List<Integer> list = solutionByHeap(input,1);
        for(int l:list){
            System.out.println(l);
        }
    }

}
