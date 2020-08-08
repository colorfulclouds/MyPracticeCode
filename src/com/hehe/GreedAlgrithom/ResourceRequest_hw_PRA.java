package com.hehe.GreedAlgrithom;

import java.util.*;

public class ResourceRequest_hw_PRA {
    public static class Task {
        public int size;
        public int cost;

        public Task(int size, int cost) {
            this.size = size;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int size = 0, cost = 0;

        List<Integer> machine = new ArrayList<>();
        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.cost - o1.cost;
            }
        });

        for (int i = 0; i < M; i++) {
            machine.add(sc.nextInt());
        }
        Collections.sort(machine);
        for (int i = 0; i < N; i++) {
            size = sc.nextInt();
            cost = sc.nextInt();
            Task tsk = new Task(size, cost);
            queue.add(tsk);
        }
        int W = 0;
        while (!machine.isEmpty() && !queue.isEmpty()) {
            int which = isOk(machine, queue.peek().size);
            if (which != -1) {
                W += queue.poll().cost;
                machine.remove(which);
            } else
                queue.poll();
        }
        System.out.println(W);

    }

    public static int isOk(List<Integer> list, int size) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= size)
                return i;
        }
        return -1;
    }
}
