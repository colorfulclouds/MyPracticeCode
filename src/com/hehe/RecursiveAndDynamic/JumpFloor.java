package com.hehe.RecursiveAndDynamic;

import java.util.ArrayList;

public class JumpFloor {
    public static void main(String[] args) {
        //比较倾向于找规律的解法，f(1) = 1, f(2) = 2, f(3) = 3, f(4) = 5，  可以总结出f(n) = f(n-1) + f(n-2)的规律，但是为什么会出现这样的规律呢？
        // 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6，
        // 其他的不能从3跳到6什么的啦，所以最后就是f(6) = f(5) + f(4)；这样子也很好理解变态跳台阶的问题了
        System.out.println(jumpFloor(3));
        System.out.println(climbStairs(3));

        System.out.println(jumpFloor(5));
        System.out.println(climbStairs(5));

        System.out.println(jumpFloor(10));
        System.out.println(climbStairs(10));
        System.out.println("=========================================");

        System.out.println(jumpFloorII(3));
        System.out.println("==================III=======================");
        System.out.println(jumpFloorIII_1(10));
        System.out.println(jumpFloorIII_2(10));
        System.out.println(jumpFloorIII_3(10));
        System.out.println("===================III======================");
        System.out.println("===================IIII======================");
        System.out.println(jumpFloorIIII(10));
        System.out.println("===================IIII======================");
        System.out.println(jumpFloorV(10));

    }

    /**
     * 初级跳台阶
     *
     * @param n
     * @return
     */
    public static long jumpFloor(int n) {
        if (n <= 0)
            return 0;
        if (n <= 2)
            return n;
        long[] f = {1, 2, 0};
        for (int i = 2; i < n; i++) {
            f[2] = f[1] + f[0];
            f[0] = f[1];
            f[1] = f[2];
        }
        return f[2];
    }

    /**
     * 初级跳台阶 (斐波那契公式求解)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
        return (int) (fib_n / sqrt_5);
    }


    //f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    //f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    // 可以得出：
    // f(n) = 2*f(n-1)

    /**
     * 变态跳台阶
     *
     * @param target
     * @return
     */
    public static int jumpFloorII(int target) {

        return 1 << (target - 1);
    }

    /**
     * 跳台阶 每次一步或者两步 且要求不能有连续的两步
     *
     * @param n
     * @return
     */
    public static int jumpFloorIII_1(int n) {
        if (n <= 4)
            return n;
        int[] arr = {1, 2, 3, 4};
        while (n > 4) {
            int tmp = arr[0] + arr[1] + arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[3];
            arr[3] = tmp;
            n -= 1;
        }
        return arr[3];
    }

    public static int jumpFloorIII_2(int n) {

        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 3;

        int dp[] = new int[n+1];
        dp[0]=1;dp[1]=1;dp[2]=2;dp[3]=3;

        for(int i=4;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-3];
        }
        return dp[n];
    }

    public static int jumpFloorIII_3(int n) {
        if (n <= 3)
            return n;

        // first total methods number
        // second last step is one step methods number
        int[][] dp = new int[n][2];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 2;
        dp[1][1] = 1;
        dp[2][0] = 3;
        dp[2][1] = 2;

        for (int i = 3; i < n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][1];
            dp[i][1] = dp[i-1][0];
        }
        return dp[dp.length-1][0];
    }

    /**
     * 【猴子爬山】一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯： 每一次只能跳1步或跳3步，试问猴子通过这个阶梯
     *  有多少种不同的跳跃方式？
     * @param n
     * @return
     */
    public static long jumpFloorIIII(int n) {
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

    /**
     * 复杂度高 没通过字节的笔试
     *
     * @param n
     * @return
     */
    public static int jumpFloorV(int n) {
        if (n <= 4)
            return n;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int size = 0;
        while (n > 0) {
            size = list.size();
            int tmp = list.get(size - 2) + list.get(size - 3) + list.get(size - 4);
            list.add(tmp);
            n -= 1;
        }
        return list.get(list.size() - 1);
    }

}
