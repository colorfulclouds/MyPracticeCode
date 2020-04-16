package com.hehe.SetMap;


import java.util.Scanner;
import java.util.TreeSet;

/**
 * 样例输入解释：
 * 样例有两组测试
 * 第一组是3个数字，分别是：2，2，1。
 * 第二组是11个数字，分别是：10，20，40，32，67，40，20，89，300，400，15。
 * <p>
 * N个1到1000之间的随机整数, 去重！排序！
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 * 输出描述:
 * 返回多行，处理后的结果
 */

/**
 * N个1到1000之间的随机整数, 去重！排序！
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 * 输出描述:
 * 返回多行，处理后的结果
 */

public class TreeSetSort_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1、TreeSet
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            TreeSet<Integer> treeSet = new TreeSet();
//            for (int i = 0; i < num; i++) {
//                treeSet.add(sc.nextInt());
//            }
//            for (Integer i:treeSet) {
//                System.out.println(i);
//            }
//        }


        //2、数组：10001的大小（hot bit）
        int num = 0;
        while (sc.hasNextInt()) {
            int[] arr = new int[1001];
            num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                arr[sc.nextInt()] = 1;    //将有的那个数字的位置上置为1 可以做到去重
            }

            for (int i1 = 0; i1 < arr.length; i1++) {
                if (arr[i1] == 1)
                    System.out.println(i1);
            }
        }
        sc.close();





    }
}

/*
*
3
2
2
1
11
10
20
40
32
67
40
20
89
300
400
15
* */

/*
1
2
10
15
20
32
40
67
89
300
400
*/