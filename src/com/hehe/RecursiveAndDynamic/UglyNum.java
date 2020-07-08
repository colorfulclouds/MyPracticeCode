package com.hehe.RecursiveAndDynamic;

/**
 * 因子只有2,3,5的数称为丑数,习惯把 1 称为丑数
 * eg:1, 2, 3, 4, 5, 6, 8, 9
 * <p>
 * x2:2, 4, 6, 8,10,12,16,18
 * x3:3, 6, 9,12,15,18,24,27
 * x5:5,10,15,20,25,30,40,45
 * <p>
 * dp[i] = min{dp[a]*2 , dp[b]*3 , dp[c]*5 }
 */
public class UglyNum {
    public static void main(String[] args) {
        System.out.println(UglyNum_Xth(8));
        System.out.println(UglyNum_Xth(1500));

    }

    public static int UglyNum_Xth(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n4 = dp[c] * 5;
            int cur = Math.min(n2, Math.min(n3, n4));
            dp[i] = cur;

            if (cur == n2) a += 1;
            if (cur == n3) b += 1;
            if (cur == n4) c += 1;
        }


        return dp[n - 1];
    }
}
