package com.interview;

import java.util.Scanner;

/**
 * 正整数n的阶乘(n!)中的末尾有多少个0?
 *
 * 例如：n = 5, n! = 120.末尾有1个0
 *
 * 实现：int CountZero(int n);
 */
public class T20200823_aiqy1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int res = ContZero(n);
//        System.out.println(res);
        System.out.println(10*9*8*7*6*5*4*3*2);
        System.out.println(9*8*7*6*5*4*3*2);
        System.out.println(8*7*6*5*4*3*2);
        System.out.println(7*6*5*4*3*2);
        System.out.println(6*5*4*3*2);
        System.out.println(5*4*3*2);
        System.out.println(4*3*2);
        System.out.println(3*2);
        System.out.println(2);

    }

    private static int ContZero(int n) {
        int count = 0;
        for (int i = 1; i <=n ; i++) {
            int j = i;
            while(j % 5 == 0){
                count++;
                j = j/5;
            }
        }
        return count;
    }


}
