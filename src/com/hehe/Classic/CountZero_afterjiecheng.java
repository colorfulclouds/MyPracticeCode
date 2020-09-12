package com.hehe.Classic;

import java.util.Scanner;

/**
 * 正整数n的阶乘(n!)中的末尾有多少个0?
 * 例如：n = 5, n! = 120.末尾有1个0
 *
 *对于阶乘中的数字 含因子5的个数就是结果
 */
public class CountZero_afterjiecheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = ContZero(n);
        System.out.println(res);

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
