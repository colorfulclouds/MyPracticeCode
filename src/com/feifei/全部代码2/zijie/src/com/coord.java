package com;

import java.util.Scanner;


public class coord {
    
    public static void getMinCoinCounts(int coinValue[], int coinKinds,
            int money) {
        // 存放每个金额需要的最小硬币数
        int[] coinUsed = new int[money + 1];
        // 当金额为0，初始化需要硬币数为0
        coinUsed[1] = 1;
        for (int i = 1; i <= money; i++) {
            // 申请一个变量存储临时的money,初始化无限大
            coinUsed[i]  = i;
            for (int j = 1; j <= coinKinds; j++) {
                if(coinValue[j-1]<=i){
                    int temp = coinUsed[i - coinValue[j-1]] + 1;
                    if(temp < coinUsed[i]){
                        coinUsed[i] = temp;
                    }
                }
            }
            System.out.println(i + "最小硬币数：" + coinUsed[i]);
        }

    }
    
    public static void main(String[] args) {
        int[] coinValue = new int[] { 64, 16, 4, 1 };
        
		Scanner sc = new Scanner(System.in);
		int money = 1024-sc.nextInt();
		
        coord.getMinCoinCounts(coinValue, coinValue.length, money);
    }
}