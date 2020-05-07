package com.hehe.GreedAlgrithom;
import java.util.*;

public class ResourceRequest_hw {
    public static class Request {
        int size;
        int cost;

        public Request(int size, int cost) {
            this.size = size;
            this.cost = cost;
        }

    }

//    public static class MinComp implements Comparator<Request> {
//        @Override
//        public int compare(Request o1, Request o2) {
//            return o1.size - o2.size;
//        }
//    }

    public static class MaxComp implements Comparator<Request> {
        @Override
        public int compare(Request o1, Request o2) {
            return o2.cost - o1.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
//        int[] machines = new int[M];
        List<Integer> machines = new ArrayList<>();  //也可以用静态数组 将用过的机器置为-1
//        PriorityQueue<Integer> machinequue = new PriorityQueue<>()
//        PriorityQueue<Request> queue1 = new PriorityQueue<>(new MinComp());
        //只需要一个优先级队列 按收益 建成收益大根堆
        PriorityQueue<Request> queue = new PriorityQueue<>(new MaxComp());

        for (int i = 0; i < M; i++) {
//            machines[i] = sc.nextInt();
            machines.add(sc.nextInt());
        }
        int size,cost;
        Request r;
        //将 请求信息 进 收益大根堆
        for (int i = 0; i < N; i++) {
            size = sc.nextInt();
            cost = sc.nextInt();
            r = new Request(size,cost);
            queue.add(r);
        }

        int W = 0;  //收益
        //有空闲机器 有待处理的请求
        while(!machines.isEmpty() && !queue.isEmpty()){  //一次调度周期理解为一次输入的所有请求的处理
            int which = isOk(machines, queue.peek().size);
            if(which!=-1){
                W += queue.poll().cost;
                machines.remove(which);
            }else
                queue.poll();
        }

        System.out.println(W);
    }


    /**
     * 查找给定数组中是否有某个值
     * （空闲机器中有无可提供服务的机器）
     * @param list
     * @param size
     * @return 有则返回下标，无则返回-1
     */
    public static int isOk(List<Integer> list, int size) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= size)
                return i;
        }
        return -1;
    }


}


//3 5
//10 12 15
//8 10
//12 11
//16 22
//13 14
//9 11
