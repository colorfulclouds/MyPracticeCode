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
        Scanner sc = new Scanner(System.in);
        long sLong = sc.nextLong();
        String res = getResult(sLong);
        System.out.println(res);
    }

    public static String getResult(long slong) {
        StringBuilder sb = new StringBuilder();
        int first = 2;
        while (first <= slong) {  //注意等于的情况
            if (slong % first == 0) { //可以除尽时：1、到最后一个质数了  2、小于最后一个质数
                if (slong == first) {
                    sb.append(first).append(" ");
                    break;
                } else {
                    sb.append(first).append(" ");
                    slong /= first;
                }
            } else {
                first++;
            }
        }
        return sb.toString();
    }

}
