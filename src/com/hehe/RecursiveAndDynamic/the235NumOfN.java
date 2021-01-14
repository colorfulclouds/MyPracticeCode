package com.hehe.RecursiveAndDynamic;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 2,3,5 组合成的所有数
 */
public class the235NumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //组合的所有数排序的第 n个

        TreeSet<Long> set = new TreeSet<>();
        set.add(2L);
        set.add(3L);
        set.add(5L);
        long res = 2;
        for (int i = 0; i < n; i++) {
            long tmp = set.pollFirst();
            res = tmp;
            set.add(tmp*10+2);
            set.add(tmp*10+3);
            set.add(tmp*10+5);
        }
        System.out.println(res);
    }
}
