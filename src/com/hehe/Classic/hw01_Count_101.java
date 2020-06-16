package com.hehe.Classic;

import java.util.Scanner;

/**
 * 在数据流中 从右往左数比特块 （本题固定为5：101） 101的个数
 */
public class hw01_Count_101 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int flag = 7; //111
        int count = 0;
        int index = 0;
        boolean isFind = false;
        while (input != 0) {
            if ((input & flag) == 5) {
                count++;
                isFind = true;
            } else if(!isFind)   //(input & flag) != 5 而且还要 isFind==false 才能 index++
                index++;
            input >>>= 1;    //无符号数右移
        }
        if (!isFind)
            index = -1;
        System.out.println(count + " " + index);


    }
}
