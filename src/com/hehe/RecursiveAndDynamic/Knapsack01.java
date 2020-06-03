package com.hehe.RecursiveAndDynamic;

/**
 * 0_1背包问题 【二维数组V(i,j)放置所有中间结果】
 * 有n个物品，它们有各自的体积和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？ *
 * 为方便讲解和理解，下面讲述的例子均先用具体的数字代入，即：eg：number＝4，capacity＝8
 * i（物品编号）	1	2	3	4
 * w（体积）	    2	3	4	5
 * v（价值）	    3	4	5	6
 *
 * 思路：
 * 要到达V(i,j)这一个状态有两种方式
 * 1、第i件商品没有装进去，没有装进去，就是V(i-1,j)
 * 2、第i件商品装进去了。装进去了，如果装进去第i件商品，那么装入之前是什么状态，肯定是V(i-1,j-w(i))
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] w = {0, 2, 3, 4, 5};            //商品的体积2、3、4、5
        int[] v = {0, 3, 4, 5, 6};            //商品的价值3、4、5、6
        int bagV = 8;                            //背包大小
        int[][] dp = new int[5][9];                    //动态规划表

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= bagV; j++) {
                if (j < w[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }

        //动态规划表的输出
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
    }

}
