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
//        int[] score = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            map.put(i,sc.nextInt());
//            score[i] = map.get(i);
//        }
//        Arrays.sort(score);
//        for (int i = 0; i < n; i++) {
//            if(score[i] == map.get(m))
//                System.out.println(i);
//        }

        /**
         * TreeMap
         */
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(),i);
        }
        Set<Integer> set= map.keySet();
        for (int x : set){
            if(map.get(x) == m)
                System.out.println(x);
        }

    }




}
