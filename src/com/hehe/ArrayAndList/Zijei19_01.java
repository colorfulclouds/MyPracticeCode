package com.hehe.ArrayAndList;

import java.util.Scanner;

/*硬币个数问题
 *
 * */

public class Zijei19_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cost = in.nextInt();
        int re = 1024 - cost;
        int count = 0;
        int[] tmp = {64, 16, 4, 1};   //点睛处
        for (int i = 0; i < tmp.length; i++) {
            count += re / tmp[i];
            re = re % tmp[i];
        }
        System.out.println(count);

    }
}
//注意变量(count,re)的修改顺序  要把实例带入走一遍