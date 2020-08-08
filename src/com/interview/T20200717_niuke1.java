package com.interview;

import java.util.Scanner;

/**
 * 20200717牛客模拟考试
 * x/天 房租
 * 每天一个水果 已有f个水果 买的话 p元/个
 * 已有 d 元钱
 *
 * 求最多活多少天？
 */
public class T20200717_niuke1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();

        int res = 0;
        if(f > d/x)  //特殊情况的考虑！！！
            res =  d/x;
        else
            res = (d+f*p)/(x+p);

        System.out.println(res);
    }
}
