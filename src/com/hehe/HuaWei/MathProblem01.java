package com.hehe.HuaWei;

import java.util.Scanner;

/**
 * 求解连续数列：已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N(0<S<100000,0<N<100000),求此数列K。
 *
 * 输入描述:
 *
 * 输入包含两个参数，1)连续正整数数列和S，2)数列里数的个数N。
 *
 * 输出描述:
 *
 * 如果有解输出数列K，如果无解输出-1。
 * 示例1:
 *
 * 输入
 *
 * 525
 *
 * 6
 *
 * 输出
 *
 * 85 86 87 88 89 90
 */
public class MathProblem01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int tar = sc.nextInt();
            int len = sc.nextInt();
            int[] arr = new int[len];
            arr[len - 1] = tar / len;
            for (int i = len - 2; i >= 0; i--) {
                arr[i] = arr[i + 1] - 1;
            }
            int[] ans = fun(arr, tar);
            if (ans != null) {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
            } else {
                System.out.println(-1);
            }

        }
    }

    static int[] fun(int[] arr, int tar) {
        int sum = 0;
        while (sum < tar) {
            for (int i = 0; i < arr.length; i++) {
                arr[i]++;
            }
            sum = 0;
            for (int i : arr) {
                sum += i;
            }
            if (sum == tar) {
                return arr;
            }
        }
        return null;
    }
}
