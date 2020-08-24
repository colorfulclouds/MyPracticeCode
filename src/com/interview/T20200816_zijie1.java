package com.interview;

import java.util.*;

/**
 * n 人数
 * m 工号
 * ni  工号为i的人的分数
 *
 * 输出工号m的排名
 */
public class T20200816_zijie1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();

        /**
         * HashMap
         */
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] score = new int[n];
//        for (int i = 0; i < n; i++) {
//            map.put(i,sc.nextInt());
//            score[i] = map.get(i);
//        }
//        Arrays.sort(score);
//        int rank = 1;
//        for (int i = n-1; i > 0; i--) {
//            if(score[i] == map.get(m))
//                System.out.println(rank);
//            else
//                rank++;
//
//        }

        /**
         * TreeMap
         */
        Map<Integer,Integer> t_map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }); //默认是从小到大排序
        for (int i = 0; i < n; i++) {
            t_map.put(sc.nextInt(),i);
        }
        Set<Integer> set= t_map.keySet();
        int t_rank = 1;
        for (int x : set){
            if(t_map.get(x) == m)
                System.out.println(t_rank);
            else
                t_rank++;
        }

    }




}
