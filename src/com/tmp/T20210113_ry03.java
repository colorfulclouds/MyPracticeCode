package com.tmp;

import java.util.Scanner;

/**
 * 3、最大公共子序列
 */
public class T20210113_ry03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr1 = new int[num];
        int[] arr2 = new int[num];
        for (int i = 0; i < num; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            arr2[i] = sc.nextInt();
        }

        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr1[i-1] == arr2[j-1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        System.out.println(num- dp[m][n]);
    }
}
