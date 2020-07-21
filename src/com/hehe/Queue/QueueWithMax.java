package com.hehe.Queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax {

    Queue<Integer> queue; //ArrayDeque
    LinkedList<Integer> max;

    public QueueWithMax(){
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    /**
     * 取得队列的最大值
     * max队列维护的队首就是最大值
     * 队首即为最大值元素 队空返回-1
     * @return
     */
    public int max_value(){
        return max.isEmpty() ? -1 : max.getFirst();
    }

    /**
     * 入队
     * max队列：入栈元素大于队尾元素即更新最大值队列
     * queue：直接入队
     * @param value
     */
    public void push_back(int value){
        queue.add(value);
        while(!max.isEmpty() && max.getLast() < value)
            max.pollLast();
        max.addLast(value);
    }

    /**
     * 出队
     * max队列：当前元素为最大值队列的队首 需要更新最大值队列
     * queue:直接出队 队空返回-1
     * @return
     */
    public int pop_front(){
        if(!max.isEmpty() && queue.peek().equals(max.getFirst()))
            max.pollFirst();
        return queue.isEmpty()? -1 : queue.poll();
    }
}
