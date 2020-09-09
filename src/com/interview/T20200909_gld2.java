package com.interview;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 种草
 *
 */
public class T20200909_gld2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //
        int m = sc.nextInt();
        int h = sc.nextInt();
        PriorityQueue<Long> p = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            p.add(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            long cur = p.poll();
            p.add(cur+h);
        }
        System.out.println(p.peek());
//        int[] data = new int[num];
//        long sum = 0;
//        long min = Integer.MAX_VALUE;
//        for (int i = 0; i < num; i++) {
//            data[i] = sc.nextInt();
//            sum+=data[i];
//            if(data[i]  < min)
//                min = data[i];
//        }
//        sum+=m*h;
//        long avg = sum /num;
//        min+=m*h;
//        while(min - h >= avg)
//            min-=h;
//        System.out.println(min);
    }
}
