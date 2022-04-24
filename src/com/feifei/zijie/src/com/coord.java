package com;

import java.util.Scanner;


public class coord {
    
    public static void getMinCoinCounts(int coinValue[], int coinKinds,
            int money) {
        // ���ÿ�������Ҫ����СӲ����
        int[] coinUsed = new int[money + 1];
        // �����Ϊ0����ʼ����ҪӲ����Ϊ0
        coinUsed[1] = 1;
        for (int i = 1; i <= money; i++) {
            // ����һ�������洢��ʱ��money,��ʼ�����޴�
            coinUsed[i]  = i;
            for (int j = 1; j <= coinKinds; j++) {
                if(coinValue[j-1]<=i){
                    int temp = coinUsed[i - coinValue[j-1]] + 1;
                    if(temp < coinUsed[i]){
                        coinUsed[i] = temp;
                    }
                }
            }
            System.out.println(i + "��СӲ������" + coinUsed[i]);
        }

    }
    
    public static void main(String[] args) {
        int[] coinValue = new int[] { 64, 16, 4, 1 };
        
		Scanner sc = new Scanner(System.in);
		int money = 1024-sc.nextInt();
		
        coord.getMinCoinCounts(coinValue, coinValue.length, money);
    }
}