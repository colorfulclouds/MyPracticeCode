package com.hehe.ArrayAndList;

//package Jianzhi_Offer;

import java.util.Scanner;

public class SortAge {

    /**
     * 年龄数组ages[] 年龄出现的次数 tiemsOfAge[] 按某年龄出现次数 设置ages[] 即为ages[]排序
     * @param ages
     * @param len
     */
    public static void SortAge(int[] ages, int len) {

        // 非空判断
        if (ages == null || ages.length == 0) {
            System.out.println("输入为空");
        }

        int oldestAge = 99;
        int timesOfAge[] = new int[oldestAge + 1]; //辅助数组 统计次数

        //初始化辅助数组
        for (int i = 0; i < oldestAge; i++) {
            timesOfAge[i] = 0;
        }

        //统计
        for (int i = 0; i < len; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge)   //越界判断
                System.out.println("年龄越界");
            ++timesOfAge[age];
        }

        //两个数组同时循环来重置ages[]   (也即排序ages[])
        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {   //在某个年龄时，辅助数组该年龄有几个 就循环几次  在ages数组中插入几个该年龄
                ages[index] = i;
                ++index;
            }
        }

        //依次输出（已排序）
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] ages = new int[len];
        for (int i = 0; i < len; i++) {
            ages[i] = scan.nextInt();
        }

        SortAge(ages, len);
    }


}

