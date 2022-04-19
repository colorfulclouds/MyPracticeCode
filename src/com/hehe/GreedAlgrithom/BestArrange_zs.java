package com.hehe.GreedAlgrithom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 贪心策略实现会议安排：会议有起始时间 求最大能安排多少场会议
 */
public class BestArrange_zs {

    public static class Program { //
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 会议按结束时间比较器
     */
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    /**
     * 数组实现最优会议安排
     *
     * @param programs
     * @return
     */
    public static int BestArrange(Program[] programs) {
        Arrays.sort(programs, (v1, v2) -> v1.end - v2.end); //new ProgramComparator()
        int count = 0, currentTime = 0;
        for (int i = 0; i < programs.length; i++) {
            if (currentTime <= programs[i].start) {
                count++;
                currentTime = programs[i].end;
            }
        }
        return count;
    }

    /**
     * 小根堆实现最优会议安排
     * 按最早结束时间排序时 结束时间小的会议在前 故用小根堆
     *
     * @param programs
     * @return
     */
    public static int BestArrange01(Program[] programs) { //,int cur
        int count = 0, currentTime = 0;
        PriorityQueue<Program> queue = new PriorityQueue<>(new Comparator<Program>() { //会议按结束时间比较器
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });  //new ProgramComparator()

        for (int i = 0; i < programs.length; i++) {
            queue.add(programs[i]);
        }
        while (!queue.isEmpty()) {
            Program cur_queue = queue.poll();
            if (currentTime <= cur_queue.start) {
                count++;
                currentTime = cur_queue.end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Program[] programs = new Program[3];
        programs[0] = new Program(1, 3);
        programs[1] = new Program(2, 4);
        programs[2] = new Program(5, 6);

        System.out.println(BestArrange(programs));
        System.out.println(BestArrange01(programs));
    }

}

