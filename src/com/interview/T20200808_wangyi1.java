package com.interview;
import java.util.Scanner;

/**
 * n个数字
 * 每个数字不是1,2,3时进行拆分，拆分为素数
 *
 * 3
 * 10 3 5
 * 10 = 2 2 2 2 2
 * 3 = 3
 * 5 = 2 3
 *
 * 输出：8
 */
public class T20200808_wangyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long count = 0;

        for (int i = 0; i < n; i++) {
            long tmp = sc.nextLong();
            if(tmp == 1)
                continue;
            else if (tmp ==3 || tmp == 2){
                count++;
                continue;
            }
            else if (tmp > 3)
                count += tmp / 2;
        }

        System.out.println(count);
    }

}
