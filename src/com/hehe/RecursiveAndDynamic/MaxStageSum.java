package com.hehe.RecursiveAndDynamic;

import java.util.Scanner;
/**
 *
 * 4                //n行
 *       3          //1
 *     5 9 4        //2
 *   5 2 1 3 9      //3
 * 3 7 2 8 4 2 6    //4
 * 每个数从上到下 分别和左下、正下、右下相加 求最大值
 *
 * 1、note:边界
 * 2、从下往上算
 * dp[i][j] = Math.max(dp[i+1][j-1],Math.max(dp[i+1][j],dp[i+1][j+1]))   +   arr[i][j];
 */
public class MaxStageSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = n-i-1; j < n+i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[n][2*n-1];
        for (int j = 0; j < 2 * n - 1; j++) {
            dp[n-1][j] = arr[n-1][j];
        }
        int res = 0;
        for (int i = n-2; i >=0 ; i--) {
            for (int j = n-i-1; j < n+i; j++) {
                dp[i][j] = Math.max(dp[i+1][j-1],Math.max(dp[i+1][j],dp[i+1][j+1]))+arr[i][j];
                res = dp[i][j];
            }
        }
        System.out.println(res);
    }
}
