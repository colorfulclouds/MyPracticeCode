package com.hehe.ArrayAndList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class hw_CheckNum_fei {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Boolean> list = new ArrayList<>();
        while (sc.hasNext()) {
            String[] temp = sc.nextLine().split(" ");

            int[] arr = new int[temp.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }
            System.out.println(checkOne(arr) || checkTwo(arr));
            list.add(checkOne(arr) || checkTwo(arr));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print(list.get(list.size() - 1));
    }

    // 验证两位数与一位数交错出现
    public static boolean checkOne(int[] arr) {
        // 判断第一个数是否是一位数
        boolean check = arr[0] / 10 == 0;
        int index = 1;
        while (index < arr.length) {
            // 判断当前数是否是1位数
            boolean curCheck = arr[index] / 10 == 0;
            // 若跟前一数据相同，则不符合条件
            if (curCheck == check)
                return false;
            else
                check = curCheck;
            index++;
        }
        return true;
    }

    // 验证两端是两位数，中间全部为一位数
    public static boolean checkTwo(int[] arr) {
        boolean fisrt = arr[0] / 10 != 0;
        boolean end = arr[arr.length - 1] / 10 != 0;

        if (fisrt && end) {
            // 第一个数据与最后一个数据均为2位数时
            if (arr.length == 2)
                return true;
            // 判断中间数据是否全部是一位数
            for (int i = 1; i <= arr.length - 2; i++) {
                boolean curCheck = arr[i] / 10 == 0;
                if (!curCheck)
                    return false;
            }
        } else if (!fisrt && !end) {
            // 第一个数据与最后一个数据均为1位数时
            if (arr.length == 2)
                return true;
            //判断中间数据是否均为2位数
            for (int i = 1; i <= arr.length - 2; i++) {
                boolean curCheck = arr[i] / 10 != 0;
                if (!curCheck)
                    return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
