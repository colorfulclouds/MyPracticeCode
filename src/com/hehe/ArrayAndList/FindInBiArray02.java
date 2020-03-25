package com.hehe.ArrayAndList;

import java.util.Arrays;
import java.util.Scanner;
/*Array的便利  难度：**
 *（剑指offer）
 * java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。
 * sort
 * fill
 * equals
 *
 * */

public class FindInBiArray02 {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        OriginalArray(a);
        System.out.println(Arrays.deepToString(a));
        int rows = a.length;
        int column = a[0].length;
        Scanner sc = new Scanner(System.in);
//		while(sc.hasNext()){
        int num = sc.nextInt();
        System.out.println(FindInBiArray(a,rows,column,num));
//		}




        //打印二维数组

//		for (int i = 0; i <a.length; i++) {
//			for (int j = 0; j < a[i].length; j++) {
//				System.out.print(a[i][j]+"	");
//				if(j == a[i].length-1){
//					System.out.println("\n");
//				}
//
//			}
//
//		}



    }


    /*
     * 创建一个原始数组
     * 该数组从左往右递增  从上往下递增
     *
     * */
    public static void OriginalArray(int[][] a){

        //a.length 是行数
        //a[0].length 是0行的元素个数
        int index = 1;
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = index;
                ++index;
            }

        }
        System.out.println(index);
    }


    /*
     * 判断二维数组中是否有该整数
     * 思路：从右上角数字开始，若该数字大于所要查找的数字，剔除该数字所在的列，相反，剔除该数字所在行
     *       最后该数字在剩余数组的右上角
     * */
    public static boolean FindInBiArray(int a[][],int rows,int columns,int num){
        boolean found = false;
        if(a != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;

            //row是递增 [0-row]的角标都能满足
            //column是递减 column=0时要能进循环

            while (row<rows && column>=0) {
                if(a[row][column] == num){
                    found = true;
                    break;
                }else if(a[row][column]>num)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }


}




