package com.hehe.RecursiveAndDynamic;

/**
 * 0_1背包问题 【二维数组V(i,j)放置所有中间结果】
 * 有n个物品，它们有各自的体积和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？ *
 * 为方便讲解和理解，下面讲述的例子均先用具体的数字代入，即：eg：number＝4，capacity＝8
 * i（物品编号）	1	2	3	4
 * w（体积）	2	3	4	5
 * v（价值）	3	4	5	6
 * <p>
 * 思路：
 * 要到达V(i,j)这一个状态有两种方式
 * 1、第i件商品没有装进去，没有装进去，就是V(i-1,j)
 * 2、第i件商品装进去了。装进去了，如果装进去第i件商品，那么装入之前是什么状态，肯定是V(i-1,j-w(i))
 */
public class Knapsack01 {
    public static void main(String[] args) {

        System.out.println("================经典背包问题 二维数组==================");
//        int[] w = {0, 2, 3, 4, 5};            //商品的体积2、3、4、5
//        int[] v = {0, 3, 4, 5, 6};            //商品的价值3、4、5、6
//        int bagV = 8;                            //背包大小
//        int[][] dp = new int[5][9];                    //动态规划表
//
//        for (int i = 1; i <= 4; i++) {
//            for (int j = 0; j <= bagV; j++) {
//                if (j < w[i])
//                    dp[i][j] = dp[i - 1][j];
//                else
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
//            }
//        }
////        动态规划表的输出
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//
//        }
        System.out.println("===============经典背包问题 二维数组===================");

        int[] w1 = {2, 3, 4, 5};            //商品的体积2、3、4、5
        int[] v1 = {3, 4, 5, 6};            //商品的价值3、4、5、6
        int size = w1.length;
        int bagV1 = 8;                            //背包大小
        int[][] dp1 = new int[size][bagV1 + 1];                    //动态规划表

        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= bagV1; i++) {
            dp1[0][i] = w1[0] <= i ? v1[0] : 0;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= bagV1; j++) {
                dp1[i][j] = dp1[i - 1][j];
                if (w1[i] <= j)
                    dp1[i][j] = Math.max(dp1[i][j], dp1[i - 1][j - w1[i]] + v1[i]);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= bagV1; j++) {
                System.out.print(dp1[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("===============经典背包问题 一维数组===================");

        int[] w = {2, 3, 4, 5};            //商品的体积2、3、4、5
        int[] v = {3, 4, 5, 6};            //商品的价值3、4、5、6
        int bagV = 8;                            //背包大小
        int[] dp = new int[bagV + 1];                    //动态规划表

        // i是第几件物品 j是物品的价值
        for (int i = 1; i <= 4; i++) {
            for (int j = bagV; j >= w[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);  //装入某件物品 体积减少 价值增加
            }
        }

        System.out.print(dp[bagV]);
        System.out.println();
//        动态规划表的输出
        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println();


        System.out.println("=================一维数组==================");

        /**
         * 3 15
         *  5 16
         *  9 1
         *  8 15
         *  三种能量值 对应的愉悦值
         *  15能量值下能得到的最大愉悦值
         */
        int num = 3;
        int value = 15;
        int[] energy = {5, 9, 8};
        int[] pleasure_value = {16, 1, 15};
        int dp2[] = new int[value + 1];
        for (int i = 1; i < num + 1; i++) {
            for (int j = value; j >= energy[i - 1]; j--) {
                dp2[j] = Math.max(dp2[j], dp2[j - energy[i - 1]] + pleasure_value[i - 1]);
            }
        }

        for (int i = 0; i < dp2.length; i++) {
            System.out.print(dp2[i] + " ");
        }


        System.out.println();
        System.out.println("=================改编的二维数组==================");

        int[][] dp3 = new int[num][value + 1];


        for (int i = 0; i <= value; i++) {
            dp3[0][i] = energy[0] <= i ? pleasure_value[0] : 0;
        }

        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= value; j++) {
                dp3[i][j] = dp3[i - 1][j];
                if (energy[i] <= j)
                    dp3[i][j] = Math.max(dp3[i][j], dp3[i - 1][j - energy[i]] + pleasure_value[i]);
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= value; j++) {
                System.out.print(dp3[i][j] + " ");
            }
            System.out.println();

        }

    }

}
