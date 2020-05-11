package com.hehe.GreedAlgrithom;

import java.util.*;

public class HuaWei2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        //代表机器的小根堆 10 12 15
        PriorityQueue<Integer> machineQueue = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            machineQueue.add(in.nextInt());
        }
        //请求堆
        PriorityQueue<Request> requestqueue = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            int size = in.nextInt();
            int cost = in.nextInt();
            Request request = new Request(size,cost);
            requestqueue.add(request);
        }
        int max = 0;
        Request request;
        while ((request = requestqueue.poll())!= null){
            int min = -1;
            Integer size;
            PriorityQueue<Integer> machineTmp = new PriorityQueue<>();
            while ((size = machineQueue.poll())!= null){
                if(request.getSize() <= size){
                    min = size;
                    break;
                }
                machineTmp.add(size);
            }
            machineTmp.addAll(machineQueue);
            machineQueue = machineTmp;
            if(min == -1){
                continue;
            }
            max += request.getCost();
        }
        System.out.println(max);
    }
}

class Request implements Comparable<Request>{
    private int size,cost;
    public int getCost() {
        return cost;
    }
    public int getSize() {
        return size;
    }
    public Request(int size,int cost) {
        this.cost = cost;
        this.size = size;
    }
    @Override
    public int compareTo(Request request) {
        if(request.getSize() != size){
            return request.getSize() - size;
        }else {
            return request.getCost() - cost;
        }
    }

}