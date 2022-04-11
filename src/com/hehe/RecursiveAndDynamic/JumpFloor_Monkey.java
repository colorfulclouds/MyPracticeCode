package com.hehe.RecursiveAndDynamic;

import java.util.*;

/**
 * 【猴子爬山】一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯： 每一次只能跳1步或跳3步，试问猴子通过这个阶梯
 * 有多少种不同的跳跃方式？
 */
public class JumpFloor_Monkey {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 7];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i + 1] += dp[i];
            dp[i + 3] += dp[i];
        }
        System.out.println(dp[n]);

        System.out.println("====================2===========");
        System.out.println(jumpFloor(n));
    }

    public static long jumpFloor(int n) {
        if (n == 0)
            return 0;
        if(n < 2)
            return 1;
        if(n == 3)
            return 2;

        long[] f = {1, 1, 2, 0};
        for (int i = 4; i <= n; i++) {
            f[3] = f[2] + f[0];
            f[0] = f[1];
            f[1] = f[2];
            f[2] = f[3];
        }
        return f[3];
    }
}
