package com.hehe.Classic;

import java.util.*;

/**
 * 双操作两个整数
 * op:
 *  1、每个整数 每两个bit位交换位置
 *  2、每个整数向右移动两位 移出的两位 移到下一个数的最高位 没有下一个数 移到自己的最高位上 最后一个数的溢出两位 移到第一个数的最高两位
 */
public class Z_BitCal {

    static long[] b = new long[32 * 1020];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        long c[] = new long[array.length];
        long a[] = new long[array.length];
        int n = array.length;
        for (int i = 0; i < n; i++)
            a[i] = Long.valueOf(array[i]);

        for (int i = 0; i < a.length; i++) {
            long x = a[i];
            for (int j = 0; j < 32; j++) {
                b[i * 32 + (32 - j - 1) + 2] = x % 2;
                x /= 2;
            }
            for (int j = 0; j < 32; j += 2) {
                long temp = b[i * 32 + j + 2];
                b[i * 32 + j + 2] = b[i * 32 + j + 3];
                b[i * 32 + j + 3] = temp;
            }
        }
        b[0] = b[n * 32];
        b[1] = b[n * 32 + 1];
        for (int i = 0; i < n; i++) {
            long x = 0;
            for (int j = 0; j < 32; j++) {
                x = x * 2 + b[i * 32 + j];
            }
            c[i] = x;
        }
        for (int i = 0; i < n; i++)
            System.out.print(c[i] + " ");
    }

}
