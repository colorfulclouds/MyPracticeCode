package com.hehe.ArrayAndList;

import java.util.Scanner;
//您的代码已保存
//答案正确:恭喜！您提交的程序通过了所有的测试用例

/*
 * 数组切片  求切片（所有子数组中） 最小值和总和的乘积 的最大值
 * */
public class MinPlusSum {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //数组大小
//        int num = sc.nextInt();
//        int[] array = new int[num];
//        for (int i = 0; i < num; i++) {
//            array[i] = sc.nextInt();
//        }

        int[] array = {1,2,3};
        int num = array.length;


        //===========================可抽取的函数主体===============================
        //初始化当前最大值，全局变量
        int curMax = 0;
        //双循环进行切片
        for (int i = 0; i < num; i++) {
            int curMin = array[i];  //每次切片要将当前最小值默认成切片第一个值
            int curSum = 0;  //每次切片要将当前总和清零
//            System.out.println("+++++++++" + curMin);
            for (int j = i; j < num; j++) {
                if (array[j] == 0)
                    break;    //初值为零，遇0时，零是最小值，和任何数成绩都是零  若全部被break之后，返回结果 0
                curSum += array[j];
                if (curMin > array[j]){
                    curMin = array[j];
                }
                if (curMin * curSum > curMax){   //题意条件
                    curMax = curMin * curSum;
//                    System.out.println(curMax);
                }
            }
        }
        System.out.println(curMax);

//		Collections.sort(array);
//		for (int i = 0; i < num; i++) {
//			System.out.println(array.get(i));
//		}
    }

}

//3
//1 2 3
//10

