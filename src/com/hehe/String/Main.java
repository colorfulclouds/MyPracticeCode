package com.hehe.String;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sLong = sc.nextLong();
        String res = getResult(sLong);
        System.out.println(res);


        //数字符串中指定字符的个数
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine().toUpperCase();
//        int count = 0;
//        String str1 = sc.nextLine().toUpperCase();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == str1.charAt(0)){
//                count++;
//            }
//        }
//        System.out.println(count);
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
