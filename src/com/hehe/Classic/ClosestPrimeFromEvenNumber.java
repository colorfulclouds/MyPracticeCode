package com.hehe.Classic;

import java.util.Scanner;

/**
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 数据范围：输入的数据满足 4 \le n \le 1000 \4≤n≤1000
 * 输入描述：
 * 输入一个大于2的偶数
 *
 * 输出描述：
 * 从小到大输出两个素数
 *
 * 示例1
 * 输入：
 * 20
 * 复制
 * 输出：
 * 7
 * 13
 */
public class ClosestPrimeFromEvenNumber {

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / i; i++) { //i <= num / i  等同于    i < sqrt(num)
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static int count(int n) {
        int i = n / 2, j = n - i;
        while (!isPrime(i)|| !isPrime(j)) {
            i--;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int res = count(n);
            System.out.println(res);
            System.out.println(n - res);
        }
    }
}