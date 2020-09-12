package com.hehe.Classic;

import java.util.Scanner;

/**
 * 输入描述:
 * 输入一个long型整数(180)
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。(2 2 3 3 5 )
 */
public class AllPrimeFactor {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long sLong = sc.nextLong();
//        String res = getResult(sLong);
//        System.out.println(res);
        System.out.println(getResult(100));
        System.out.println(getResult(1800));
        getResult01(100);
        System.out.println();
        getResult01(1800);
    }

    /**
     * 简
     * @param slong
     */
    public static void getResult01(long slong) {
        for (int i = 2; i <= slong ; i++) {
            while(slong % i == 0){
                System.out.print(i + " ");
                slong /= i;
            }
        }

    }
//======================================================================================================================
    public static String getResult(long slong) {
        StringBuilder sb = new StringBuilder();
        int first = 2;
        while (first <= slong) {  //注意等于的情况
            if (slong % first == 0) { //可以除尽时：1、到最后一个质数了  2、小于最后一个质数
                sb.append(first).append(" ");
                if (slong == first) {
                    break;
                } else {
                    slong /= first;
                }
            } else {
                first++;
            }
        }
        return sb.toString();
    }

}
