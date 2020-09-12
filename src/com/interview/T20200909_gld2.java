package com.interview;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 种草
 */
public class T20200909_gld2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //num株草
        int m = sc.nextInt();   //m瓶魔法液
        int h = sc.nextInt();   //每瓶能使草长高的长度
        PriorityQueue<Long> p = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            p.add(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            long cur = p.poll();
            p.add(cur + h);
        }
        System.out.println(p.peek());
    }
}
