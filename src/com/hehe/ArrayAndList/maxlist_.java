package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class maxlist_ {

    /**
     * 求当前数组的最大值
     * @param list
     * @return
     */
    public static int max(List<Integer> list) {
        Collections.sort(list);
        int maxnum = list.get(list.size() - 1);
        return maxnum;
    }

    public static void main(String[] args) {
        //接收输入，先接受输入个数，再接收输入字符串
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        List<Integer> list = new ArrayList<Integer>();


        //遍历数组  依次输出  当前数组中最大的值
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(strs[i]));
            int max = max(list);
            System.out.print(max);

            //解决最后一个输出没有空格
            if (i <= n - 1)
                System.out.print(" ");
        }


    }
}
/*
 *
5
1 3 5 2 7
1 3 5 5 7
 *
 * */

