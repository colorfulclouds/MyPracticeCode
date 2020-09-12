package com.hehe.QsSol;

public class BuyBeerDrink {
    /**
     * 啤酒每罐2.3元，饮料每罐1.9元。小明买了若干啤酒和饮料，一共花了82.3元。
     *
     * 我们还知道他买的啤酒比饮料的数量少，请你计算他买了几罐啤酒。
     *
     * 注意：答案是一个整数。
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i * 2.3 <= 82.3; i++)   //i 啤酒
            for (int j = i + 1; i * 2.3 + j * 1.9 <= 82.3; j++) {  // j 饮料  买的啤酒比饮料的数量少
//                if (i * 2.3 + j * 1.9 >= 82.3 - 0.000001 && i * 2.3 + j * 1.9 <= 82.3 + 0.000001) {
                if (i * 2.3 + j * 1.9 == 82.3) {
                    System.out.println(i);
                }
            }
    }
}
