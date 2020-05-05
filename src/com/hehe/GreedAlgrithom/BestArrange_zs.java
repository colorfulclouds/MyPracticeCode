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
     *数组实现最优会议安排
     * @param programs
     * @param cur
     * @return
     */
    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start) {
                result++;
                cur = programs[i].end;
            }
        }
        return result;
    }

    /**
     * 小根堆实现最优会议安排
     * 按最早结束时间排序时 结束时间小的会议在前 故用小根堆
     * @param programs
     * @param cur
     * @return
     */
    public static int besArrange(Program[] programs,int cur){
        int res = 0;
        PriorityQueue<Program> queue = new PriorityQueue<>(new ProgramComparator());
        while(!queue.isEmpty()){
            Program cur_queue = queue.poll();
            if(cur <= cur_queue.start){
                res++;
                cur = cur_queue.end;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}

