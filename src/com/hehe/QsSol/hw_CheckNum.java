package com.hehe.QsSol;


import java.util.ArrayList;
import java.util.Scanner;

public class hw_CheckNum {
    /**题目描述：
     * 多个序列 每个序列由N个10进制整数组成，数字之间以空格隔开，数字均为大于0小于100
     * 规则：
     * （1）相邻的数字是一位数和两位数交替出现，序列合法
     * （2）序列第一个和最后一个数是两位数，中间数字都是一位数，序列合法
     * （3）序列第一个和最后一个数是一位数，中间数字都是两位数，序列合法
     *
     * 输入多个序列，每个数字序列占一行
     * 检验多个序列是否合法 合法时返回true,不合法返回false 检验结果空格分开 行末无多余空格
     *
     * eg:
     * 1 2 3 4 5
     * 12 3 4 5 66
     * 1 22 33 44 5
     * 1 23 4 55 23
     * false true true false
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Boolean> array = new ArrayList<>();

        while (sc.hasNextLine()){   //每次接受一行数据，对每一行数据进行处理
            String[] tmp = sc.nextLine().split(" ");
            int[] arr = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                arr[i] = Integer.parseInt(tmp[i]);
            }
            Boolean b = (checkOne(arr) || checkTwo(arr));
            array.add(b);
            System.out.println(b + " ");
        }

//        System.out.println("111");
//        for (int i = 0; i < array.size() - 1; i++) {
//            System.out.print(array.get(i) + " ");
//        }
//        System.out.print(array.get(array.size() - 1));

    }

    //判断是否是两位和一位交替
    private static Boolean checkOne(int[] arr) {
        Boolean fore = arr[0] / 10 == 0;
        int index = 1;
        while (index < arr.length) {
            Boolean cur = arr[index] / 10 == 0;
            if (cur & fore) {
                fore = cur;
                index++;
            } else
                return false;
        }
        return true;
    }

//    判断是否是：首尾是两位 中间是一位 或者 首尾是一位 中间是两位
//    特殊情况是：序列只有两位
    private static boolean checkTwo(int[] arr) {
        Boolean head = arr[0] / 10 == 0;
        Boolean tail = arr[arr.length - 1] / 10 == 0;

        if (head == tail) {  //首尾相同 进一步判断
            if (arr.length == 2)  //只有两位 符合情况
                return true;
            int index = 1;
            while (index < arr.length - 1) {
                Boolean cur = arr[index] / 10 == 0;
                if (!(head & cur))   //第三位开始 和首尾与之后 相同的 返回false
                    return false;
                index++;
            }
            return true;
        } else   //首尾不同 不符合该情况 直接返回false
            return false;
    }


}
