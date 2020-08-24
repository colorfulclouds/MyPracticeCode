package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//给定一个1到N的排列P1到PN（N为偶数），初始时Pi=i（1≤i≤N），现在要对排列进行M次操作，每次操作为以下两种中一种：
//①将排列的第1个数移到末尾；
//②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数。
//求经过这M次操作后得到的排列。

//        输入描述
//        第一行包含两个整数N和M，2≤N，M≤105。
//
//        第二行包含M个空格隔开的整数t1到tM，1≤ti≤2。若ti=1，则表示第i次操作为操作①；若ti=2，则表示第i次操作为操作②。
//
//        输出描述
//        输出N个空格隔开的整数，即经过M次操作后得到的排列。
//        样例输入
//        4 3
//        1 2 1
//        样例输出
//        2 1 4 3
//
//        提示
//        排列变化过程为：{1 2 3 4}->{2 3 4 1}->{3 2 1 4}->{2 1 4 3}。

/**
 * 对于 1~N 之间的数双操作 输出最后的变换结果
 * 通过率：55%
 */
public class T20200822_360_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  //1-N的数组
        int M = sc.nextInt();  //M次操作
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lst.add(i+1);
        }

        for (int i = 0; i < M; i++) {
            int op = sc.nextInt();
            if(op == 1)
                Option1(lst);
            if(op == 2)
                Option2(lst);
        }
        for(int i : lst)
            System.out.print(i + " ");

    }

    private static void Option1(ArrayList<Integer> lst) { //将排列的第1个数移到末尾
//        int tmp = lst.get(0);
//        lst.remove(0); //ArrayList的方法
//        lst.add(tmp);
        Collections.rotate(lst,1);  //数组旋转
    }


    private static void Option2(ArrayList<Integer> lst) { //交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数
        for (int i = 0; i < lst.size() - 1 ;) {
            Collections.swap(lst,i,i+1);   //Collections.swap
            i += 2;
        }
    }


}
