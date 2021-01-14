package com.hehe.ArrayAndList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumToTarget {

    public static void main(String[] args) {


        //3、和为 s 的连续正数序列
        System.out.println("=====3-1=====");
        List<int[]> res1 = sumToS(9);
        for (int[] i : res1) {
            System.out.print(i[0] + "~" + i[1]);
            System.out.println();
        }
        System.out.println("=====3-2=====");
        List<int[]> res2 = sumToS01(9);
        for (int[] i : res2) {
            System.out.print(i[0] + "~" + i[1]);
            System.out.println();
        }

        System.out.println("sum");
        int[] arr = {1,2,3,4,5};
        System.out.println(is(arr,7));
    }

    /**
     * 3-1、和为 s 的连续正数序列
     *
     * @param s
     * @return
     */
    public static List<int[]> sumToS(int s) {
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>(); //List<List<Integer>> result = new ArrayList<>();

        while (i < (1 + s) / 2) {// 因为序列至少要有两个数字，需要将i 增加到 （1+s）/2  的位置
            //差为1的连续序列，那么求和公式是(a0+an)*n/2
            int sum = (j - i + 1) * i + (j - i + 1) * (j - i) / 2;
            if (sum == s) {
                list.add(new int[]{i, j}); //List<Integer> list = new ArrayList<>(); 把 i->j 元素 全加进去
                j++;
            } else if (sum < s && i < ((1 + s) / 2)) {
                j++;
            } else if ((sum > s && i < ((1 + s) / 2)))
                i++;
        }
        return list;
    }


    /**
     * 3-2、和为 s 的连续正数序列  (滑动窗口)
     *
     * @param s
     * @return
     */
    public static List<int[]> sumToS01(int s) {
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>();
        int curSum = i + j;
        while (i < (1 + s) / 2) {
            if (curSum == s) {
                list.add(new int[]{i, j});
                j++;
                curSum += j;
            } else if (curSum < s ) { //&& i < (1 + s) / 2
                j++;
                curSum += j;
            } else if (curSum > s ) { //&& i < (1 + s) / 2
                curSum -= i;
                i++;
            }
        }
        return list;
    }
    public static boolean is(int[] a,int tar){
        int sum = 0;
        int i = 0;
        boolean b = isExist(a,i,sum,tar);
        return b;
    }

    public static boolean isExist(int[] arr,int i,int sum,int tar){
        while(i < arr.length){
            if(sum == tar)
                return true;
            return isExist(arr,i+1,sum,tar) || isExist(arr,i+1,sum + arr[i],tar);
        }
        return false;

    }


}

