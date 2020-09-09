package com.interview;

import java.util.Scanner;

public class T20200909_gld1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int value = sc.nextInt()*100;
        int[] e = new int[num];
        int[] v = new int[num];
        for (int i = 0; i < num; i++) {
            e[i] = (int)(sc.nextFloat()*100);
            v[i] = sc.nextInt();
        }
        System.out.println(Sol(num,value,e,v));
    }

    public static int Sol(int num,int value,int[] e,int[] v){
        int dp[] = new int[value+1];
        for (int i = 1; i < num+1; i++) {
            for (int j = value; j >= e[i-1] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-e[i-1]]+v[i-1]);
            }
        }
        return dp[value];
//        int[][] dp = new int[num + 1][value+1];
//        for (int i = 1; i <= num ; i++) {
//            for (int j = 1; j <= value; j++) {
//                if(j < e[i])
//                    dp[i][j] = dp[i-1][j];
//                else
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-e[i]]+v[i]);
//
//            }
//        }
//        return dp[num][value];


    }
}
